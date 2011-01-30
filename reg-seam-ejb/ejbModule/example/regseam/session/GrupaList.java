package example.regseam.session;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import example.regseam.entity.Grupa;

@Name("grupaList")
public class GrupaList extends EntityQuery<Grupa>
{
	private static final long serialVersionUID = 1L;

	public GrupaList()
    {
        setEjbql("select grupa from Grupa grupa  where grupa.flaga is true");
    }
    
    public List<Grupa> GrupyList(long id)
    {
        List<Grupa> list = super.getResultList();
        List<Grupa> result = new ArrayList<Grupa>();
        for (Grupa g : list) {
        	if (g.getWykladowca().getId() == id) {
        		result.add(g);
        	}
        }
        return result;
    }
}
