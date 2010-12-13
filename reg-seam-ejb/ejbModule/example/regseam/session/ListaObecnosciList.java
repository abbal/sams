package example.regseam.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Student;

@Name("listaObecnosciList")
public class ListaObecnosciList extends EntityQuery<ListaObecnosci> {
	private static final long serialVersionUID = 1L;

	public ListaObecnosciList() {
		setEjbql("select listaObecnosci from ListaObecnosci listaObecnosci");
	}

	public List<ListaObecnosci> listaStudenta(long studentId) {
		List<ListaObecnosci> lista = super.getResultList();
		List<ListaObecnosci> student = new ArrayList<ListaObecnosci>();
		for (ListaObecnosci lo : lista) {
			if (lo.getStudent().getId() == studentId) {
				student.add(lo);
			}
		}
		return student;
	}

	public List<ListaObecnosci> listaGrupy(long grupaId) {
		List<ListaObecnosci> lista = super.getResultList();
		List<ListaObecnosci> grupa = new ArrayList<ListaObecnosci>();
		for (ListaObecnosci lo : lista) {
			if (lo.getGrupa().getId() == grupaId) {
				grupa.add(lo);
			}
		}
		return grupa;
	}

	public List<Student> listaStudentow(long grupaId) {
		List<ListaObecnosci> lista = super.getResultList();
		List<Student> studenci = new ArrayList<Student>();
		for (ListaObecnosci lo : lista) {
			if (lo.getGrupa().getId() == grupaId) {
				for (Student s : lo.getGrupa().getStudenci()) {
					studenci.add(s);
				}
			}
		}
		return studenci;
	}

	public String godzina(long listaId) {
		List<ListaObecnosci> lista = super.getResultList();
		for (ListaObecnosci lo : lista) {
			if (lo.getId() == listaId) {
				return (new Date(lo.getData())).toString();
			}
		}
		return null;
	}

}
