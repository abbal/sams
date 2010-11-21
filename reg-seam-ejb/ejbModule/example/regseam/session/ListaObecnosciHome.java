package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.ListaObecnosci;

@Name("listaObecnosciHome")
public class ListaObecnosciHome extends EntityHome<ListaObecnosci>
{
    @RequestParameter Long listaObecnosciId;

    @Override
    public Object getId()
    {
        if (listaObecnosciId == null)
        {
            return super.getId();
        }
        else
        {
            return listaObecnosciId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
