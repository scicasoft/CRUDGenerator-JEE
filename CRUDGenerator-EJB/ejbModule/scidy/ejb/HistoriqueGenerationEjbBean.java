/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.HistoriqueGeneration;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author scicasoft
 */
@Stateless
public class HistoriqueGenerationEjbBean extends AbstractEjbBean<HistoriqueGeneration> implements HistoriqueGenerationEjb {
	@PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueGenerationEjbBean() {
        super(HistoriqueGeneration.class);
    }

}
