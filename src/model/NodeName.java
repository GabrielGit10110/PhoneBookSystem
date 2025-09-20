package model;

public class NodeName {
	private String name;
	private NodeName nextName;

	public NodeName() {
		this.name = null;
		this.nextName = null;

	}
	
	public NodeName(String name) {
		this.name = name;
		this.nextName = null;

	}

	public String getName() {
		return this.name;
	}

	// nao faz sentido alterar o nome, pois
	// a lista precisa ficar em ordem alfabetica
	@Deprecated
	public void setName(String name) {
		this.name = name;
	}

	public NodeName getNextName() {
		return this.nextName ;
	}

	public void setNextName(NodeName nextName) {
		this.nextName = nextName;
	}


}
