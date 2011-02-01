package example.regseam.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.Length;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.Pattern;

import example.regseam.session.DzienTygodnia;

@Entity
public class Grupa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String przedmiot;
	private int numerGrupy;
	private long godzinaStart;
	private long godzinaStop;
	private DzienTygodnia dzien;
	private boolean open;
	private List<Student> studenci;
	private Wykladowca wykladowca;
	private List<ListaObecnosci> obecnosci;
	private boolean flaga;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Length(max = 20)
	@Pattern(regex="^\\p{L}+[- \\p{L}]*$", message="tylko litery")
	public String getPrzedmiot() {
		return przedmiot;
	}
	public void setPrzedmiot(String przedmiot) {
		this.przedmiot = przedmiot;
	}

	@Min(0) 
	@Max(50)
	public int getNumerGrupy() {
		return numerGrupy;
	}
	public void setNumerGrupy(int numerGrupy) {
		this.numerGrupy = numerGrupy;
	}

	@Pattern(regex="^([0-9]|[0-1][0-9]|[2][0-3]):([0-5][0-9])$", message="godzina w formacie HH:MM")
	public String getGodzinaStart() {
		Calendar godz = Calendar.getInstance();
		godz.setTime(new Date(godzinaStart));
		String h = godz.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + godz.get(Calendar.HOUR_OF_DAY) : "" + godz.get(Calendar.HOUR_OF_DAY);
		String m = godz.get(Calendar.MINUTE) < 10 ? "0" + godz.get(Calendar.MINUTE) : "" + godz.get(Calendar.MINUTE);
		return h + ":" + m;
	}
	public void setGodzinaStart(String godzinaStart) {
		DateFormat df = new SimpleDateFormat("HH:mm");
		Date godz;
		try {
			godz = df.parse(godzinaStart);
		} catch (ParseException e) {
			godz = new Date(0);
		}
		this.godzinaStart = godz.getTime();
	}

	@Pattern(regex="^([0-9]|[0-1][0-9]|[2][0-3]):([0-5][0-9])$", message="godzina w formacie HH:MM")
	public String getGodzinaStop() {
		Calendar godz = Calendar.getInstance();
		godz.setTime(new Date(godzinaStop));
		String h = godz.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + godz.get(Calendar.HOUR_OF_DAY) : "" + godz.get(Calendar.HOUR_OF_DAY);
		String m = godz.get(Calendar.MINUTE) < 10 ? "0" + godz.get(Calendar.MINUTE) : "" + godz.get(Calendar.MINUTE);
		return h + ":" + m;
	}
	public void setGodzinaStop(String godzinaStop) {
		DateFormat df = new SimpleDateFormat("HH:mm");
		Date godz;
		try {
			godz = df.parse(godzinaStop);
		} catch (ParseException e) {
			godz = new Date(0);
		}
		this.godzinaStop = godz.getTime();
	}

	public DzienTygodnia getDzien() {
		return dzien;
	}
	public void setDzien(DzienTygodnia dzien) {
		this.dzien = dzien;
	}

	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	@OneToMany(mappedBy="grupa")
	public List<ListaObecnosci> getObecnosci() {
		return obecnosci;
	}
	public void setObecnosci(List<ListaObecnosci> obecnosci) {
		this.obecnosci = obecnosci;
	}

	@ManyToMany
	public List<Student> getStudenci() {
		return studenci;
	}	
	public void setStudenci(List<Student> studenci) {
		this.studenci = studenci;
	}

	@ManyToOne
	public Wykladowca getWykladowca() {
		return wykladowca;
	}
	public void setWykladowca(Wykladowca wykladowca) {
		this.wykladowca = wykladowca;
	}

	public boolean isFlaga() {
		return flaga;
	}
	public void setFlaga(boolean flaga) {
		this.flaga = flaga;
	}

	public List<Obecnosc> getObecnoscStudent(long studentId) {
		List<Obecnosc> wynik = new ArrayList<Obecnosc>();
		List<Obecnosc> tmp = new ArrayList<Obecnosc>();
		for (ListaObecnosci listaOb : obecnosci) {
			for (Obecnosc obecnosc : listaOb.getObecnosci()) {
				if (obecnosc.getStudent().getId() == studentId) {
					wynik.add(obecnosc);
				}
			}
		}
		List<Long> daty = new ArrayList<Long>();
		for (Obecnosc ob : tmp) {
			daty.add(ob.getListaObecnosci().getData().getTime());
		}
		Collections.sort(daty);
		for (Long data : daty) {
			for (Obecnosc ob : tmp) {
				if (ob.getListaObecnosci().getData().getTime() == data) {
					wynik.add(ob);
					break;
				}
			}
		}
		return wynik;
	}

}
