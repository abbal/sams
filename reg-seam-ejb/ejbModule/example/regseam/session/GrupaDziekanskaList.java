package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.GrupaDziekanska;

@Name("grupaDziekanskaList")
public class GrupaDziekanskaList extends EntityQuery<GrupaDziekanska>
{
    public GrupaDziekanskaList()
    {
        setEjbql("select grupaDziekanska from GrupaDziekanska grupaDziekanska");
    }
}
