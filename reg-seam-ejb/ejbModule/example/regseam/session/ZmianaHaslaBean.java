package example.regseam.session;

import static org.jboss.seam.ScopeType.EVENT;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.annotations.security.Restrict;
import org.hibernate.validator.Length;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.Events;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.management.IdentityStore;
import org.jboss.security.integration.password.Password;

import example.regseam.entity.Osoba;

@Stateful
@Scope(EVENT)
@Name("zmianaHasla")
@Restrict("#{identity.loggedIn}")
public class ZmianaHaslaBean implements ZmianaHasla {
	private static final String EVENT_USER_PASSWORD_CHANGED = "org.jboss.seam.userPasswordChanged";

	@In("#{statusMessages}")
	private StatusMessages sm;
	@In
	private IdentityStore identityStore;
	@In
	private Identity identity;

	private String login;
	private String oldPassword;
	private String password;
	private String repeatedPassword;

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getOldPassword() {
		return oldPassword;
	}

	@Override
	public void setOldPassword(String password) {
		this.oldPassword = password;
	}

	@Override
	@Length(min = 8)
	@Password(methodName = "md5")
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@UserPassword(hash = "md5")
	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	@Override
	public void setRepeatedPassword(String password) {
		this.repeatedPassword = password;
	}

	@Create
	@Override
	public void init() {
		this.login = identity.getCredentials().getUsername();
		this.oldPassword = identity.getCredentials().getPassword();
	}

	@Destroy
	@Remove
	@Override
	public void destroy() {
		this.login = null;
		this.oldPassword = null;
		this.password = null;
		this.repeatedPassword = null;
	}

	public void changePassword() {
		if (password.equals(repeatedPassword)) {
			if (identityStore.authenticate(login, oldPassword)) {
				identityStore.changePassword(login, password);
				sm.add("Hasło zostało zmienione.");

				if (identity.isLoggedIn())
					identity.logout();
				identity.getCredentials().setUsername(login);
				identity.getCredentials().setPassword(password);
				identity.login();
			} else {
				sm.add(Severity.ERROR, "#{org.jboss.seam.loginFailed}");
			}
		}
		if (Events.exists()) {
			Events.instance().raiseEvent(EVENT_USER_PASSWORD_CHANGED, this);
		}
	}
}
