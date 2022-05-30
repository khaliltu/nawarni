package tn.iit.nawarni.entities.enumerations;

public enum InternshipType {
	ONEMONTH("ONEMONTH"), TWOMONTHS("TWOMONTHS"), PFA("PFA"), PFE("PFE");

	private String type;

	private InternshipType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
