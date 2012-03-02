/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.Entite;
import scidy.entites.Projet;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author scicasoft
 */
@Remote
public interface EntiteEjb {

    void create(Entite entite);

    void edit(Entite entite);

    void remove(Entite entite);

    Entite find(Object id);

    List<Entite> findAll();
    
    List<Entite> findAll(Projet projet);

    List<Entite> findRange(int[] range);

    int count();
    
    int nextId();

}
