package scidy.core.classes;

import scidy.core.utils.Utils;
import scidy.entites.Attribut;

enum LesTypes {
	Integer, String, Date, Boolean
}

public class AttributM {
	private String nom_attribut;
	private LesTypes type;
	private Boolean cle_primaire = false;
	private String label;
	private Boolean requis = false;
	private Boolean unique = false;
	private AttributM foreign_key = null;

	public AttributM(String nom, LesTypes type) {
		this.nom_attribut = nom;
		this.type = type;
		this.label = nom;
	}

	public AttributM(Attribut attribut) {
		this.nom_attribut = attribut.getNomAttribut();
		this.cle_primaire = attribut.getClePrimaire();
		this.label = attribut.getLabel();
		this.requis = attribut.getRequis();
		this.unique = attribut.getUnique();
		if (attribut.getAttribut() != null)
			this.foreign_key = (new AttributM(attribut.getAttribut()));
		
		if (attribut.getType().equalsIgnoreCase("Integer"))
			this.type = LesTypes.Integer;
		else if (attribut.getType().equalsIgnoreCase("Date"))
			this.type = LesTypes.Date;
		else if (attribut.getType().equalsIgnoreCase("Boolean"))
			this.type = LesTypes.Boolean;
		else
			this.type = LesTypes.String;
	}

	public String declaration() {
		String texte = "\t@Column(name = \"" + this.nom_attribut
				+ "\")\n\tprivate " + this.type + " " + this.nom_attribut
				+ ";\n";
		if (this.cle_primaire)
			texte = "\t@Id\n" + texte;
		return texte;
	}

	public String declarationForm() {
		String texte = "\tprivate " + this.type + " " + this.nom_attribut
				+ ";\n";
		return texte;
	}

	public String getterSetter() {
		String getSet = "";
		getSet = "	public " + type + " get"
				+ Utils.capitalizeFirstLetters(nom_attribut) + "() {\n"
				+ "		return " + nom_attribut + ";\n" + "	}\n" + "\n"
				+ "	public void set"
				+ Utils.capitalizeFirstLetters(nom_attribut) + "(" + type + " "
				+ nom_attribut + ") {\n" + "		this." + nom_attribut + " = "
				+ nom_attribut + ";\n" + "	}\n\n";
		return getSet;
	}

	public AttributM getForeign_key() {
		return foreign_key;
	}

	public void setForeign_key(AttributM foreign_key) {
		this.foreign_key = foreign_key;
	}

	public String getNom() {
		return nom_attribut;
	}

	public void setNom(String nom) {
		this.nom_attribut = nom;
	}

	public LesTypes getType() {
		return type;
	}

	public void setType(LesTypes type) {
		this.type = type;
	}

	public Boolean getUnique() {
		return unique;
	}

	public void setUnique(Boolean unique) {
		this.unique = unique;
	}

	public Boolean getCle_primaire() {
		return cle_primaire;
	}

	public void setCle_primaire(Boolean cle_primaire) {
		this.cle_primaire = cle_primaire;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRequis() {
		return requis;
	}

	public void setRequis(Boolean requis) {
		this.requis = requis;
	}

	public boolean equals(AttributM a) {
		return this.nom_attribut.equals(a.nom_attribut);
	}
}
