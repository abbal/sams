package example.regseam.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Obecnosc;

@Name("obecnoscList")
public class ObecnoscList extends EntityQuery<Obecnosc>{
	private static final long serialVersionUID = 1L;
    public ObecnoscList()
    {
        setEjbql("select obecnosc from Obecnosc obecnosc");
    }
}
