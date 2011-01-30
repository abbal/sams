package example.regseam.session;

import java.sql.Date;

import javax.persistence.EnumType;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Grupa;
import example.regseam.entity.ListaObecnosci;
import example.regseam.entity.Obecnosc;
import example.regseam.entity.Student;

@Name("obecnoscHome")
public class ObecnoscHome extends EntityHome<Obecnosc> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long obecnoscId;

	@RequestParameter
	Long studentId;

	@RequestParameter
	Long grupaId;
	
	
	public void usprawiedliw(Komentarze usp) {
		Obecnosc obecnosc = super.getEntityManager().find(Obecnosc.class, obecnoscId);
		obecnosc.setKomentarz(usp);
		super.getEntityManager().persist(obecnosc);
	}

	public void obecny() {
		Grupa grupa = (Grupa) super.getEntityManager().createQuery("select grupa from Grupa grupa where grupa.id = :gId").setParameter("gId", grupaId).getSingleResult();
		java.util.Date dzisiaj = new java.util.Date();
		for (ListaObecnosci l : grupa.getObecnosci()) {
			if (l.getData().toString().equals(new Date(dzisiaj.getTime()).toString())) {
				for (Obecnosc o : l.getObecnosci()) {
					if (o.getStudent().getId() == studentId) {
						o.setObecnosc("jest");
						super.getEntityManager().persist(o);
						return;
					}
				}
			}
		}
	}

	@Override
	public Object getId() {
		if (obecnoscId == null) {
			return super.getId();
		} else {
			return obecnoscId;
		}
	}

	@Override
	@Begin(join=true)
	public void create() {
		super.create();
	}

}
