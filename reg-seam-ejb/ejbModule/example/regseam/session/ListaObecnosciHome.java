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
		Student student = null;
        ListaObecnosci lista = super.getInstance(); //new ListaObecnosci();
        lista.setStudent(student);
        for (Grupa g : student.getStudenciGrupy()) {
                if (g.getId() == grupaId) {
                        lista.setGrupa(g);
                        break;
                }
        }
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