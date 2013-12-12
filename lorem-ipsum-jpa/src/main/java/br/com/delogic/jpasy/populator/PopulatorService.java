package br.com.delogic.jpasy.populator;

public interface PopulatorService {

	EntityGenerator prepare(Class<?> entityClass);

	void setAmountPerEntity(int i);

	void setAttributeGenerator(String string,
			AttributeGenerator<?> attributeGenerator);

}
