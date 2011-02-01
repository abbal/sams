/*
 * Projekt inżynierski Polsko-Japońskiej Wyższej Szkoły Technik Komputerowych w Gdańsku
 * "Projekt i implementacja systemu monitorowania obecności       studentów na zajęciach"
 * 
 * Autorzy:
 *     Adam Balcerzak
 *     Tomasz Masztalerz
 *     Piotr Niesiołowski
 *
 * Gdańsk, 2011
 *
 */

package example.regseam.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import example.regseam.entity.Grupa;
import example.regseam.entity.GrupaDziekanska;
import example.regseam.entity.Student;

@Scope(ScopeType.SESSION)
@Name("studenciDoGrupy")
public class StudenciDoGrupy implements Serializable{
	private static final long serialVersionUID = 1L;
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
