package br.com.delogic.loremipsumjpa;

import java.util.HashMap;
import java.util.Map;

public class EntityConfiguration {

	private final Class<?> entityType;
	private final Map<String, AttributeConfiguration> attributesConfiguration = new HashMap<String, AttributeConfiguration>();

	public EntityConfiguration(Class<?> entityType) {
		Assert.notEmpty(entityType, "entityType");
		this.entityType = entityType;
	}

	public Class<?> getEntityType() {
		return entityType;
	}

	public AttributeConfiguration getAttributeConfiguration(String attributeName) {
		Assert.notEmpty(attributeName, "attributeName");
		return Assert.exits(attributesConfiguration.get(attributeName),
				attributeName);
	}

}
