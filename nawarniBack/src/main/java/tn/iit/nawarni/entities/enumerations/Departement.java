package tn.iit.nawarni.entities.enumerations;

public enum Departement {
	INFORMATIQUE("INFORMATIQUE"), PREPARATOIRE("PREPARATOIRE"), INDUSTRIEL("INDUSTRIEL"), MECANIQUE("MECANIQUE"),
	CIVIL("CIVIL"), PROCEDES("PROCEDES"), ELECTRIQUE("ELECTRIQUE");

	private String departement;

	private Departement(String departement) {
		this.departement = departement;
	}

	public String getDepartement() {
		return departement;
	}

}
