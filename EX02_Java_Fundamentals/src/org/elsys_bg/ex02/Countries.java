package org.elsys_bg.ex02;

import java.util.HashMap;
import java.util.Map;

public class Countries {
	private Map<String, Integer> countries = new HashMap<String, Integer>();

	public Countries() {

	}

	public Countries(Map<String, Integer> countries) {
		this.countries = countries;
	}

	public void fillMap() {
		if (countries.isEmpty()) {
			this.countries.put("Bulgaria", 7500000);
			this.countries.put("Germany", 80780000);
			this.countries.put("China", 1363950000);
			this.countries.put("Sealand", 50);
		}

	}

	public void findCountries(int population) {
		System.out.println("Listing countries with population greater than "
				+ population);
		for (Map.Entry<String, Integer> entry : countries.entrySet()) {
			if (entry.getValue() > population) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}
	}
}
