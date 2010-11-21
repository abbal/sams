package example.regseam.session;

public enum DzienTygodnia {
	 
	PONIEDZIALEK (0, "Poniedziałek"), 
	WTOREK  (1, "Wtorek"), 
	SRODA  (2, "Środa"), 
	CZWATREK (3, "Czwartek"), 
	PIATEK  (4, "Piątek"), 
	SOBOTA  (5, "Sobota"),
	NIEDZIELA(6, "Niedziela");
	
	private String ivLabel = null;
	private int ivOridinal = -1;


	private DzienTygodnia(int aOrdinal, String aLabel) {
		ivOridinal = aOrdinal;
		ivLabel = aLabel;
	}

	public String getLabel() {
		return ivLabel;
	}
	
	@Override
	public String toString() {
		return getLabel();
	}

	public int getOridinal() {
		return ivOridinal;
	}

}