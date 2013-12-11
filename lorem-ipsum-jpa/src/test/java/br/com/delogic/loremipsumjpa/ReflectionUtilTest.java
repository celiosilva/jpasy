package br.com.delogic.loremipsumjpa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class ReflectionUtilTest extends Assert {

	@Test
	public final void testGetMethod() {
		Method method = ReflectionUtil.getMethod("getName", Person.class);
		assertNotNull(method);
		assertTrue(method.isAccessible());
	}

	@Test
	public final void testGetField() {
		Field field = ReflectionUtil.getField("name", Person.class);
		assertNotNull(field);
		assertTrue(field.isAccessible());
	}

	@Test
	public final void testGetReturnType() {
		assertTypeExpected("is_boolean", TestClass.class, Boolean.class);
		assertTypeExpected("get_byte", TestClass.class, Byte.class);
		assertTypeExpected("get_short", TestClass.class, Short.class);
		assertTypeExpected("get_char", TestClass.class, Character.class);
		assertTypeExpected("get_int", TestClass.class, Integer.class);
		assertTypeExpected("get_long", TestClass.class, Long.class);
		assertTypeExpected("get_float", TestClass.class, Float.class);
		assertTypeExpected("get_double", TestClass.class, Double.class);
		assertTypeExpected("get_string", TestClass.class, String.class);
		assertTypeExpected("get_date", TestClass.class, Date.class);
	}

	private void assertTypeExpected(String methodName, Class<?> type,
			Class<?> expected) {
		Method method = ReflectionUtil.getMethod(methodName, type);
		Class<?> returnType = ReflectionUtil.getTypeAsWrapper(method
				.getReturnType());
		assertNotNull(returnType);
		assertEquals(expected, returnType);
	}

	class TestClass {

		private boolean _boolean;
		private byte _byte;
		private short _short;
		private char _char;
		private int _int;
		private long _long;
		private float _float;
		private double _double;
		
		private String _string;
		private Date _date;

		public byte get_byte() {
			return _byte;
		}

		public void set_byte(byte _byte) {
			this._byte = _byte;
		}

		public short get_short() {
			return _short;
		}

		public void set_short(short _short) {
			this._short = _short;
		}

		public char get_char() {
			return _char;
		}

		public void set_char(char _char) {
			this._char = _char;
		}

		public long get_long() {
			return _long;
		}

		public void set_long(long _long) {
			this._long = _long;
		}

		public float get_float() {
			return _float;
		}

		public void set_float(float _float) {
			this._float = _float;
		}

		public double get_double() {
			return _double;
		}

		public void set_double(double _double) {
			this._double = _double;
		}

		public int get_int() {
			return _int;
		}

		public void set_int(int _int) {
			this._int = _int;
		}

		public boolean is_boolean() {
			return _boolean;
		}

		public void set_boolean(boolean _boolean) {
			this._boolean = _boolean;
		}

		public String get_string() {
			return _string;
		}

		public void set_string(String _string) {
			this._string = _string;
		}

		public Date get_date() {
			return _date;
		}

		public void set_date(Date _date) {
			this._date = _date;
		}

	}

}
