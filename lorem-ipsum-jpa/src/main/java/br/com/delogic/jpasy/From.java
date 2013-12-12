package br.com.delogic.jpasy;

public interface From {

    <E> With<E> from(Class<E> clazz);

}
