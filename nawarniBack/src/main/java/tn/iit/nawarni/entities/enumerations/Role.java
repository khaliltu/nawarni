package tn.iit.nawarni.entities.enumerations;

public enum Role {
	ADMIN("ADMIN"), STUDENT("STUDNET"), ENTREPRISE("ENTREPRISE");

	private String role;

	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}
}
