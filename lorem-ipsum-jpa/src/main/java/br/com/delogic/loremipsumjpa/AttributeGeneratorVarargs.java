package br.com.delogic.loremipsumjpa;

public class AttributeGeneratorVarargs<E> implements AttributeGenerator<E> {

	private final E[] values;
	private final AccessType accessType;

	public AttributeGeneratorVarargs(AccessType accessType, E... values) {
		Assert.notEmpty(accessType, "accessType");
		Assert.notEmpty(values, "values");
		this.values = values;
		this.accessType = accessType;
	}

	public AttributeGeneratorVarargs(E... values) {
		this(AccessType.RANDOM, values);
	}

	public E generate(int index, AttributeConfiguration configuration) {
		return accessType.getValue(index, values);
	}

}
