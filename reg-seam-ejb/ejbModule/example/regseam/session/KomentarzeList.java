package example.regseam.session;

import org.jboss.seam.annotations.Name;

@Name("komentarzeList")
public class KomentarzeList{
	
	private static final long serialVersionUID = 1L;
	
    	public Komentarze[] getKomentarze() {
			return Komentarze.values();
    }
}
