package br.com.delogic.jpasy.populator;

import org.junit.Assert;
import org.junit.Test;

import br.com.delogic.jpasy.populator.AccessType;
import br.com.delogic.jpasy.populator.AttributeGenerator;
import br.com.delogic.jpasy.populator.AttributeGeneratorVarargs;

public class AttributeGeneratorVarargsTest extends Assert {

	@Test
	public final void testAttributeGeneratorVarargsAccessTypeEArray() {
		AttributeGenerator<Integer> attributeGenerator = new AttributeGeneratorVarargs<Integer>(
				AccessType.SEQUENTIAL, 1, 2, 3, 4, 5);
		assertEquals(Integer.valueOf(1), attributeGenerator.generate(0, null));
		assertEquals(Integer.valueOf(2), attributeGenerator.generate(1, null));
		assertEquals(Integer.valueOf(3), attributeGenerator.generate(2, null));
		assertEquals(Integer.valueOf(4), attributeGenerator.generate(3, null));
		assertEquals(Integer.valueOf(5), attributeGenerator.generate(4, null));
		assertEquals(Integer.valueOf(1), attributeGenerator.generate(5, null));
		assertEquals(Integer.valueOf(1), attributeGenerator.generate(10, null));
		assertEquals(Integer.valueOf(3), attributeGenerator.generate(17, null));

		attributeGenerator = new AttributeGeneratorVarargs<Integer>(
				AccessType.RANDOM, 1, 2, 3, 4, 5);
		for (int i = 0; i < 100; i++) {
			assertNotNull(attributeGenerator.generate(i, null));
		}
	}

	@Test
	public final void testAttributeGeneratorVarargsEArray() {
		AttributeGeneratorVarargs<Integer> attributeGenerator = new AttributeGeneratorVarargs<Integer>(
				1, 2, 3, 4, 5);
		for (int i = 0; i < 100; i++) {
			assertNotNull(attributeGenerator.generate(i, null));
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testAttributeGeneratorNullValues() {
		AttributeGeneratorVarargs<String> attributeGeneratorVarargs = new AttributeGeneratorVarargs<String>(null);
		attributeGeneratorVarargs.toString();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testAttributeGeneratorNullValuesAndNullAccessType() {
		AttributeGeneratorVarargs<String> attributeGeneratorVarargs = new AttributeGeneratorVarargs<String>(null, null);
		attributeGeneratorVarargs.toString();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testAttributeGeneratorAccessTypeNullValues() {
		AttributeGeneratorVarargs<String> attributeGeneratorVarargs = new AttributeGeneratorVarargs<String>(AccessType.RANDOM, null);
		attributeGeneratorVarargs.toString();
	}

}
