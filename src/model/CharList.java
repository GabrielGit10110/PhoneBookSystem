package model;

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

	public CharList() {
		this.head = null;
		this.last = null;
		this.size = 0;
	}

	/**
	 * Checks if the list is empty
	 *
	 * @return True if It is, False otherwise
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;

		} else {
			return false;

		}
	}

	/**
	 * Checks if an specific letter is on the list
	 *
	 * @param letter The lookup letter
	 *
	 * @return True if the letter is the list, False otherwise
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
	 * Inserts a new character inside the list in
	 * alphabetical order
	 *
	 * @param letter The letter that will be inserted
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
	 * checks if the letter already exists in the list,
	 * if It doesn't, create a new letter
	 *
	 * @param The lookup letter
	 * @return The node with the letter adress
	 *
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
	 * Remove a letter from the list
	 *
	 * @param letter The letter that will be removed
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
	 * Cuts the head of the list and clean It
	 */
	public void clear() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Lista ja esta vazia...");

		}

		this.head = null;
		this.last = null;
		this.size = 0;
	}

	// get com indices (0 - 25, A - Z)
	/**
	 * Returns the adress of a letter basead on an index
	 *
	 * @param index The lookup index
	 * @return The node adress of the letter
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

	// get com letras
	/**
	 * Returns the node adress of a specific letter
	 *
	 * @param letter The lookup letter
	 * @Return The node adress of the letter
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
	 * Returns the size of the list
	 *
	 * @return Returns the size
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Converts the list to a string format for visualization
	 *
	 * @return The list in String format
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

	public NodeChar getHead() {
		return head;
	}

	public NodeChar getLast() {
		return last;
	}

	/**
	 * For ease of use (size() does the same thing)
	 *
	 * @return The size of the list
	 */
	public int getSize() {
		return size;
	}

}
