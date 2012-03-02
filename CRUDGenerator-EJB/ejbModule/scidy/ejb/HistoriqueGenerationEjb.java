/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.ejb;

import scidy.entites.HistoriqueGeneration;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author scicasoft
 */
@Remote
public interface HistoriqueGenerationEjb {

    void create(HistoriqueGeneration historiqueGeneration);

    void edit(HistoriqueGeneration historiqueGeneration);

    void remove(HistoriqueGeneration historiqueGeneration);

    HistoriqueGeneration find(Object id);

    List<HistoriqueGeneration> findAll();

    List<HistoriqueGeneration> findRange(int[] range);

    int count();
    
    int nextId();

}
