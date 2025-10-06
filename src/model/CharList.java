package model;

/**
 * Represents a doubly linked list of characters that serves as the main index
 * for the phone book structure. This list maintains characters in alphabetical
 * order and provides efficient operations for managing letter groups.
 * 
 * <p>Each character node in this list points to a NameList containing all
 * names that start with that particular letter, creating a hierarchical
 * organization system for the phone book.</p>
 *
 * @author Gabriel
 * @version 1.0
 * @since 2024
 */
public class CharList {
	private NodeChar head;
	private NodeChar last;
	private int size;

	// append() Adiciona o value no final;
	// get() Retorna um no dado um index;
	// index() Retorna um indice de um value;
	// insert() Insere um value em uma determinada posicao;
	// remove() Remove um value dado o index;
	// size() Retorna o total de values;
	// isEmpty() Retorna true ou false se a lista estiver vazia;

	/**
	 * Constructs an empty CharList.
	 * Initializes head and last references to null and size to zero.
	 */
	public CharList() {
		this.head = null;
		this.last = null;
		this.size = 0;
	}

	/**
	 * Checks if the list is empty.
	 *
	 * @return true if the list contains no characters, false otherwise
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if a specific letter is present in the list.
	 *
	 * @param letter the character to search for
	 * @return true if the letter is found in the list, false otherwise
	 */
	public boolean isOnTheList(char letter) {
		NodeChar currentLetter = this.head;

		while (currentLetter != null) {
			if (currentLetter.getLetter() == letter) {
				return true;
			}
			currentLetter = currentLetter.getNextChar();
		}
		return false;
	}

	/**
	 * Inserts a new character into the list in alphabetical order.
	 * If the letter already exists, no action is taken.
	 *
	 * @param letter the character to be inserted
	 */
	public void insert(char letter) {
		NodeChar newChar = new NodeChar(letter); // o novo caractere

		// caso a lista esteja vazia
		if (isEmpty()) {
			this.head = newChar;
			this.last = newChar;
			this.size++;
			return;
		}

		NodeChar current = this.head; // um contador
		NodeChar previousChar = null; // um endereco antes do contador

		while (current != null && current.getLetter() < letter) {
			previousChar = current;
			current = current.getNextChar();
		}

		// caso a letra já exista na lista
		if (current != null && current.getLetter() == letter) {
			return;
		}

		// o novo caractere é inserido entre o contador
		// e o caractere anterior
		newChar.setPreviousChar(previousChar);
		newChar.setNextChar(current);

		// caso o while não tenha começado
		// previousChar será nulo
		// ou seja, a nova letra é menor que a primeira
		if (previousChar == null) {
			this.head = newChar;
		} else {
			previousChar.setNextChar(newChar);
		}

		// caso o while tenha chegado ao fim
		// current será nulo
		// ou seja, a nova letra é maior que o final
		if (current == null) {
			this.last = newChar;
		} else {
			current.setPreviousChar(newChar);
		}

		this.size++;
	}

	/**
	 * Retrieves an existing character node or creates a new one if it doesn't exist.
	 * This method ensures that a node for the specified letter always exists in the list.
	 *
	 * @param letter the character to retrieve or create
	 * @return the NodeChar associated with the specified letter
	 */
	public NodeChar getOrCreateChar(char letter) {
		NodeChar newChar = new NodeChar(letter); // o novo caractere

		// caso a lista esteja vazia
		if (isEmpty()) {
			this.head = newChar;
			this.last = newChar;
			this.size++;
			return newChar;
		}

		NodeChar current = this.head; // um contador
		NodeChar previousChar = null; // um endereco antes do contador

		while (current != null && current.getLetter() < letter) {
			previousChar = current;
			current = current.getNextChar();
		}

		// caso a letra já exista na lista
		if (current != null && current.getLetter() == letter) {
			return current;
		}

		// o novo caractere é inserido entre o contador
		// e o caractere anterior
		newChar.setPreviousChar(previousChar);
		newChar.setNextChar(current);

		// caso o while não tenha começado
		// previousChar será nulo
		// ou seja, a nova letra é menor que a primeira
		if (previousChar == null) {
			this.head = newChar;
		} else {
			previousChar.setNextChar(newChar);
		}

		// caso o while tenha chegado ao fim
		// current será nulo
		// ou seja, a nova letra é maior que o final
		if (current == null) {
			this.last = newChar;
		} else {
			current.setPreviousChar(newChar);
		}

		this.size++;
		return newChar;
	}

