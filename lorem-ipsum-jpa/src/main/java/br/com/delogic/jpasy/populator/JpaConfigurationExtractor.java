package br.com.delogic.jpasy.populator;

public interface JpaConfigurationExtractor {

	public EntityConfiguration extract(Class<?> entityType);

}
