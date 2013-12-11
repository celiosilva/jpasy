package br.com.delogic.loremipsumjpa;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class AccessTypeTest extends Assert {

	@Test
	public final void testGetValueRandom() {
		AccessType type = AccessType.RANDOM;

		LinkedList<String> valuesSelected = new LinkedList<String>();
		for (int i = 0; i < 100; i++) {
			valuesSelected.add(type.getValue(i, "1", "2", "3"));
		}

		// assert at least one of the values has been called
		assertTrue(valuesSelected.contains("1"));
		assertTrue(valuesSelected.contains("2"));
		assertTrue(valuesSelected.contains("3"));

		// testing if it ran on sequential access
		boolean sequentialAccess = true;
		String[] sequential = new String[] { "1", "2", "3" };
		for (int i = 0; i < valuesSelected.size(); i++) {
			if (!valuesSelected
					.get(i)
					.equals(sequential[i
							- (((int) (i / sequential.length)) * sequential.length)])) {
				sequentialAccess = false;
				break;
			}
		}
		assertFalse(sequentialAccess);

	}

	@Test
	public final void testGetValueSequential() {
		AccessType type = AccessType.SEQUENTIAL;

		LinkedList<String> valuesSelected = new LinkedList<String>();
		for (int i = 0; i < 100; i++) {
			valuesSelected.add(type.getValue(i, "1", "2", "3"));
		}

		// assert at least one of the values has been called
		assertTrue(valuesSelected.contains("1"));
		assertTrue(valuesSelected.contains("2"));
		assertTrue(valuesSelected.contains("3"));

		// testing if it ran on sequential access
		boolean sequentialAccess = true;
		String[] sequential = new String[] { "1", "2", "3" };
		for (int i = 0; i < valuesSelected.size(); i++) {
			if (!valuesSelected
					.get(i)
					.equals(sequential[i
							- (((int) (i / sequential.length)) * sequential.length)])) {
				sequentialAccess = false;
				break;
			}
		}
		assertTrue(sequentialAccess);

	}
}
