package controller;

import model.*;

public class TestPhoneList {

	public TestPhoneList() {
		super();
	}

	public void beginTest() {
		try {
			PhoneBook newPB = new PhoneBook();

			newPB.addName("Waldo");
			newPB.addName("Ziraldo");
			newPB.addName("Wesley");

			String list = newPB.toString();
			System.out.println(list);
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}

	}
}
