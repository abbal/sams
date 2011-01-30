package example.regseam.session;

import org.jboss.seam.annotations.Name;

@Name("usprawiedliwieniaList")
public class UsprawiedliwieniaList{
	
	private static final long serialVersionUID = 1L;
	
    	public Usprawiedliwienia[] getUsprawiedliwienia() {
			return Usprawiedliwienia.values();
    }
}
