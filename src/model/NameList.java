package model;

/**
 * Represents a singly linked list for storing names in alphabetical order.
 * This class provides methods to insert, remove, search for, and manage names
 * while maintaining the sorted order of the list.
 */
public class NameList {
	private NodeName head;
	private NodeName last;
	private int size;

	// insertName() - insere um nome em ordem alfabetica
	// getName() - retorna o indice se o nome existir na lista
	// removeName() - remove um nome
	// clear() - remove todos os nomes da lista
	// clear(letter) - remove todos os nomes com a letra especifica

	public NameList() {
		this.head = null;
		this.last = null;
		this.size = 0;

	}

	/**
	 * Inserts a new name into the list while maintaining alphabetical order.
	 * If the name already exists in the list, no action is taken.
	 *
	 * @param name The name to be inserted.
	 * @throws IllegalArgumentException if the name already exists in the list.
	 */
	public void insertName(String name, int phone) throws IllegalArgumentException {
		NodeName newName = new NodeName(name, phone);

		// caso a lista seja vazia
		if (this.head == null) {
			this.head = newName;
			this.last = newName;
			this.size++;
			return;
		}

		// um contador que comeca no inicio e outro contador um endereço
		// abaixo
		NodeName nextName = this.head;
		NodeName previous = null;

		// continua até percorrer a lista inteira (nextName == null) ou até
		// achar um nome que seja maior ou igual ao nome a ser inserido
		// (faça esse loop enquanto valoratual < valoresperado == true, só
		// quando for false para de fato - ou seja só quando valoratual maior ou igual
		// a valor esperado)
		while (nextName != null && nextName.getName().compareTo(name) < 0) {
			previous = nextName;
			nextName = nextName.getNextName();
		}

		// se os nomes forem identicos, não insere na lista
		if (nextName != null && nextName.getName().compareTo(name) == 0) {
			throw new IllegalArgumentException("Nome ja existe na lista...");
		}

		// caso o nome novo seja menor que o primeiro nome
		if (previous == null) {
			newName.setNextName(this.head);
			this.head = newName;

		}
		// caso contrário
		else {
			// o nó anterior aponta para o novo nó
			previous.setNextName(newName);
			// o nó novo aponta para o próximo nó
			newName.setNextName(nextName);

			// caso o próximo nó seja vazio (previou era o último nó)
			if (nextName == null) {
				// o último nó agora é o novo nó
				this.last = newName;
			}

		}
		this.size++;

	}

	/**
	 * Searches for a name and returns its index in the list.
	 *
	 * @param name The name to search for.
	 * @return The index of the name in the list.
	 * @throws IllegalArgumentException if the name does not exist in the list.
	 */
	public int index(String name) throws IllegalArgumentException {
		int index = 0;

		NodeName currentName = this.head;
		while (currentName != null) {
			if (currentName.getName().equalsIgnoreCase(name)) {
				return index;

			}

			currentName = currentName.getNextName();
			index++;
		}

		throw new IllegalArgumentException("Nome nao existe na lista");
	}

	/**
	 * Searches for a name and returns the NodeName object.
	 *
	 * @param name The name to search for.
	 * @return The NodeName object containing the name, or null if not found.
	 */
	private NodeName findNode(String name) {
		NodeName loop = this.head;
		while (loop != null) {
			if (loop.getName().equalsIgnoreCase(name)) {
				return loop;
			}
			loop = loop.getNextName();
		}
		return null;
	}

	/**
	 * Checks if a specific name is present in the list.
	 *
	 * @param name The name to check.
	 * @return true if the name is in the list, false otherwise.
	 */
	public boolean isOnTheList(String name) {
		NodeName loop = findNode(name);

		return loop != null;
	}

	/**
	 * Retrieves the NodeName at the specified index.
	 *
	 * @param index The index of the node to retrieve.
	 * @return The NodeName object at the given index.
	 * @throws IndexOutOfBoundsException if the index is out of bounds (less than 0 or greater than or equal to the size).
	 */
	public NodeName get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Indice fora do limite: " + index);
		}

		NodeName loop = this.head;
		for (int i = 0; i < index; i++) {
			loop = loop.getNextName();
		}

		return loop;

	}

	/**
	 * Retrieves the NodeName object for a specific name.
	 *
	 * @param name The name to search for.
	 * @return The NodeName object associated with the name.
	 * @throws IllegalArgumentException if the name does not exist in the list.
	 */
	public NodeName get(String name) throws IllegalArgumentException {
		NodeName loop = findNode(name);

		if (loop != null) {
			return loop;

		} else {
			throw new IllegalArgumentException("Nome nao existe na lista...");

		}
	}

	/**
	 * Removes a name from the list.
	 *
	 * @param name The name to be removed.
	 * @throws IllegalArgumentException if the list is empty or the name does not exist in the list.
	 */
	public void removeName(String name) throws IllegalArgumentException {
		// caso a lista seja vazia
		// avisa o usuario
		if (this.head == null) {
			throw new IllegalArgumentException("Lista vazia, remocao impossivel");
		}

		// define o nome a ser removido
		// e um ponteiro um endereco a baixo
		NodeName toBeRemoved = this.head;
		NodeName previous = null;

		while (toBeRemoved != null && toBeRemoved.getName().compareTo(name) < 0) {
			previous = toBeRemoved;
			toBeRemoved = toBeRemoved.getNextName();
		}

		// checa se o nome existe na lista ou nao
		if (toBeRemoved == null || toBeRemoved.getName().compareTo(name) != 0) {
			throw new IllegalArgumentException("Nome nao existe na lista");

		}

		// caso o nome esteja no inicio
		if (previous == null) {
			this.head = this.head.getNextName();
		} else {
			// caso esteja no meio de dois nomes
			NodeName next = toBeRemoved.getNextName();
			previous.setNextName(next);

			// caso esteja no fim
			if (next == null) {
				this.last = previous;
			}
		}

		// auxilio ao garbage collector
		toBeRemoved.setNextName(null);
		toBeRemoved.setName(null);
		this.size--;

	}

	/**
	 * Removes all names from the list, making it empty.
	 */
	public void clear() {
		this.head = null;
		this.last = null;
		this.size = 0;

	}

	/**
	 * Returns the first node in the list.
	 *
	 * @return The head node of the list, or null if the list is empty.
	 */
	public NodeName getHead() {
		return this.head;
	}

	/**
	 * Returns the number of names in the list.
	 *
	 * @return The size of the list.
	 */
	public int getSize() {
		return this.size;

	}

}
