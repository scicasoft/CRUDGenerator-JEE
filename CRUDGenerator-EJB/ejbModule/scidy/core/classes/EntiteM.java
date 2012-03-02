package scidy.core.classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import scidy.core.utils.Utils;
import scidy.ejb.AttributEjb;
import scidy.entites.Attribut;
import scidy.entites.Entite;
import scidy.utils.BeanLocator;

public class EntiteM {
	private List<AttributM> attributs = new ArrayList<AttributM>();
	private String nom_entite;

	public EntiteM(String libelle) {
		this.nom_entite = libelle;
	}
	
	public EntiteM(Entite entite) {
		this.nom_entite = entite.getNomEntite();
		List<Attribut> attributs = BeanLocator.defaultLookup(AttributEjb.class)
				.findAllFromEntite(entite.getId());
		//for (Iterator<Attribut> iterator = entite.getAttributList().iterator(); iterator.hasNext();) {
		for (Iterator<Attribut> iterator = attributs.iterator(); iterator.hasNext();) {
			Attribut attribut = (Attribut) iterator.next();
			this.ajouterAttribut(new AttributM(attribut));
		}
	}

	public String getActionMappings() throws IOException {
		String texte = Utils
				.recupererContenuFichier("ressources/config/action_mappings.xml");
		return transformerTexte(texte + "\n");
	}

	public String getFormBeans() throws IOException {
		return "		<form-bean name=\"formBean"
				+ Utils.capitalizeFirstLetters(this.nom_entite)
				+ "\" type=\"defaultpackage.entitiesForm." + this.nom_entite
				+ "." + Utils.capitalizeFirstLetters(this.nom_entite) + "Form"
				+ "\"></form-bean>\n";
	}

