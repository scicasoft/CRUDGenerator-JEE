/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import java.util.List;

import scidy.entites.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author scicasoft
 */
@Stateless
public class UserEjbBean extends AbstractEjbBean<User> implements UserEjb {
	@PersistenceContext
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public UserEjbBean() {
		super(User.class);
	}

	public int existe(String pseudo, String password) {
		
		List<User> users = getEntityManager().createQuery("select object(o) from User as o where pseudo='" + pseudo
						+ "' and password='" + password + "'").getResultList();
		
		if (users.size() != 0)
			return users.get(0).getId();
		
		return 0;
	}

}
