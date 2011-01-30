package example.regseam.session;

import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessages;

import example.regseam.entity.Grupa;
import example.regseam.entity.Wykladowca;

@Name("grupaHome")
public class GrupaHome extends EntityHome<Grupa> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long grupaId;

/*
	public void change() {
		Grupa grupa = super.getInstance();
		if (grupa.isOpen()) {
			grupa.setOpen(false);
			
		}
		else {
			grupa.setOpen(true);
//			ListaObecnosciHome obecnosc = new ListaObecnosciHome();
//			ListaObecnosci instance = new ListaObecnosci();
//			long czas = new Date().getTime();
//			for (Student s : grupa.getStudenci()) {
//				instance = new ListaObecnosci();
//				instance.setData(czas);
//				instance.setGrupa(grupa);
//				instance.setStudent(s);
//				instance.setUsprawiedliwienie("nieobecny");
//			}
//			obecnosc.setInstance(instance);
	@RequestParameter
	*/
	Long studentId;

	public boolean isEmpty(Long grId) {
		//TODO Poprawić
/*		this.grupaId = grId;
		//Grupa grupa = super.getInstance();
		//Grupa gr = (Grupa) super.getEntityManager().createQuery("select grupa from Grupa grupa where grupa.id = :gId").setParameter("gId", grId).getSingleResult();
		Grupa grupa = super.getEntityManager().find(Grupa.class, grupaId);
		java.util.Date dzisiaj = new java.util.Date();
		for (ListaObecnosci l : grupa.getObecnosci()) {
			if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
				for (Obecnosc o : l.getObecnosci()) {
					if (o.getStudent().getId() == studentId) {
						return false;
					}
				}
				break;
			}
		}
*/		return true;
	}
	
	public String persist(long id) {
		Grupa nowa = super.getInstance();
		String nazwa = nowa.getPrzedmiot();
		int numer = nowa.getNumerGrupy();
		List<?> grupy = super.getEntityManager().createQuery("select grupa from Grupa grupa").getResultList();
		for (Object grupa : grupy) {
			if (((Grupa) grupa).getPrzedmiot().equals(nazwa) && ((Grupa) grupa).getNumerGrupy() == numer) {
				StatusMessages.instance().add("Grupa o takiej nazwie i numerze już istnieje");
				return null;
			}
		}
		WykladowcaHome wh = new WykladowcaHome();
		Wykladowca wykladowca = wh.getCurrent(id);
		nowa.setWykladowca(wykladowca);
		return super.persist();
	}

	public String popraw() {
		Grupa poprawiany = super.getInstance();
		String nazwa = poprawiany.getPrzedmiot();
		int numer = poprawiany.getNumerGrupy();
		List<?> grupy = super.getEntityManager()
				.createQuery("select grupa from Grupa grupa")
				.getResultList();
		for (Object grupa : grupy) {
			if (((Grupa) grupa).getPrzedmiot().equals(nazwa)
					&& ((Grupa) grupa).getNumerGrupy() == numer
					&& ((Grupa) grupa).getId() != poprawiany.getId()) {
				StatusMessages.instance().add("Grupa o takiej nazwie i numerze już istnieje");
				return null;
			}
		}
		return super.update();
	}

	public String wyrzuc() {
		Grupa poprawiany = super.getInstance();
		if (poprawiany == null) {
			StatusMessages.instance().add("Nie udało się usunąć grupy");
			return null;
		}
		poprawiany.setFlaga(false);
		super.getEntityManager().persist(poprawiany);
		return super.update();
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
