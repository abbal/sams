package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.ListaObecnosci;

@Name("listaObecnosciList")
public class ListaObecnosciList extends EntityQuery<ListaObecnosci> {
	private static final long serialVersionUID = 1L;

	public ListaObecnosciList() {
		setEjbql("select listaObecnosci from ListaObecnosci listaObecnosci");
	}

}
