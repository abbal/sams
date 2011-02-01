/*
 * Projekt inżynierski Polsko-Japońskiej Wyższej Szkoły Technik Komputerowych w Gdańsku
 * "Projekt i implementacja systemu monitorowania obecności       studentów na zajęciach"
 * 
 * Autorzy:
 *     Adam Balcerzak
 *     Tomasz Masztalerz
 *     Piotr Niesiołowski
 *
 * Gdańsk, 2011
 *
 */

package example.regseam.session;

import org.jboss.seam.annotations.Name;

@Name("dzienTygodniaList")
public class DzienTygodniaList {
	private static final long serialVersionUID = 1L;

	public DzienTygodnia[] getDzienTygodnia() {
		return DzienTygodnia.values();
	}

}
