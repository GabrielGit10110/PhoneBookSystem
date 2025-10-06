package model;

/**
 * Represents a node in a doubly linked list of characters for the phone book
 * structure.
 * Each node contains a character (letter) and maintains a reference to a
 * NameList
 * that stores all names starting with that particular letter.
 * 
 * <p>
 * This node is part of the hierarchical structure where characters serve as
 * indexes for organizing names alphabetically in the phone book.
 * </p>
 *
 * @author Gabriel
 * @version 1.0
 * @since 2024
 */
public class NodeChar {
	private char letter;
	private NodeChar nextChar;
	private NodeChar previousChar;
	private NameList nameList;

	/**
	 * Constructs an empty NodeChar with null character and no list associations.
	 * This constructor is useful for placeholder nodes or temporary instances.
	 */
	public NodeChar() {
		this.letter = '\0';
		this.nextChar = null;
		this.previousChar = null;
	}

	/**
	 * Constructs a NodeChar with the specified letter and initializes an empty
	 * NameList.
	 * The node is ready to be linked into the character list and store names
	 * starting
	 * with the given letter.
	 *
	 * @param letter the character this node represents
	 */
	public NodeChar(char letter) {
		this.letter = letter;
		this.nextChar = null;
		this.previousChar = null;
		this.nameList = new NameList(); // cria uma nova lista de nomes da letra especifica
	}

	/**
	 * Returns the character stored in this node.
	 *
	 * @return the character represented by this node
	 */
	public char getLetter() {
		return this.letter;
	}

	/**
	 * Sets the character for this node.
	 * 
	 * @deprecated Changing the letter of an existing node is not safe as it may
	 *             break the logical structure of the phone book. Letters should
	 *             remain constant
	 *             once assigned to maintain data integrity.
	 *
	 * @param letter the new character to set
	 */
	// nao e seguro permitir que o usuario mude a letra em um dos
	// nos, visto que ao fazer isso poderia quebrar a logica
	@Deprecated
	public void setLetter(char letter) {
		this.letter = letter;
	}

	/**
	 * Returns the next node in the character list.
	 *
	 * @return the next NodeChar in the sequence, or null if this is the last node
	 */
	public NodeChar getNextChar() {
		return this.nextChar;
	}

	/**
	 * Sets the reference to the next node in the character list.
	 *
	 * @param nextChar the next NodeChar in the sequence
	 */
	public void setNextChar(NodeChar nextChar) {
		this.nextChar = nextChar;
	}

	/**
	 * Returns the previous node in the character list.
	 *
	 * @return the previous NodeChar in the sequence, or null if this is the first
	 *         node
	 */
	public NodeChar getPreviousChar() {
		return this.previousChar;
	}

	/**
	 * Sets the reference to the previous node in the character list.
	 *
	 * @param previousChar the previous NodeChar in the sequence
	 */
	public void setPreviousChar(NodeChar previousChar) {
		this.previousChar = previousChar;
	}

	/**
	 * Returns the NameList associated with this character node.
	 * This list contains all names that start with the node's letter.
	 *
	 * @return the NameList containing names for this letter
	 */
	public NameList getNameList() {
		return this.nameList;
	}

	/**
	 * Sets the NameList for this character node.
	 * Use with caution as it replaces the entire list of names for this letter.
	 *
	 * @param nameList the new NameList to associate with this character
	 */
	public void setNameList(NameList nameList) {
		this.nameList = nameList;
	}
}
