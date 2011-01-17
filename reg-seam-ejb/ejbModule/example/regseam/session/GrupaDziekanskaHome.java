package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.GrupaDziekanska;

@Name("grupaDziekanskaHome")
public class GrupaDziekanskaHome extends EntityHome<GrupaDziekanska>
{
    @RequestParameter Long grupaDziekanskaId;

    @Override
    public Object getId()
    {
        if (grupaDziekanskaId == null)
        {
            return super.getId();
        }
        else
        {
            return grupaDziekanskaId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }

}