	/**
	 * Removes a letter from the list and cleans up all associated references.
	 *
	 * @param letter the character to be removed
	 * @throws IllegalArgumentException if the list is empty or the letter is not found
	 */
	public void remove(char letter) throws IllegalArgumentException {
		// nao faz nada se a lista for vazia
		if (isEmpty()) {
			throw new IllegalArgumentException("Lista vazia, nao pode remover elementos...");
		}

		// define o char a ser removido
		NodeChar toBeRemoved = get(letter);

		// se a lista so tem um item
		if (size == 1) {
			this.head = null;
			this.last = null;
		}

		// se o char for o primeiro
		else if (toBeRemoved == this.head) {
			// digo que a cabeca passa a ser o proximo item
			this.head = this.head.getNextChar();
			// tiro a referencia ao char antigo
			this.head.setPreviousChar(null);
		}

		// se o char for o ultimo
		else if (toBeRemoved == this.last) {
			// digo que o final passa a ser o item anterior
			this.last = this.last.getPreviousChar();
			// tiro a referencia ao char antigo
			this.last.setNextChar(null);
		}

		else {
			// pego o char uma letra antes
			NodeChar previousChar = toBeRemoved.getPreviousChar();
			// pego o char uma letra depois
			NodeChar nextChar = toBeRemoved.getNextChar();

			// troco as referencias
			previousChar.setNextChar(nextChar);
			nextChar.setPreviousChar(previousChar);
		}

		// libero todas as referencias para o garbage colector
		toBeRemoved.setPreviousChar(null);
		toBeRemoved.setNextChar(null);
		toBeRemoved.setLetter('\0');

		// diminuo o tamanho
		this.size--;
	}

	/**
	 * Clears the entire list, removing all characters and resetting the structure.
	 *
	 * @throws IllegalArgumentException if the list is already empty
	 */
	public void clear() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Lista ja esta vazia...");
		}

		this.head = null;
		this.last = null;
		this.size = 0;
	}

	/**
	 * Returns the node at the specified index in the list.
	 * Uses an optimization strategy by traversing from the head for indices
	 * in the first half and from the tail for indices in the second half.
	 *
	 * @param index the position of the node to retrieve (0-based)
	 * @return the NodeChar at the specified index
	 * @throws IllegalArgumentException if the list is empty
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public NodeChar get(int index) throws IllegalArgumentException, IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Nao existem itens para buscar na lista...");
		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index invalido: " + index);
		}

		if (index == 0) {
			return this.head;
		}

		if (index == size - 1) {
			return this.last;
		}

		if (index <= size / 2) {
			NodeChar newChar = this.head;

			for (int i = 0; i < index; i++) {
				newChar = newChar.getNextChar();
			}
			return newChar;
		} else {
			NodeChar newChar = this.last;

			for (int i = (size - 1); i > index; i--) {
				newChar = newChar.getPreviousChar();
			}

			return newChar;
		}
	}

	/**
	 * Returns the node associated with a specific letter.
	 *
	 * @param letter the character to search for
	 * @return the NodeChar associated with the specified letter
	 * @throws IllegalArgumentException if the list is empty or the letter is not found
	 */
	public NodeChar get(char letter) throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Nao existem letras na lista...");
		}

		NodeChar currentLetter = this.head;

		while (currentLetter != null) {
			if (currentLetter.getLetter() == letter) {
				return currentLetter;
			}

			currentLetter = currentLetter.getNextChar();
		}

		throw new IllegalArgumentException("Letra nao encontrada na lista...");
	}

	/**
	 * Returns the number of characters in the list.
	 *
	 * @return the size of the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Generates a string representation of the list.
	 * The output format is a comma-separated list of characters enclosed in square brackets.
	 *
	 * @return a string representation of the list
	 */
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder builder = new StringBuilder("[");
			NodeChar currentChar = this.head;

			builder.append(currentChar.getLetter());
			currentChar = currentChar.getNextChar();

			while (currentChar != null) {
				builder.append(", ").append(currentChar.getLetter());
				currentChar = currentChar.getNextChar();
			}

			builder.append("]");
			return builder.toString();
		}
	}

	/**
	 * Returns the first node in the list.
	 *
	 * @return the head node of the list, or null if the list is empty
	 */
	public NodeChar getHead() {
		return head;
	}

	/**
	 * Returns the last node in the list.
	 *
	 * @return the last node of the list, or null if the list is empty
	 */
	public NodeChar getLast() {
		return last;
	}

	/**
	 * Returns the number of characters in the list.
	 * This method provides an alternative to size() for consistency with other getter methods.
	 *
	 * @return the size of the list
	 */
	public int getSize() {
		return size;
	}
}
