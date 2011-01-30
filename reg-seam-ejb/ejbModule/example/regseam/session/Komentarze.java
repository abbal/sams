package example.regseam.session;

public enum Komentarze{
	USP ("usprawiedliwiony"),
	SP ("spóźnienie"), 
	UC ("ucieczka"), 
	ODR ("odrobione");

	
	private String aLabel;
	
	private Komentarze(String aLabel) {
		this.aLabel = aLabel;
	}
	public String getLabel() {
		return aLabel;
	}
	
	@Override
	public String toString() {
		return getLabel();
	}

}
