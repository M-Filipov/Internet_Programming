package org.elsys.ex01.fundamentals;

public class Main {
	
	public static void main(String[] args) {
		Mujaga gej = new Mujaga("Gej", 18, 737);
		
		for (int i = 0; i < 100; i++) {
			gej.lift(12);
		}
		
		System.out.println("Gej's strength = " + gej.getStrength());
		
		Mujaga ivan = new Mujaga("Ivan", 18, 9001);
		
		if (ivan.equals(gej)) {
			System.out.println("Gej and Ivan are the same person?!?");
		} else {
			System.out.println("Ivan is too strong to be gej");
		}
	}
}
