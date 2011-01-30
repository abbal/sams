package example.regseam.session;

import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessages;

import example.regseam.entity.Dziekanat;

@Name("dziekanatHome")
public class DziekanatHome extends EntityHome<Dziekanat> {
	private static final long serialVersionUID = 1L;
	@RequestParameter
	Long dziekanatId;

	@Override
	public String persist() {
		Dziekanat nowy = super.getInstance();
		String imie = nowy.getImie();
		String nazwisko = nowy.getNazwisko();
		List<?> pracownicy = super.getEntityManager()
				.createQuery("select dziekanat from Dziekanat dziekanat")
				.getResultList();
		for (Object pracownik : pracownicy) {
			if (((Dziekanat) pracownik).getImie().equals(imie)
					&& ((Dziekanat) pracownik).getNazwisko().equals(nazwisko)) {
				StatusMessages.instance().add("Taki pracownik dziekanatu już istnieje");
				return null;
			}
		}
		return super.persist();
	}

	@Override
	public Object getId() {
		if (dziekanatId == null) {
			return super.getId();
		} else {
			return dziekanatId;
		}
	}

	@Override
	@Begin
	public void create() {
		super.create();
	}

}
