package example.regseam.session;

import org.jboss.seam.annotations.Name;
@Name("tytulyNaukoweList")
public class TytulyNaukoweList {

		private static final long serialVersionUID = 1L;

		public TytulyNaukowe[] getTytulyNaukowe() {
			return TytulyNaukowe.values();
		}
}
