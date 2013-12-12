package br.com.delogic.jpasy.populator;

public interface AttributeGenerator<E> {

	E generate(int index, AttributeConfiguration configuration);

}
