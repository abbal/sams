package example.regseam.session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
				nieobecny.setObecnosc("Nieobecny");
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

	public String popraw() {
		Student poprawiany = super.getInstance();
		String index = poprawiany.getIndeks();
		List<?> studenci = super.getEntityManager().createQuery("select student from Student student").getResultList();
		for (Object student : studenci) {
			if (((Student) student).getIndeks().equals(index) && ((Student) student).getId() != poprawiany.getId()) {
				StatusMessages.instance().add("Student o podanym indeksie już istnieje");
				return null;
			}
		}
		return super.update();
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

	public String wyrzuc() {
		Student poprawiany = super.getInstance();
		if (poprawiany == null) {
			StatusMessages.instance().add("Nie udało się usunąć studenta");
			return null;
		}
		poprawiany.setFlaga(false);
		super.getEntityManager().persist(poprawiany);
		return super.update();
	}

}
