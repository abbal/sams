package example.regseam.session;

public enum TytulyNaukowe {
	INZ ("inżynier"), 
	MGR ("magister"),
	DR ("doktor"),
	DR_HAB ("doktor habilitowany"), 
	PROF("profesor"); 
	
	private String tnLabel = null;
	
	private TytulyNaukowe(String aLabel) {
		tnLabel = aLabel;
	}
	public String getLabel() {
		return tnLabel;
	}
	
	@Override
	public String toString() {
		return getLabel();
	}
}
