package br.com.delogic.loremipsumjpa;

public interface EntityGenerator {

	void populate();

	EntityGenerator setAmount(int i);

	EntityGenerator setAttributeGenerator(String attributeName,
			AttributeGenerator<?> methodPopulator);

	AttributeConfiguration getAttributeConfiguration(String string);

}
