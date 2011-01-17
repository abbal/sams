package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;
import example.regseam.entity.Wykladowca;

@Name("grupaHome")
public class GrupaHome extends EntityHome<Grupa> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long grupaId;

	public String persist(long id) {
		Grupa grupa = super.getInstance();
		WykladowcaHome wh = new WykladowcaHome();
		Wykladowca wykladowca = wh.getCurrent(id);
		grupa.setWykladowca(wykladowca);
		super.persist();
		return null;
	}

	@Override
	public Object getId() {
		if (grupaId == null) {
			return super.getId();
		} else {
			return grupaId;
		}
	}

	@Override
	@Begin(join=true)
	public void create() {
		super.create();
	}

}
