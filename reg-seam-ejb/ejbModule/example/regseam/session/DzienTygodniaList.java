package example.regseam.session;

import org.jboss.seam.annotations.Name;

@Name("dzienTygodniaList")
public class DzienTygodniaList {
	private static final long serialVersionUID = 1L;

	public DzienTygodnia[] getDzienTygodnia() {
		return DzienTygodnia.values();
	}

}
