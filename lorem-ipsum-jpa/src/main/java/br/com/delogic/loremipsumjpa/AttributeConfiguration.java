package br.com.delogic.loremipsumjpa;

public class AttributeConfiguration {

	private final String attributeName;
	private int length;
	private boolean nullable;
	private int precision;
	private int scale;
	private boolean unique;
	private boolean isTransient;

	public AttributeConfiguration(String attributeName) {
		Assert.notEmpty(attributeName, "attributeName");
		this.attributeName = attributeName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public boolean isTransient() {
		return isTransient;
	}

	public void setTransient(boolean isTransient) {
		this.isTransient = isTransient;
	}

}
