/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.Projet;
import scidy.entites.User;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author scicasoft
 */
@Remote
public interface ProjetEjb {

    void create(Projet projet);

    void edit(Projet projet);

    void remove(Projet projet);

    Projet find(Object id);

    List<Projet> findAll();
    
    List<Projet> findAll(User user);

    List<Projet> findRange(int[] range);

    int count();
    
    int nextId();

}
