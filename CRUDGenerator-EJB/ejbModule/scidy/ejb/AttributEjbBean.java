/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import java.util.List;

import scidy.entites.Attribut;
import scidy.entites.Entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author scicasoft
 */
@Stateless
public class AttributEjbBean extends AbstractEjbBean<Attribut> implements AttributEjb {
	@PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AttributEjbBean() {
        super(Attribut.class);
    }
    
    public List<Attribut> findAllFromEntite(int entite_id) {
        return getEntityManager().createQuery("select object(o) from Attribut as o where entite_id = "+entite_id).getResultList();
    }

	@Override
	public List<Attribut> findAll(Entite entite) {
		return getEntityManager().createQuery("select object(o) from Attribut as o where entite_id = "+entite.getId()).getResultList();
	}

}
