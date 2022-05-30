package tn.iit.nawarni.entities.enumerations;

public enum PostType {
	INTERNSHIP("INTERNSHIP"), OTHER("OTHER");

	private String type;

	PostType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
