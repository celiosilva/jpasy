package br.com.delogic.jpasy.populator;

import java.lang.reflect.Method;

import org.junit.Test;

import br.com.delogic.jpasy.populator.AttributeConfiguration;
import br.com.delogic.jpasy.populator.AttributeGenerator;
import br.com.delogic.jpasy.populator.AttributeGeneratorVarargs;
import br.com.delogic.jpasy.populator.PopulatorService;

public class ApiUsageTest {

	@Test
	public void test() {
		for (Method m : Person.class.getMethods()) {
			System.out.println(m.getName());
		}
	}

	public void usageTest() throws InstantiationException,
			IllegalAccessException {

		PopulatorService populator = PopulatorService.class.newInstance();

		// configure the amount right on top of the service
		populator.setAmountPerEntity(100);

		populator.setAttributeGenerator("image",
				new AttributeGenerator<String>() {
					public String generate(int index,
							AttributeConfiguration configuration) {
						return "image.jpg";
					}
				});

		// populate simple class with no harness
		populator.prepare(Person.class).populate();

		// populate a simples class changing the amount
		populator.prepare(Person.class).setAmount(100).populate();

		// populate a simple class, changing the way an attribute is generated
		populator
				.prepare(Person.class)
				.setAttributeGenerator("name",
						new AttributeGenerator<String>() {
							public String generate(int index,
									AttributeConfiguration config) {
								return "A different String " + index;
							}
						}).populate();

		populator.prepare(Person.class).setAttributeGenerator("name",
				new AttributeGeneratorVarargs<String>("John", "Mary", "Paul"));

		AttributeConfiguration config = populator.prepare(Person.class)
				.getAttributeConfiguration("name");
		config.setNullable(true);
		config.getAttributeName();

	}

}
