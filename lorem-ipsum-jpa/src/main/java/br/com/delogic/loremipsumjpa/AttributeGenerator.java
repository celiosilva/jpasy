package br.com.delogic.loremipsumjpa;

public interface AttributeGenerator<E> {

	E generate(int index, AttributeConfiguration configuration);

}
