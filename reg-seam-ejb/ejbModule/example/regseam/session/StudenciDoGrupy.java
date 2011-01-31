package example.regseam.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;

import example.regseam.entity.Grupa;
import example.regseam.entity.GrupaDziekanska;
import example.regseam.entity.Student;

@Scope(ScopeType.SESSION)
@Name("studenciDoGrupy")
public class StudenciDoGrupy {
	@In 
	EntityManager entityManager;

	private List<GrupaDziekanska> lista;

	public List<GrupaDziekanska> getLista() {
		return lista;
	}
	public void setLista(List<GrupaDziekanska> lista) {
		this.lista = lista;
	}

	public void zapisz(long id) {
		Grupa grupa = entityManager.find(Grupa.class, id);
		Set<Student> zestaw = new HashSet<Student>(grupa.getStudenci());
		for (GrupaDziekanska grupaDziekanska : lista) {
			for (Student student : grupaDziekanska.getStudenci()) {
				zestaw.add(student);
			}
		}
		List<Student> listaStudentów = new ArrayList<Student>(zestaw);
		grupa.setStudenci(listaStudentów);
		entityManager.persist(grupa);
	}

}