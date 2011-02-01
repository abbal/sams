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
@Name("tytulyNaukoweList")
public class TytulyNaukoweList {

		private static final long serialVersionUID = 1L;

		public TytulyNaukowe[] getTytulyNaukowe() {
			return TytulyNaukowe.values();
		}
}
