package example.regseam.session;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Student;

@Name("studentHome")
public class StudentHome extends EntityHome<Student> {
	private static final long serialVersionUID = 1L;

	@RequestParameter
	Long studentId;

	public Student getCurrent(long id) {
		EntityManager em = super.getEntityManager();
		Student student = (Student) em.createQuery("select student from Student student where student.id = :id").setParameter("id", id).getSingleResult();
		return student;
	}

	@Override
	public Object getId() {
		if (studentId == null) {
			return super.getId();
		} else {
			return studentId;
		}
	}

	@Override
	@Begin
	public void create() {
		super.create();
	}

}
