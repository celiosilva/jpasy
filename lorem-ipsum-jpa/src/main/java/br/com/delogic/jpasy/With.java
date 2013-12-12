package br.com.delogic.jpasy;

public interface With<E> {

    Filter<E> attrb();

    Filter<E> andAttribute();

    Filter<E> orAttribute();

    Get<E> get();

    Then then();

    E orderByAsc();

    E orderByDesc();

}
