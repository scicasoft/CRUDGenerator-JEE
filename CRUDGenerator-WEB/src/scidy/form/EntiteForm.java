package scidy.form;

import org.apache.struts.action.ActionForm;

import scidy.entites.Entite;
import scidy.entites.Projet;

public class EntiteForm extends ActionForm{
	private int id;
	private String nomEntite;
	private int projetId;
	
	public EntiteForm() {
		super();
	}
	public EntiteForm(String nomEntite, int projetId) {
		super();
		this.nomEntite = nomEntite;
		this.projetId = projetId;
	}
	public EntiteForm(int id, String nomEntite, int projetId) {
		super();
		this.id = id;
		this.nomEntite = nomEntite;
		this.projetId = projetId;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nomEntite
	 */
	public String getNomEntite() {
		return nomEntite;
	}
	/**
	 * @param nomEntite the nomEntite to set
	 */
	public void setNomEntite(String nomEntite) {
		this.nomEntite = nomEntite;
	}
	/**
	 * @return the projetId
	 */
	public int getProjetId() {
		return projetId;
	}
	/**
	 * @param projetId the projetId to set
	 */
	public void setProjetId(int projetId) {
		this.projetId = projetId;
	}
	public Entite toEntiteEJB() {
		Entite entite = new Entite();
		entite.setId(this.id);
		entite.setNomEntite(this.nomEntite);
		Projet nomProjet = new Projet(this.id);
		entite.setProjet(nomProjet);
		return null;
	}
	
}
