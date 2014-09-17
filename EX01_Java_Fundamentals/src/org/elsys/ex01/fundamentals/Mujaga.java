package org.elsys.ex01.fundamentals;
public class Mujaga {
	private String name;
	private int strength;
	private int age;

	public Mujaga(String name, int age, int strength) {
		this.name = name;
		this.age = age;
		this.strength = strength;
	}

	public void lift(int kg){
		this.strength += kg / 2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Mujaga)) {
			return false;
		}

		Mujaga that = (Mujaga) obj;

		return this.name.equals(that.name) && this.getAge() == that.getAge()
				&& this.getStrength() == that.getStrength();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}