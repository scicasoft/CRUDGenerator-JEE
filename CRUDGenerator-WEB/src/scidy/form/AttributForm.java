package scidy.form;

import org.apache.struts.action.ActionForm;

import scidy.entites.Attribut;
import scidy.entites.Entite;

public class AttributForm extends ActionForm{
	private int id;
	private String nomAttribut;
	private int entiteId;
    private Boolean clePrimaire;
    private Boolean requis;
    private String label;
    private String type;
    private Boolean unique;
	
	public AttributForm() {
		super();
	}
	public AttributForm(String nomAttribut, int entiteId) {
		super();
		this.nomAttribut = nomAttribut;
		this.entiteId = entiteId;
	}
	public AttributForm(int id, String nomAttribut, int entiteId) {
		super();
		this.id = id;
		this.nomAttribut = nomAttribut;
		this.entiteId = entiteId;
	}
	
	
	/**
	 * @return the clePrimaire
	 */
	public Boolean getClePrimaire() {
		return clePrimaire;
	}
	/**
	 * @param clePrimaire the clePrimaire to set
	 */
	public void setClePrimaire(Boolean clePrimaire) {
		this.clePrimaire = clePrimaire;
	}
	/**
	 * @return the requis
	 */
	public Boolean getRequis() {
		return requis;
	}
	/**
	 * @param requis the requis to set
	 */
	public void setRequis(Boolean requis) {
		this.requis = requis;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the unique
	 */
	public Boolean getUnique() {
		return unique;
	}
	/**
	 * @param unique the unique to set
	 */
	public void setUnique(Boolean unique) {
		this.unique = unique;
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
	 * @return the nomAttribut
	 */
	public String getNomAttribut() {
		return nomAttribut;
	}
	/**
	 * @param nomAttribut the nomAttribut to set
	 */
	public void setNomAttribut(String nomAttribut) {
		this.nomAttribut = nomAttribut;
	}
	/**
	 * @return the entiteId
	 */
	public int getEntiteId() {
		return entiteId;
	}
	
	/**
	 * @param entiteId the entiteId to set
	 */
	public void setEntiteId(int entiteId) {
		this.entiteId = entiteId;
	}
	
	public Attribut toAttributEJB(){
		Attribut attribut = new Attribut();
		Entite entite = new Entite(this.id);

		attribut.setId(this.id);
		attribut.setNomAttribut(this.nomAttribut);
		attribut.setEntite(entite);
		attribut.setClePrimaire(this.clePrimaire);
		attribut.setLabel(this.label);
		attribut.setRequis(this.requis);
		attribut.setType(this.type);
		attribut.setUnique(this.unique);

		return attribut;
	}

}
