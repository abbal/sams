package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Student;

@Name("studentList")
public class StudentList extends EntityQuery<Student> {
	private static final long serialVersionUID = 1L;

	public StudentList()
    {
        setEjbql("select student from Student student where student.flaga is true");
    }
}
