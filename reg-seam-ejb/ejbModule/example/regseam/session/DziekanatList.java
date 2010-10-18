package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Dziekanat;

@Name("dziekanatList")
public class DziekanatList extends EntityQuery<Dziekanat>
{
    public DziekanatList()
    {
        setEjbql("select dziekanat from Dziekanat dziekanat");
    }
}
