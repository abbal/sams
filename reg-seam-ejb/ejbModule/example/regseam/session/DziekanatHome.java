package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Dziekanat;

@Name("dziekanatHome")
public class DziekanatHome extends EntityHome<Dziekanat>
{
    @RequestParameter Long dziekanatId;

    @Override
    public Object getId()
    {
        if (dziekanatId == null)
        {
            return super.getId();
        }
        else
        {
            return dziekanatId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
