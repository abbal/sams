package org.domain.regseam.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.management.PasswordHash;
import org.jboss.seam.util.AnnotatedBeanProperty;
import org.jboss.seam.log.Log;

import example.regseam.entity.Osoba;

@Name("authenticator")
public class Authenticator {

	@Logger private Log log;

	@In Identity identity;
	@In @Out Credentials credentials;
	@In EntityManager entityManager;
	@Out (scope = ScopeType.SESSION, required = false) 
	Osoba loggedIn; 

	
	
	public boolean authenticate() {
		
		log.info("authenticating {0}", credentials.getUsername());
        //write your authentication logic here,
        //return true if the authentication was
        //successful, false otherwise
		
		
		Osoba osoba = (Osoba)entityManager.createQuery("select osoba from Osoba osoba where osoba.login = :username").setParameter("username", credentials.getUsername()).getSingleResult();
        if (null!=osoba) {
        	if (osoba.getHaslo().equals(Authenticator.generateMD5(credentials.getPassword()))) {
        		loggedIn = osoba;
        		identity.addRole(osoba.getRola());
        		return true;
        	}
        }
        return false;

	}

	public static String generateMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			StringBuilder result = new StringBuilder();
			for (byte b : md.digest())
				result.append(String.format("%02x", b));
			return result.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}