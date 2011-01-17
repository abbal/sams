package example.regseam.session;

public enum Usprawiedliwienia{
	USP ("usprawiedliwienie"),
	SP ("spóźnienie"), 
	UC ("ucieczka"), 
	ODR ("odrobione");

	
	private String tnLabel = null;
	
	private Usprawiedliwienia(String aLabel) {
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