	public String gettersSetters() {
		String getSets = "";
		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			getSets += att.getterSetter();
		}
		return getSets;
	}

	public String getConvertionEntite() {
		String texte = "";
		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			texte += "\t\t" + this.nom_entite + ".set"
					+ Utils.capitalizeFirstLetters(att.getNom()) + "(this.get"
					+ Utils.capitalizeFirstLetters(att.getNom()) + "());\n";
		}
		return texte;
	}

	public String declarationAttributs() {
		String texte = "";
		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			texte += att.declaration();
		}
		return texte;
	}

	public String declarationAttributsForm() {
		String texte = "";
		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			texte += att.declarationForm();
		}
		return texte;
	}

	public String constructeurAvecId() {
		AttributM att = this.identifiant();
		if (att != null)
			return "    public "
					+ Utils.capitalizeFirstLetters(this.nom_entite) + "("
					+ att.getType() + " " + att.getNom() + ") {\n        this."
					+ att.getNom() + " = " + att.getNom() + ";\n    }";

		return "";
	}

	public String constructeurAvecIdForm() {
		AttributM att = this.identifiant();
		if (att != null)
			return "    public "
					+ Utils.capitalizeFirstLetters(this.nom_entite) + "Form("
					+ att.getType() + " " + att.getNom() + ") {\n        this."
					+ att.getNom() + " = " + att.getNom() + ";\n    }";

		return "";
	}

	public AttributM identifiant() {
		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			if (att.getCle_primaire())
				return att;
		}
		return null;
	}

	public void generer(String repertoire_base, String nom_projet)
			throws IOException {
		String texte = null;

		String[] fichiers = { "", "Ejb", "EjbBean" };

		for (int i = 0; i < fichiers.length; i++) {
			String fichier = fichiers[i];
			texte = Utils.recupererContenuFichier("ressources/entites/Entite"
					+ fichier + ".java.txt");

			if (i == 0) {
				Utils.mettreDansFichier(
						repertoire_base + nom_projet + "/" + nom_projet
								+ "-EJB/ejbModule/defaultpackage/entities/"
								+ Utils.capitalizeFirstLetters(this.nom_entite)
								+ ".java", transformerTexte(texte));
			} else {
				Utils.mettreDansFichier(repertoire_base + nom_projet + "/"
						+ nom_projet + "-EJB/ejbModule/defaultpackage/ejb/"
						+ Utils.capitalizeFirstLetters(this.nom_entite)
						+ fichier + ".java", transformerTexte(texte));
			}
		}

		(new File(repertoire_base + nom_projet + "/" + nom_projet
				+ "-WEB/src/defaultpackage/entitiesForm/" + this.nom_entite))
				.mkdirs();

		texte = Utils
				.recupererContenuFichier("ressources/entites/EntiteForm.java.txt");
		Utils.mettreDansFichier(repertoire_base + nom_projet + "/" + nom_projet
				+ "-WEB/src/defaultpackage/entitiesForm/" + this.nom_entite
				+ "/" + Utils.capitalizeFirstLetters(this.nom_entite)
				+ "Form.java", transformerTexte(texte));
	}

	public void genererActions(String repertoire_base, String nom_projet)
			throws IOException {
		(new File(repertoire_base + nom_projet + "/" + nom_projet
				+ "-WEB/src/defaultpackage/actions/" + this.nom_entite))
				.mkdirs();

		String texte = null;

		String[] fichiers = { "Delete", "FormUpdate", "List", "New", "Update" };

		for (int i = 0; i < fichiers.length; i++) {
			String fichier = fichiers[i];
			texte = Utils.recupererContenuFichier("ressources/actions/"
					+ fichier + "EntiteAction.java.txt");

			Utils.mettreDansFichier(
					repertoire_base + nom_projet + "/" + nom_projet
							+ "-WEB/src/defaultpackage/actions/"
							+ this.nom_entite + "/" + fichier
							+ Utils.capitalizeFirstLetters(this.nom_entite)
							+ "Action.java", transformerTexte(texte));
		}
	}

	// {{FORM_MODIFICATION}}
	public String formModificationVues() {
		String texte = "";
		if (this.identifiant() != null)
			texte = "\t<html:hidden name='" + this.getLibelle()
					+ "' property='" + this.identifiant().getNom() + "' />\n";

		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			if (!att.equals(this.identifiant()))
				texte += "\t" + att.getLabel() + " : <html:text name='"
						+ this.getLibelle() + "' property='" + att.getNom()
						+ "' /> <BR>\n";
		}
		return texte;
	}

	// {{FORM_MODIFICATION}}
	public String formAjoutVues() {
		String texte = "";

		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			texte += "\t" + att.getLabel() + " : <html:text property='"
					+ att.getNom() + "' /> <BR>\n";
		}
		return texte;
	}

	// {{EN_TETE_LISTE_VUE}}
	public String enTeteListVues() {
		String texte = "";
		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			if (!att.equals(this.identifiant()))
				texte += "\t\t<td>" + att.getLabel() + "</td>\n";
		}
		return texte;
	}

	// {{CORPS_LISTE_VUE}}
	public String corpsListVues() {
		String texte = "";
		if (this.identifiant() != null)
			texte = "\t\t<bean:define id='id' name='" + this.nom_entite
					+ "' property='" + this.identifiant().getNom() + "' />\n";
		texte += "\t\t<tr>\n";

		for (Iterator<AttributM> itAttributs = attributs.iterator(); itAttributs
				.hasNext();) {
			AttributM att = (AttributM) itAttributs.next();
			if (!att.equals(this.identifiant()))
				texte += "\t\t\t<td><bean:write name='" + this.nom_entite
						+ "' property='" + att.getNom() + "' /></td> \n";
		}

		texte += "\t\t\t<td><html:link href='formUpdate"
				+ Utils.capitalizeFirstLetters(this.nom_entite)
				+ ".do' paramId='id' paramName='id'><img src='images/modifier.png' /></html:link></td>\n";
		texte += "\t\t\t<td><html:link href='delete"
				+ Utils.capitalizeFirstLetters(this.nom_entite)
				+ ".do' paramId='id' paramName='id'><img src='images/supprimer.png' /></html:link></td>\n";
		texte += "\t\t</tr>\n";
		return texte;
	}

	public void genererVues(String repertoire_base, String nom_projet)
			throws IOException {
		(new File(repertoire_base + nom_projet + "/" + nom_projet
				+ "-WEB/WebContent/" + this.nom_entite)).mkdirs();
		String[] fichiers = { "index", "modifier", "formulaire", "show" };

		for (int i = 0; i < fichiers.length; i++) {
			String fichier = fichiers[i];
			String texte = Utils.recupererContenuFichier("ressources/vues/"
					+ fichier + ".jsp");

			Utils.mettreDansFichier(repertoire_base + nom_projet + "/"
					+ nom_projet + "-WEB/WebContent/" + this.nom_entite + "/"
					+ fichier + ".jsp", transformerTexte(texte));
		}
	}

	private String transformerTexte(String s) {
		String[] patterns = { "Entite", "entite", "GettersAndSetters",
				"DeclarationAttributs", "DeclarationAttributsForm",
				"ConstructeurAvecId", "ConstructeurAvecIdForm",
				"EN_TETE_LISTE_VUE", "CORPS_LISTE_VUE", "FORM_MODIFICATION",
				"FORM_AJOUT", "ConvertionEntite" };
		String[] dattums = { Utils.capitalizeFirstLetters(this.nom_entite),
				this.nom_entite, this.gettersSetters(),
				this.declarationAttributs(), this.declarationAttributsForm(),
				this.constructeurAvecId(), this.constructeurAvecIdForm(),
				this.enTeteListVues(), this.corpsListVues(),
				this.formModificationVues(), this.formAjoutVues(),
				this.getConvertionEntite() };

		return Utils.tranformerTexte(s, patterns, dattums);
	}

	public void ajouterAttribut(AttributM attribut) {
		this.attributs.add(attribut);
	}

	public List<AttributM> getAttributs() {
		return attributs;
	}

	public String getLibelle() {
		return nom_entite;
	}

	public void setLibelle(String libelle) {
		this.nom_entite = libelle;
	}
}