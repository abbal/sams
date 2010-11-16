package example.regseam.session;

import org.jboss.seam.annotations.Name;

@Name("dzienTygodnia")
public enum DzienTygodnia {
	NIEDZIELA(0, "Niedziela"), 
	PONIEDZIALEK (1, "Poniedziałek"), 
	WTOREK  (2, "Wtorek"), 
	SRODA  (3, "Środa"), 
	CZWATREK (4, "Czwartek"), 
	PIATEK  (5, "Piątek"), 
	SOBOTA  (6, "Sobota");
	
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