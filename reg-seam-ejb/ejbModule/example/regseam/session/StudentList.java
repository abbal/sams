/*
 * Projekt inżynierski Polsko-Japońskiej Wyższej Szkoły Technik Komputerowych w Gdańsku
 * "Projekt i implementacja systemu monitorowania obecności       studentów na zajęciach"
 * 
 * Autorzy:
 *     Adam Balcerzak
 *     Tomasz Masztalerz
 *     Piotr Niesiołowski
 *
 * Gdańsk, 2011
 *
 */

package example.regseam.session;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import example.regseam.entity.Grupa;
import example.regseam.entity.Student;

@Name("studentList")
public class StudentList extends EntityQuery<Student> {
	private static final long serialVersionUID = 1L;

	public StudentList()
    {
        setEjbql("select student from Student student where student.flaga is true");
    }
}
