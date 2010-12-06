package example.regseam.session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	public boolean isEmpty(long studentID) {
		Student student = (Student) super.getEntityManager().createQuery("select student from Student student where student.id = :sId").setParameter("sId", studentID).getSingleResult();
		List<Grupa> grupy = student.getStudenciGrupy();
		List<Grupa> otwarte = new ArrayList<Grupa>();
		for (Grupa grupa : grupy) {
			if (grupa.isOpen()) {
				otwarte.add(grupa);
			}
		}
		List<?> lista = super.getEntityManager().createQuery("select listaobecnosci from ListaObecnosci listaobecnosci where listaobecnosci.student= :stud").setParameter("stud", student).getResultList();
		for (Object item : lista) {
			ListaObecnosci obecnosc = (ListaObecnosci) item;
			Calendar dzisiaj = Calendar.getInstance();
			dzisiaj.setTime(new Date());
			for (Grupa grupa : otwarte) {
				if (obecnosc.getGrupa().equals(grupa)) {
					Calendar dzien = Calendar.getInstance();
					dzien.setTime(new Date(obecnosc.getData()));
					boolean rok = dzien.get(Calendar.YEAR) == dzisiaj.get(Calendar.YEAR) ? true : false;
					boolean miesiac = dzien.get(Calendar.MONTH) == dzisiaj.get(Calendar.MONTH) ? true : false;
					boolean dni = dzien.get(Calendar.DATE) == dzisiaj.get(Calendar.DATE) ? true : false;
					if (rok && miesiac && dni) {
						return false;
					}
				}
			}
		}
		return true;
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
