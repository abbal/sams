package example.regseam.session;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Student;
import example.regseam.entity.Wykladowca;

@Name("wykladowcaHome")
public class WykladowcaHome extends EntityHome<Wykladowca>
{

	private static final long serialVersionUID = 1L;
	@RequestParameter 
    Long wykladowcaId;

    public Wykladowca getCurrent(long id) {
		EntityManager em = super.getEntityManager();
		Wykladowca wykladowca = (Wykladowca) em.createQuery("select wykladowca from Wykladowca wykladowca where wykladowca.id = :id").setParameter("id", id).getSingleResult();
		return wykladowca;
	}

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
