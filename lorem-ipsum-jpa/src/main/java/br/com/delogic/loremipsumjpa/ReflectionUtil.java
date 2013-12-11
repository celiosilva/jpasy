package br.com.delogic.loremipsumjpa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {

	private static final Map<String, Class<?>> primitiveTypes = new HashMap<String, Class<?>>();
	static {
		primitiveTypes.put("boolean", Boolean.class);
		primitiveTypes.put("byte", Byte.class);
		primitiveTypes.put("short", Short.class);
		primitiveTypes.put("char", Character.class);
		primitiveTypes.put("int", Integer.class);
		primitiveTypes.put("long", Long.class);
		primitiveTypes.put("float", Float.class);
		primitiveTypes.put("double", Double.class);
	}

	public static Method getMethod(String methodName, Class<?> type) {
		try {
			Method method = type.getDeclaredMethod(methodName);
			if (!method.isAccessible()) {
				method.setAccessible(true);
			}
			return method;
		} catch (Exception e) {
			throw new UnsupportedOperationException(
					String.format(
							"Method %s could not be proccessed. Check if this method is accessible.",
							methodName), e);
		}
	}

	public static Field getField(String fieldName, Class<?> type) {
		try {
			Field field = type.getDeclaredField(fieldName);
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			return field;
		} catch (Exception e) {
			throw new UnsupportedOperationException(String.format(
					"Field %s could not be proccessed.", fieldName), e);
		}
	}

	public static Class<?> getTypeAsWrapper(Class<?> type) {
		if (type.isPrimitive()) {
			return primitiveTypes.get(type.getName());
		}
		return type;
	}

}
