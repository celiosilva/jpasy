package br.com.delogic.loremipsumjpa;

import java.util.Random;

public enum AccessType {

	RANDOM {
		Random random = new Random();

		@Override
		public <E> E getValue(int index, E... values) {
			return values[random.nextInt(values.length)];
		}
	},

	SEQUENTIAL {
		@Override
		public <E> E getValue(int index, E... values) {
			return values[index
					- (((int) (index / values.length)) * values.length)];
		}
	};

	public abstract <E> E getValue(int index, E... values);

}
