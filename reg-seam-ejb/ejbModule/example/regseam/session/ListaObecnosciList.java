package example.regseam.session;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.ListaObecnosci;

@Name("listaObecnosciList")
public class ListaObecnosciList extends EntityQuery<ListaObecnosci> {
	private static final long serialVersionUID = 1L;

	public ListaObecnosciList() {
		setEjbql("select listaObecnosci from ListaObecnosci listaObecnosci");
	}

	public List<ListaObecnosci> listaStudenta(long id) {
		List<ListaObecnosci> lista = super.getResultList();
		List<ListaObecnosci> student = new ArrayList<ListaObecnosci>();
		for (ListaObecnosci lo : lista) {
			if (lo.getId() == id) {
				student.add(lo);
			}
		}
		return student;
	}
}
