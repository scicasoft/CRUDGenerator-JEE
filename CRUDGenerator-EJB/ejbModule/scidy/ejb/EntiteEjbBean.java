/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import java.util.List;

import scidy.entites.Entite;
import scidy.entites.Projet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author scicasoft
 */
@Stateless
public class EntiteEjbBean extends AbstractEjbBean<Entite> implements EntiteEjb {
	@PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EntiteEjbBean() {
        super(Entite.class);
    }

	@Override
	public List<Entite> findAll(Projet projet) {
		return getEntityManager().createQuery("select object(o) from Entite as o where projet_id = "+projet.getId()).getResultList();
	}

}
