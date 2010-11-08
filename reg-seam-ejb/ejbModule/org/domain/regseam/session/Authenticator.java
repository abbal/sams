package org.domain.regseam.session;

import javax.persistence.EntityManager;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.log.Log;

import example.regseam.entity.Osoba;

@Name("authenticator")
public class Authenticator {

	@Logger private Log log;

	@In Identity identity;
	@In Credentials credentials;
	
	@Out (scope = ScopeType.SESSION, required = false) Osoba loggedIn; 

	
	private EntityManager entityManager;
	public boolean authenticate() {
		
		log.info("authenticating {0}", credentials.getUsername());

        Osoba osoba = (Osoba)entityManager.createQuery("select osoba from Osoba osoba where osoba.login = :username").
        		setParameter("username", credentials.getUsername()).
        	getSingleResult();
        if (null!=osoba) {
        	if (osoba.getHaslo().equals(credentials.getPassword())) {
        		loggedIn = osoba;
        		
        		//identity.addRole(osoba.getRole());
        		
        		return true;
        	}
        }
        return false;

	}
}