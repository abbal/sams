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
import example.regseam.entity.Wykladowca;

@Name("wykladowcaList")
public class WykladowcaList extends EntityQuery<Wykladowca>
{
    public WykladowcaList()
    {
        setEjbql("select wykladowca from Wykladowca wykladowca  where wykladowca.flaga is true");
    }
}
