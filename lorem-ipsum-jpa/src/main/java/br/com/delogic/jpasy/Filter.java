package br.com.delogic.jpasy;

public interface Filter<E> {

    E equals();

    E notEquals();

    E like();

    E likeIgnoreCase();

    E notLike();

    E greaterThan();

    E greaterEqualsThan();

    E lessThan();

    E lessEqualsThan();

    E notNull();

    E isNull();

}
