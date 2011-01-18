package example.regseam.session;

import java.util.ArrayList;
import java.sql.Date;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.transaction.EntityTransaction;

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

/*
	public void obecny() {
//		long teraz = new Date().getTime();
//		long pozniej = teraz + 1800;
//		String query = "select listaObecnosci from ListaObecnosci listaObecnosci where listaObecnosci.studentid" + studentId + " and listaObecnosci.grupaid=" + grupaId + " and data>" + teraz + " and data<" + pozniej;
		Student student = (Student) super.getEntityManager().createQuery("select student from Student student where student.id = :sId").setParameter("sId", studentId).getSingleResult();
		Grupa grupa = (Grupa) super.getEntityManager().createQuery("select grupa from Grupa grupa where grupa.id = :gId").setParameter("gId", grupaId).getSingleResult();
//		ListaObecnosci listaObecnosci = (ListaObecnosci) super.getEntityManager().createQuery(query).getSingleResult();
		ListaObecnosci lista = super.getInstance();
		lista.setStudent(student);
		lista.setGrupa(grupa);
		lista.setData((new Date().getTime()));
//		super.setInstance(listaObecnosci);
//		ListaObecnosci lista = super.getInstance();
//		lista.setUsprawiedliwienie("obecny");
*/
	public void nowa() {
		Grupa grupa = super.getEntityManager().find(Grupa.class, grupaId);
		super.getEntityManager().refresh(grupa);
		java.util.Date dzisiaj = new java.util.Date();
		for (ListaObecnosci l : grupa.getObecnosci()) {
			if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
				grupa.setOpen(true);
				super.getEntityManager().persist(grupa);
				return;
			}
		}
		
		if (!grupa.isOpen()) {
			ListaObecnosci lista = super.getInstance();
			lista.setObecnosci(new ArrayList<Obecnosc>());
			lista.setGrupa(grupa);
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
			
			grupa.setOpen(true);
			super.getEntityManager().persist(grupa);
		}
	}

	public void zamknij() {
		Grupa grupa = super.getEntityManager().find(Grupa.class, grupaId);
		super.getEntityManager().refresh(grupa);
		java.util.Date dzisiaj = new java.util.Date();
		
		for (ListaObecnosci l : grupa.getObecnosci()) {
			if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
				grupa.setOpen(false);
				super.getEntityManager().persist(grupa);
				return;
			}
		}
	}

	public void odrzuc() {
		Grupa grupa = super.getEntityManager().find(Grupa.class, grupaId);
		super.getEntityManager().refresh(grupa);
		java.util.Date dzisiaj = new java.util.Date();
		for (ListaObecnosci l : grupa.getObecnosci()) {
			if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
				for (Obecnosc o : l.getObecnosci()) {
					Student s = o.getStudent();
					s.getObecnosci().remove(o);
					super.getEntityManager().persist(s);
					super.getEntityManager().remove(o);
				}
				super.getEntityManager().remove(l);
				grupa.getObecnosci().remove(l);
				grupa.setOpen(false);
				super.getEntityManager().persist(grupa);
				return;
			}
		}
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
