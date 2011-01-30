package example.regseam.session;

import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessages;

import example.regseam.entity.GrupaDziekanska;

@Name("grupaDziekanskaHome")
public class GrupaDziekanskaHome extends EntityHome<GrupaDziekanska> {
	private static final long serialVersionUID = 1L;
	@RequestParameter
	Long grupaDziekanskaId;

	@Override
	public String persist() {
		GrupaDziekanska nowy = super.getInstance();
		String nazwa = nowy.getNazwa();
		List<?> grupyDziekanskie = super
				.getEntityManager()
				.createQuery(
						"select grupaDziekanska from GrupaDziekanska grupaDziekanska")
				.getResultList();
		for (Object grupaDziekanska : grupyDziekanskie) {
			if (((GrupaDziekanska) grupaDziekanska).getNazwa().equals(nazwa)) {
				StatusMessages.instance().add(
						"Grupa dziekańska o podanej nazwie już istnieje");
				return null;
			}
		}
		return super.persist();
	}

	@Override
	public Object getId() {
		if (grupaDziekanskaId == null) {
			return super.getId();
		} else {
			return grupaDziekanskaId;
		}
	}



	@Override
	@Begin(join = true)
	public void create() {
		super.create();
	}

}
