package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Wykladowca;

@Name("wykladowcaHome")
public class WykladowcaHome extends EntityHome<Wykladowca>
{
    @RequestParameter Long wykladowcaId;

    @Override
    public Object getId()
    {
        if (wykladowcaId == null)
        {
            return super.getId();
        }
        else
        {
            return wykladowcaId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
