package example.regseam.session;

public enum DzienTygodnia {
	
	NIEDZIELA (1, "Niedziela"),
	PONIEDZIALEK (2, "Poniedziałek"),
	WTOREK (3, "Wtorek"),
	SRODA (4, "Środa"),
	CZWATREK (5, "Czwartek"),
	PIATEK (6, "Piątek"),
	SOBOTA (7, "Sobota");
	
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