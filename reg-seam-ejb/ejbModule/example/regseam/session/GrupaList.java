package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Grupa;

@Name("grupaList")
public class GrupaList extends EntityQuery<Grupa>
{
    public GrupaList()
    {
        setEjbql("select grupa from Grupa grupa");
    }
}
