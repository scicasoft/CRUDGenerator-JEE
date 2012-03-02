/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import java.util.List;

import javax.persistence.EntityManager;

import scidy.entites.Projet;

/**
 *
 * @author scicasoft
 */
public abstract class AbstractEjbBean<T> {
    private Class<T> entityClass;

    public AbstractEjbBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        return getEntityManager().createQuery("select object(o) from " + entityClass.getSimpleName() + " as o").getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.Query q = getEntityManager().createQuery("select object(o) from " + entityClass.getSimpleName() + " as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) getEntityManager().createQuery("select count(o) from " + entityClass.getSimpleName() + " as o").getSingleResult()).intValue();
    }

    public int nextId() {
    	Integer lastId = ((Integer) getEntityManager().createQuery("select max(id) from " + entityClass.getSimpleName()).getSingleResult()).intValue();
		if (lastId != null)
			return lastId + 1;
		return 1;
	}

}
