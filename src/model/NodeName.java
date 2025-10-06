package model;

/**
 * Represents a node in a singly linked list of names for the phone book
 * structure.
 * Each node contains a name, phone number, and a reference to the next name
 * node
 * in the alphabetical sequence.
 * 
 * <p>
 * This node is part of the NameList structure that organizes names
 * alphabetically within each letter group in the phone book.
 * </p>
 *
 * @author Gabriel
 * @version 1.0
 * @since 2024
 */
public class NodeName {
	private String name;
	private int phone;
	private NodeName nextName;

	/**
	 * Constructs an empty NodeName with null name, zero phone, and no next
	 * reference.
	 * This constructor is useful for placeholder nodes or temporary instances.
	 */
	public NodeName() {
		this.name = null;
		this.nextName = null;
		this.phone = 0;
	}

	/**
	 * Constructs a NodeName with the specified name and phone number.
	 * The node is ready to be linked into the name list in alphabetical order.
	 *
	 * @param name  the name to be stored in this node
	 * @param phone the phone number associated with this name
	 */
	public NodeName(String name, int phone) {
		this.name = name;
		this.nextName = null;
		this.phone = phone;
	}

	/**
	 * Returns the name stored in this node.
	 *
	 * @return the name stored in this node
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the phone number associated with this name.
	 *
	 * @return the phone number stored in this node
	 */
	public int getPhone() {
		return this.phone;
	}

	/**
	 * Sets the phone number for this name node.
	 * This operation is safe as it doesn't affect the alphabetical ordering.
	 *
	 * @param phone the new phone number to associate with this name
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * Returns the next node in the name list.
	 *
	 * @return the next NodeName in the alphabetical sequence, or null if this is
	 *         the last node
	 */
	public NodeName getNextName() {
		return this.nextName;
	}

	/**
	 * Sets the reference to the next node in the name list.
	 * This method is used to maintain the linked list structure.
	 *
	 * @param nextName the next NodeName in the sequence
	 */
	public void setNextName(NodeName nextName) {
		this.nextName = nextName;
	}
}
