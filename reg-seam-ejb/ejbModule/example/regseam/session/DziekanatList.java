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
import example.regseam.entity.Dziekanat;

@Name("dziekanatList")
public class DziekanatList extends EntityQuery<Dziekanat>
{
	private static final long serialVersionUID = 1L;

	public DziekanatList()
    {
        setEjbql("select dziekanat from Dziekanat dziekanat  where dziekanat.flaga is true");
    }
}
