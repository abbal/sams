package example.regseam.session;

import java.text.DateFormat;
import java.util.Date;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Student;
import example.regseam.entity.Wykladowca;

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
			ListaObecnosciHome obecnosc = new ListaObecnosciHome();
			ListaObecnosci instance = new ListaObecnosci();
			long czas = new Date().getTime();
			for (Student s : grupa.getStudenci()) {
				instance = new ListaObecnosci();
				instance.setData(czas);
				instance.setGrupa(grupa);
				instance.setStudent(s);
				instance.setUsprawiedliwienie("nieobecny");
			}
			obecnosc.setInstance(instance);
		}
		super.update();
	}
	
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
	@Begin
	public void create() {
		super.create();
	}

}
