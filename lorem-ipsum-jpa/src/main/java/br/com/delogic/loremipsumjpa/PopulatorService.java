package br.com.delogic.loremipsumjpa;

public interface PopulatorService {

	EntityGenerator prepare(Class<?> entityClass);

	void setAmountPerEntity(int i);

	void setAttributeGenerator(String string,
			AttributeGenerator<?> attributeGenerator);

}
