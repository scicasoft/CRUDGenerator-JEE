package scidy.form;

import org.apache.struts.action.ActionForm;

import scidy.entites.Projet;
import scidy.entites.TypeBase;
import scidy.entites.User;

public class ProjetForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomProjet;
	private String nomBase;
	private String sourceDonneesDs;
	private String racineProjet;
	private int userId;
	private int typeBaseId;
	
	public ProjetForm() {
		super();
	}
	
	public ProjetForm(String nomProjet, int userId, int typeBaseId) {
		super();
		this.nomProjet = nomProjet;
		this.userId = userId;
		this.typeBaseId = typeBaseId;
	}

	public ProjetForm(int id, String nomProjet, int userId, int typeBaseId) {
		super();
		this.id = id;
		this.nomProjet = nomProjet;
		this.userId = userId;
		this.typeBaseId = typeBaseId;
	}

	/**
	 * @return the racineProjet
	 */
	public String getRacineProjet() {
		return racineProjet;
	}

	/**
	 * @param racineProjet the racineProjet to set
	 */
	public void setRacineProjet(String racineProjet) {
		this.racineProjet = racineProjet;
	}

	/**
	 * @return the sourceDonneesDs
	 */
	public String getSourceDonneesDs() {
		return sourceDonneesDs;
	}

	/**
	 * @param sourceDonneesDs the sourceDonneesDs to set
	 */
	public void setSourceDonneesDs(String sourceDonneesDs) {
		this.sourceDonneesDs = sourceDonneesDs;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nomProjet
	 */
	public String getNomProjet() {
		return nomProjet;
	}

	/**
	 * @param nomProjet the nomProjet to set
	 */
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the typeBaseId
	 */
	public int getTypeBaseId() {
		return typeBaseId;
	}

	/**
	 * @param typeBaseId the typeBaseId to set
	 */
	public void setTypeBaseId(int typeBaseId) {
		this.typeBaseId = typeBaseId;
	}
	
	

	/**
	 * @return the nomBase
	 */
	public String getNomBase() {
		return nomBase;
	}

	/**
	 * @param nomBase the nomBase to set
	 */
	public void setNomBase(String nomBase) {
		this.nomBase = nomBase;
	}

	public Projet toProjetEJB() {
		Projet projet = new Projet();
		User user = new User(this.userId);
		TypeBase type_base = new TypeBase(this.typeBaseId);
		
		
		projet.setId(this.id);
		projet.setUser(user);
		projet.setNomProjet(this.nomProjet);
		projet.setTypeBase(type_base);
		projet.setNomBase(this.nomBase);
		projet.setRacineProjet(this.racineProjet);
		projet.setSourceDonneesDs(this.sourceDonneesDs);
		
		return projet;
	}	
}