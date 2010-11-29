package example.regseam.session;

import java.util.Date;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Student;

@Name("listaObecnosciHome")
public class ListaObecnosciHome extends EntityHome<ListaObecnosci> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long listaObecnosciId;

	@RequestParameter
	Long studentId;

	@RequestParameter
	Long grupaId;

	public void obecny() {
		Student student = (Student) super.getEntityManager().createQuery("select student from Student student where student.id = :sId").setParameter("sId", studentId).getSingleResult();
		Grupa grupa = (Grupa) super.getEntityManager().createQuery("select grupa from Grupa grupa where grupa.id = :gId").setParameter("gId", grupaId).getSingleResult();
		ListaObecnosci lista = super.getInstance();
		lista.setStudent(student);
		lista.setGrupa(grupa);
		lista.setData((new Date().getTime()));
		super.persist();
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
