/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.TypeBase;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author scicasoft
 */
@Stateless
public class TypeBaseEjbBean extends AbstractEjbBean<TypeBase> implements TypeBaseEjb {
	@PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeBaseEjbBean() {
        super(TypeBase.class);
    }

}
