package example.regseam.session;

import org.jboss.seam.annotations.Name;

@Name("dzienTygodnia")
public enum DzienTygodnia {
	NIEDZIELA, PONIEDZIALEK, WTOREK, SRODA, CZWATREK, PIATEK, SOBOTA;

	public int get(DzienTygodnia dzien) {
		return dzien.ordinal() + 1;
	}

	public String name(int pos) {
		return DzienTygodnia.values()[pos - 1].toString();
	}
}