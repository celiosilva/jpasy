package br.com.delogic.loremipsumjpa;

public interface JpaConfigurationExtractor {

	public EntityConfiguration extract(Class<?> entityType);

}
