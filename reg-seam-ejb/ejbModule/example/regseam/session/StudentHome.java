package example.regseam.session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessages;

import example.regseam.entity.Grupa;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Obecnosc;
import example.regseam.entity.Student;

@Name("studentHome")
public class StudentHome extends EntityHome<Student> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long studentId;

	public Student getCurrent(long id) {
		return (Student) super.getEntityManager().createQuery("select student from Student student where student.id = :id").setParameter("id", id).getSingleResult();
	}

	public List<Obecnosc> obecnyDzis(Long sId) {
		this.studentId = sId;
		Student student = (Student) super.getEntityManager().createQuery("select student from Student student where student.id = :id").setParameter("id", sId).getSingleResult();
		List<Grupa> grupy = student.getStudenciGrupy();
		List<Obecnosc> obecnosci = student.getObecnosci();
		java.util.Date dzisiaj = new java.util.Date();
		List<Obecnosc> result = new ArrayList<Obecnosc>();
		Obecnosc nieobecny;
		ListaObecnosci listaTmp;
		int cnt = 0;
		for (Grupa g : grupy) {
			cnt++;
			listy : for (ListaObecnosci l : g.getObecnosci()) {
				if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
					for (Obecnosc o :obecnosci) {
						if (o.getListaObecnosci().getId() == l.getId()) {
							result.add(o);
							break listy;
						}
					}
				}
			}
			if (result.size() < cnt) {
				listaTmp = new ListaObecnosci();
				listaTmp.setGrupa(g);
				nieobecny = new Obecnosc();
				nieobecny.setListaObecnosci(listaTmp);
<<<<<<< HEAD
				nieobecny.setObecnosc("nieobecny");
=======
				nieobecny.setUsprawiedliwienie("Nieobecny");
>>>>>>> 6d188089eb0732a6cd126942791e4423eab74f62
				result.add(nieobecny);
			}
		}
		return result;
	}

	@Override
	public String persist() {
		Student nowy = super.getInstance();
		String index = nowy.getIndeks();
		List<?> studenci = super.getEntityManager().createQuery("select student from Student student").getResultList();
		for (Object student : studenci) {
			if (((Student) student).getIndeks().equals(index)) {
				StatusMessages.instance().add("Student o podanym indeksie już istnieje");
				return null;
			}
		}
		return super.persist();
	}

	@Override
	public Object getId() {
		if (studentId == null) {
			return super.getId();
		} else {
			return studentId;
		}
	}

	@Override
	@Begin(join=true)
	public void create() {
		super.create();
	}
	@Override
	@End
	public String remove() {
		try {
			super.remove();
			} catch (Exception e) {
			return null;
			}
			return "done";
		}

}
