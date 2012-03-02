/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.TypeBase;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author scicasoft
 */
@Remote
public interface TypeBaseEjb {

    void create(TypeBase typeBase);

    void edit(TypeBase typeBase);

    void remove(TypeBase typeBase);

    TypeBase find(Object id);

    List<TypeBase> findAll();

    List<TypeBase> findRange(int[] range);

    int count();
    
    int nextId();

}
