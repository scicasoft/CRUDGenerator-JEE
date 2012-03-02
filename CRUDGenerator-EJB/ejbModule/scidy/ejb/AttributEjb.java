/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.Attribut;
import scidy.entites.Entite;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author scicasoft
 */
@Remote
public interface AttributEjb {

    void create(Attribut attribut);

    void edit(Attribut attribut);

    void remove(Attribut attribut);

    Attribut find(Object id);

    List<Attribut> findAll();
    
    List<Attribut> findAll(Entite entite);
    
    public List<Attribut> findAllFromEntite(int entite_id);

    List<Attribut> findRange(int[] range);

    int count();
    
    int nextId();

}
