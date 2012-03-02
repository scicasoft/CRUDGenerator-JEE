/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import java.util.List;

import scidy.entites.Projet;
import scidy.entites.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author scicasoft
 */
@Stateless
public class ProjetEjbBean extends AbstractEjbBean<Projet> implements ProjetEjb {
	@PersistenceContext
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public ProjetEjbBean() {
		super(Projet.class);
	}

	@Override
	public List<Projet> findAll(User user) {
		return getEntityManager().createQuery("select object(o) from Projet as o where user_id = "+user.getId()).getResultList();
	}

}
