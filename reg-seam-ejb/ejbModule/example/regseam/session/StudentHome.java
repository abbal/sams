package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import example.regseam.entity.Student;

@Name("studentHome")
public class StudentHome extends EntityHome<Student>
{
    @RequestParameter Long studentId;

    @Override
    public Object getId()
    {
        if (studentId == null)
        {
            return super.getId();
        }
        else
        {
            return studentId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
