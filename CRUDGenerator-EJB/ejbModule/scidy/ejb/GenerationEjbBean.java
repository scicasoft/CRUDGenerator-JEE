package scidy.ejb;

import java.io.IOException;

import javax.ejb.Stateless;

import scidy.core.classes.ProjetM;
import scidy.entites.Projet;
import scidy.utils.BeanLocator;

/**
 * Session Bean implementation class Generation
 */
@Stateless
public class GenerationEjbBean implements GenerationEjb {

    /**
     * Default constructor. 
     */
    public GenerationEjbBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String bonjour() {
		return "Bonjour scica !";
	}

	@Override
	public void generer(Integer id) throws IOException {
		Projet projet = BeanLocator.defaultLookup(ProjetEjb.class).find(id);
		ProjetM projetm = new ProjetM(projet, "/media/sda3/");
		projetm.generer();
	}

}
