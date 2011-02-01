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
