package example.regseam.session;

import java.util.ArrayList;
import java.sql.Date;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Obecnosc;
import example.regseam.entity.Student;

@Name("listaObecnosciHome")
public class ListaObecnosciHome extends EntityHome<ListaObecnosci> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long listaObecnosciId;

	@RequestParameter
	Long grupaId;

	public void nowa() {
		Grupa grupa = (Grupa) super.getEntityManager().createQuery("select grupa from Grupa grupa where grupa.id = :gId").setParameter("gId", grupaId).getSingleResult();
		ListaObecnosci lista = super.getInstance();
		lista.setObecnosci(new ArrayList<Obecnosc>());
		lista.setGrupa(grupa);
		java.util.Date dzisiaj = new java.util.Date();
		lista.setData(new Date(dzisiaj.getTime()));
		super.persist();

		for (Student s : grupa.getStudenci()) {
			ObecnoscHome oh = new ObecnoscHome();
			Obecnosc o = oh.getInstance();
			o.setListaObecnosci(super.getInstance());
			o.setStudent(s);
			o.setUsprawiedliwienie("nieobecny");
			super.getEntityManager().persist(o);
		}

		if (grupa.isOpen()) {
			grupa.setOpen(false);
			
		}
		else {
			grupa.setOpen(true);
		}
		super.getEntityManager().persist(grupa);
	}

	@Override
	public Object getId() {
		if (listaObecnosciId == null) {
			return super.getId();
		} else {
			return listaObecnosciId;
		}
	}

	@Override
	@Begin(join=true)
	public void create() {
		super.create();
	}

}
