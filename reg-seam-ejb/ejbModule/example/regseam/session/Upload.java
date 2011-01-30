package example.regseam.session;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;

import example.regseam.entity.GrupaDziekanska;
import example.regseam.entity.Student;

@Scope(ScopeType.SESSION)
@Name("dataUpload")
public class Upload {
	private byte[] data;

	@In 
	EntityManager entityManager;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void upload(){
		String value = new String(data);
		String[] rows = value.split("\n");
		Map<String, GrupaDziekanska> grupy = new HashMap<String, GrupaDziekanska>();
		for (String row : rows) {
			String[] fields = row.split(",");
			if (fields.length >= 4) {
				Student student = new Student();
				GrupaDziekanska grupaDziekanska = null;
				for (String grupa : grupy.keySet()) {
					if (grupa.equals(fields[3])) {
						grupaDziekanska = grupy.get(grupa);
						break;
					}
				}
				if (grupaDziekanska == null) {
					grupaDziekanska = new GrupaDziekanska();
					grupaDziekanska.setFlaga(true);
					grupaDziekanska.setNazwa(fields[3]);
					entityManager.persist(grupaDziekanska);
					grupy.put(fields[3], grupaDziekanska);
				}
				student.setGrupaDziekanska(grupaDziekanska);
				student.setFlaga(true);
				student.setHaslo("pass1234");
				student.setImie(fields[0]);
				student.setNazwisko(fields[1]);
				student.setIndeks(fields[2]);
				student.setLogin(fields[2]);
				student.setRola("S");
				entityManager.persist(student);
			}
		}
		return;
	}

}
