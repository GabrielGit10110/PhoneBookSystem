package controller;

import model.*;

public class TestPhoneList {

	public TestPhoneList() {
		super();
	}

	public void beginTest() {
		try {
			PhoneBook newPB = new PhoneBook();

			newPB.addName("Waldo", 1191234567);
			newPB.addName("Ziraldo", 1191234568);
			newPB.addName("Wesley", 1193216549);

			String list = newPB.toString();
			System.out.println(list);
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}

	}
}
