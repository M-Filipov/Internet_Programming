package org.elsys_bg.ex02;

public class Main {

	public static void main(String[] args) {

		System.out.println("----- Countries Exercise ------\n");
		final Countries c = new Countries();

		c.fillMap();
		c.findCountries(10000000);

		System.out.println("----- Input Exercise -----\n");

		final IOHandler i = new IOHandler();

		i.run();

	}
}
