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
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Obecnosc;

@Name("obecnoscList")
public class ObecnoscList extends EntityQuery<Obecnosc>{
	private static final long serialVersionUID = 1L;
    public ObecnoscList()
    {
        setEjbql("select obecnosc from Obecnosc obecnosc");
    }
}
