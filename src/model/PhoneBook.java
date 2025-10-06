package model;

/**
 * Represents a hierarchical data structure for a phone book,
 * where names are organized alphabetically by their first letter.
 * It uses a main list of characters (CharList) that points to
 * a sub-list of names (NameList) for each letter, ensuring efficient
 * storage and retrieval of names.
 * 
 * <p>
 * This implementation provides O(1) access to name groups by first letter
 * and maintains alphabetical order within each letter group.
 * </p>
 *
 * @author Gabriel
 * @version 1.0
 * @since 2024
 */
public class PhoneBook {
	private CharList charList;

	/**
	 * Constructs a new empty PhoneBook.
	 * Initializes the main character list that will serve as the index
	 * for organizing names by their first letter.
	 */
	public PhoneBook() {
		this.charList = new CharList();
	}

	/*
	 * addName(String name) - adiciona um nome novo a lista
	 * removeName(String name) - remove um nome da lista
	 * findName(String name) - encontra um nome na lista
	 *
	 */

	/**
	 * Adds a new name to the phone book. The name is inserted into the
	 * correct sub-list based on its first letter, maintaining alphabetical order.
	 * If the letter group doesn't exist, it is automatically created.
	 *
	 * @param name  The name to be added
	 * @param phone The phone number associated with the name
	 */
	public void addName(String name, int phone) {
		String normalizedName = normalizeName(name);

		char firstLetter = normalizedName.charAt(0);

		// cria ou busca a referencia de um nó com um caractere
		NodeChar charNode = this.charList.getOrCreateChar(firstLetter);

		// aqui ficarão os nomes a serem adicionados
		NameList updateNameList = charNode.getNameList();

		// finalmente o novo nome é adicionado
		updateNameList.insertName(name, phone);
	}

	/**
	 * Safely updates a name while maintaining alphabetical order.
	 * This method removes the old name and inserts the new name in the correct
	 * alphabetical position, preserving the associated phone number.
	 *
	 * @param oldName the current name to be updated
	 * @param newName the new name to replace the old name
	 * @throws IllegalArgumentException if the old name is not found in the phone book
	 */
	public void updateName(String oldName, String newName) {
		String normalizedName = normalizeName(oldName);
		char firstLetter = normalizedName.charAt(0);
		NodeChar old = this.charList.get(firstLetter);
		NameList updateNameList = old.getNameList();

		int phone = updateNameList.findPhoneNumber(oldName);

		updateNameList.removeName(oldName);

		updateNameList.insertName(newName, phone);
	}

	/**
	 * Removes a name from the phone book. The method finds the correct
	 * sub-list based on the name's first letter and then removes the name
	 * from that list.
	 *
	 * @param name The name to be removed
	 * @throws IllegalArgumentException if the list for the name's first letter
	 *                                  does not exist or if the name is not found
	 *                                  in the list
	 */
	public void removeName(String name) {
		String normalizedName = normalizeName(name);

		char firstLetter = normalizedName.charAt(0);

		if (!this.charList.isOnTheList(firstLetter)) {
			throw new IllegalArgumentException("Lista com a letra: " + firstLetter + " nao existe");
		}

		NodeChar charNode = this.charList.get(firstLetter);

		NameList updateNameList = charNode.getNameList();

		updateNameList.removeName(name);
	}

	/**
	 * Checks if a specific name exists in the phone book.
	 *
	 * @param name The name to search for
	 * @return {@code true} if the name is found, otherwise {@code false}
	 * @throws IllegalArgumentException if the list for the name's first letter
	 *                                  does not exist
	 */
	public boolean findName(String name) {
		String normalizedName = normalizeName(name);

		char firstLetter = normalizedName.charAt(0);

		if (this.charList.isOnTheList(firstLetter)) {
			throw new IllegalArgumentException("Lista com a letra: " + firstLetter + " nao existe");
		}

		NodeChar charNode = this.charList.get(firstLetter);

		NameList updateNameList = charNode.getNameList();

		return updateNameList.get(name) != null;
	}

	/**
	 * Normalizes a given name by converting it to lowercase and
	 * removing leading/trailing whitespace. This ensures consistent
	 * handling of names regardless of input format.
	 *
	 * @param name The name to be normalized
	 * @return The normalized name string in lowercase without leading/trailing
	 *         spaces
	 */
	private String normalizeName(String name) {
		String normalizedName = name.trim();
		normalizedName = normalizedName.toLowerCase();
		return normalizedName;
	}

	/**
	 * Generates a string representation of the entire phone book.
	 * The output is formatted by first letter, with all associated names listed
	 * below it.
	 * Each name is displayed with its associated phone number.
	 *
	 * @return A formatted string showing all lists and their names, or "lista
	 *         vazia"
	 *         if the phone book is empty
	 */
	public String toString() {
		if (this.charList.isEmpty()) {
			return "lista vazia";
		}

		StringBuilder list = new StringBuilder();

		NodeChar builder = this.charList.getHead();

		while (builder != null) {
			list.append("Lista: ").append(builder.getLetter());
			list.append("\n");

			NameList thisNameList = builder.getNameList();
			NodeName nameNode = thisNameList.getHead();

			while (nameNode != null) {
				list.append(nameNode.getName());
				list.append(" - ").append(nameNode.getPhone());
				list.append("\n");
				nameNode = nameNode.getNextName();
			}

			builder = builder.getNextChar();
		}

		return list.toString();
	}
}
