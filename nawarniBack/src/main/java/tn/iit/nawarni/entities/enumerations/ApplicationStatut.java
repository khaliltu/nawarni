package tn.iit.nawarni.entities.enumerations;

public enum ApplicationStatut {
	INPROGRESS("INPROGRESS"), ACCEPTED("ACCEPTED"), REJECTED("REJECTED");

	private String statut;

	private ApplicationStatut(String statut) {
		this.statut = statut;
	}

	public String getStatut() {
		return statut;
	}

}
