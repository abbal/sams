package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;

@Name("grupaHome")
public class GrupaHome extends EntityHome<Grupa> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long grupaId;

	public void change() {
		Grupa grupa = super.getInstance();
		if (grupa.isOpen()) {
			grupa.setOpen(false);
		}
		else {
			grupa.setOpen(true);
		}
		super.update();
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
	@Begin
	public void create() {
		super.create();
	}

}
