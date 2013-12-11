package br.com.delogic.loremipsumjpa;

public class Assert {

	public static void notEmpty(Object object, String attribute) {
		if (object == null) {
			throw new IllegalArgumentException(attribute
					+ " cannot be null nor empty");
		}
	}

	public static void notEmpty(String object, String attribute) {
		if (object == null || object.isEmpty()) {
			throw new IllegalArgumentException(attribute
					+ " cannot be null nor empty");
		}
	}

	public static void notEmpty(Object[] object, String attribute) {
		if (object == null || object.length == 0) {
			throw new IllegalArgumentException(attribute
					+ " cannot be null nor empty");
		}
	}

	public static <E> E exits(E object, String attribute) {
		if (object == null) {
			throw new IllegalArgumentException(attribute + " doesn't exist");
		}
		return object;
	}

}
