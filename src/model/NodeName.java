package model;

public class NodeName {
	private String name;
	private int phone;
	private NodeName nextName;

	public NodeName() {
		this.name = null;
		this.nextName = null;
		this.phone = 0;

	}
	
	public NodeName(String name, int phone) {
		this.name = name;
		this.nextName = null;
		this.phone = phone;

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

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public NodeName getNextName() {
		return this.nextName ;
	}

	public void setNextName(NodeName nextName) {
		this.nextName = nextName;
	}


}
