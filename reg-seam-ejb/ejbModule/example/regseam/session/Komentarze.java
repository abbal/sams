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
