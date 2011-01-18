package example.regseam.session;

import java.sql.Date;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Obecnosc;
import example.regseam.entity.Student;

@Name("obecnoscHome")
public class ObecnoscHome extends EntityHome<Obecnosc> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long obecnoscId;

	@RequestParameter
	Long studentId;

	@RequestParameter
	Long grupaId;

	public void obecny() {
		Student student = (Student) super.getEntityManager().createQuery("select student from Student student where student.id = :sId").setParameter("sId", studentId).getSingleResult();
		Grupa grupa = (Grupa) super.getEntityManager().createQuery("select grupa from Grupa grupa where grupa.id = :gId").setParameter("gId", grupaId).getSingleResult();
		ListaObecnosci lista = null;
		java.util.Date dzisiaj = new java.util.Date();
		for (ListaObecnosci l : grupa.getObecnosci()) {
			if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
				lista = l;
				break;
			}
		}

		Obecnosc obecnosc = super.getInstance();
		obecnosc.setStudent(student);
		obecnosc.setListaObecnosci(lista);
		obecnosc.setUsprawiedliwienie("jest");
		super.persist();
	}

	@Override
	public Object getId() {
		if (obecnoscId == null) {
			return super.getId();
		} else {
			return obecnoscId;
		}
	}

	@Override
	@Begin(join=true)
	public void create() {
		super.create();
	}

}
