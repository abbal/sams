package example.regseam.session;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessages;

import example.regseam.entity.Student;
import example.regseam.entity.Wykladowca;

@Name("wykladowcaHome")
public class WykladowcaHome extends EntityHome<Wykladowca>
{

	private static final long serialVersionUID = 1L;
	@RequestParameter 
    Long wykladowcaId;

	public Wykladowca getCurrent(long id) {
		EntityManager em = super.getEntityManager();
		Wykladowca wykladowca = (Wykladowca) em
				.createQuery(
						"select wykladowca from Wykladowca wykladowca where wykladowca.id = :id")
				.setParameter("id", id).getSingleResult();
		return wykladowca;
	}

	@Override
	public String persist() {
		Wykladowca nowy = super.getInstance();
		String imie = nowy.getImie();
		String nazwisko = nowy.getNazwisko();
		List<?> wykladowcy = super.getEntityManager()
				.createQuery("select wykladowca from Wykladowca wykladowca")
				.getResultList();
		for (Object wykladowca : wykladowcy) {
			if (((Wykladowca) wykladowca).getImie().equals(imie)
					&& ((Wykladowca) wykladowca).getNazwisko().equals(nazwisko)) {
				StatusMessages.instance().add("Taki wykładowca już istnieje");
				return null;
			}
		}
		return super.persist();
	}

	public String popraw() {
		Wykladowca poprawiany = super.getInstance();
		String imie = poprawiany.getImie();
		String nazwisko = poprawiany.getNazwisko();
		List<?> wykladowcy = super.getEntityManager()
				.createQuery("select wykladowca from Wykladowca wykladowca")
				.getResultList();
		for (Object wykladowca : wykladowcy) {
			if (((Wykladowca) wykladowca).getImie().equals(imie)
					&& ((Wykladowca) wykladowca).getNazwisko().equals(nazwisko) 
					&& ((Wykladowca) wykladowca).getId() != poprawiany.getId()) {
				StatusMessages.instance().add("Taki wykładowca już istnieje");
				return null;
			}
		}
		return super.update();
	}

	public String wyrzuc() {
		Wykladowca poprawiany = super.getInstance();
		if (poprawiany == null) {
			StatusMessages.instance().add("Nie udało się usunąć wykładowcy");
			return null;
		}
		poprawiany.setFlaga(false);
		super.getEntityManager().persist(poprawiany);
		return super.update();
	}

	@Override
	public Object getId() {
		if (wykladowcaId == null) {
			return super.getId();
		} else {
			return wykladowcaId;
		}
	}

	@Override
	@Begin
	public void create() {
		super.create();
	}

}
