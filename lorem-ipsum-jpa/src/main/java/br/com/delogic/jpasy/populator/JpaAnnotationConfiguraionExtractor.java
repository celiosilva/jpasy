package br.com.delogic.jpasy.populator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

public class JpaAnnotationConfiguraionExtractor implements
		JpaConfigurationExtractor {

	private final List<String> objectMethods = Arrays.asList("getClass",
			"hashCode", "equals", "toString", "notify", "notifyAll", "wait");

	public EntityConfiguration extract(Class<?> entityType) {
		Assert.notEmpty(entityType, "entityType");
		assertEntity(entityType);

		Map<String, AttributeConfiguration> attributesConfiguration = new HashMap<String, AttributeConfiguration>();
		Map<String, Method> entityMethods = new HashMap<String, Method>();
		
		List<Method> getters = getGetterMethods(entityType);

		for (Method getter : getters) {
			String attributeName = getAttributeName(getter);
			AttributeConfiguration config = null;
			if (isMethodAnnotated(getter)) {
				config = extractAttributeConfigurationFromMethod(getter);
			} else {
				Field field = ReflectionUtil
						.getField(attributeName, entityType);
				config = extractAttributeConfigurationFromAttribute(field,
						entityType);
			}

			attributesConfiguration.put(attributeName, config);
			entityMethods.put(attributeName, getter);
		}

		return null;
	}

	void assertEntity(Class<?> entityType) {
		if (!entityType.getClass().isAnnotationPresent(Entity.class)) {
			throw new IllegalArgumentException(String.format(
					"Class %s is not an entity", entityType));
		}
	}

	List<Method> getGetterMethods(Class<?> entityType) {
		List<Method> getters = new ArrayList<Method>();
		for (Method method : entityType.getMethods()) {
			if (!objectMethods.contains(method.getName())) {
				if (method.getName().startsWith("get")) {
					getters.add(method);
				}
			}
		}
		return getters;
	}

	boolean isMethodAnnotated(Method getter) {
		return getter.isAnnotationPresent(Column.class);
	}

	String getAttributeName(Method getter) {
		String attributeName = getter.getName();
		attributeName = Character.toUpperCase(attributeName.charAt(3))
				+ attributeName.substring(3);
		return attributeName;
	}

	AttributeConfiguration extractAttributeConfigurationFromMethod(Method getter) {
		AttributeConfiguration config = new AttributeConfiguration(
				getAttributeName(getter));
		// if this method is transient we don't care about its configuration
		if (getter.isAnnotationPresent(Transient.class)) {
			config.setTransient(true);
			return config;
		}
		fillConfiguration(config, getter.getAnnotation(Column.class));
		return config;
	}

	private void fillConfiguration(AttributeConfiguration config,
			Column annotation) {
		config.setLength(annotation.length());
		config.setNullable(annotation.nullable());
		config.setPrecision(annotation.precision());
		config.setScale(annotation.scale());
		config.setUnique(annotation.unique());
	}

	AttributeConfiguration extractAttributeConfigurationFromAttribute(
			Field field, Class<?> entityType) {
		AttributeConfiguration config = new AttributeConfiguration(
				field.getName());

		if (field.isAnnotationPresent(Transient.class)) {
			config.setTransient(true);
			return config;
		}

		if (field.isAnnotationPresent(Column.class)) {
			fillConfiguration(config, field.getAnnotation(Column.class));
		} else {
			config.setLength(0);
			config.setNullable(true);
			config.setPrecision(0);
			config.setScale(0);
			config.setUnique(false);
		}

		return config;
	}

}