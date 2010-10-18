package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Wykladowca;

@Name("wykladowcaList")
public class WykladowcaList extends EntityQuery<Wykladowca>
{
    public WykladowcaList()
    {
        setEjbql("select wykladowca from Wykladowca wykladowca");
    }
}
