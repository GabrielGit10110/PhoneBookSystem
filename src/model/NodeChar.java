package model;


public class NodeChar {
	private char letter;
	private NodeChar nextChar;
	private NodeChar previousChar;
	private NameList nameList;

	public NodeChar() {
		this.letter = '\0';
		this.nextChar = null;
		this.previousChar = null;

	}

	public NodeChar(char letter) {
		this.letter = letter;
		this.nextChar = null;
		this.previousChar = null;
		this.nameList = new NameList(); // cria uma nova lista de nomes da letra especifica

	}

	public char getLetter() {
		return this.letter;

	}

	// nao e seguro permitir que o usuario mude a letra em um dos
	// nos, visto que ao fazer isso poderia quebrar a logica
	@Deprecated
	public void setLetter(char letter) {
		this.letter = letter;

	}

	public NodeChar getNextChar() {
		return this.nextChar;

	}

	public void setNextChar(NodeChar nextChar) {
		this.nextChar = nextChar;

	}

	public NodeChar getPreviousChar() {
		return this.previousChar;

	}

	public void setPreviousChar(NodeChar previousChar) {
		this.previousChar = previousChar;

	}

	public NameList getNameList() {
		return this.nameList;	

	}

	public void setNameList(NameList nameList) {
		this.nameList = nameList;

	}

}
