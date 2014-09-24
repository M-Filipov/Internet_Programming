package org.elsys_bg.ex02;

import java.util.Scanner;

class IOHandler {

	private Scanner user_input;

	public IOHandler() {

	}

	public void run() {
		System.out.println("Type exit at any time to stop");
		while (true) {
			String line = getLine();
			changeCase(line, true);
			if (line.toLowerCase().equals("exit"))
				break;
		}
	}

	public String getLine() {
		user_input = new Scanner(System.in);

		String input = user_input.nextLine();

		return input;
	}

	public void changeCase(String line, boolean up) {
		if (up) {
			System.out.println(line.toUpperCase());
		} else {
			System.out.println(line.toLowerCase());
		}
	}
}
