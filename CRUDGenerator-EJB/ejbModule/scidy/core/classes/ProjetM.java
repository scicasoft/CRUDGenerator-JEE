package scidy.core.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import scidy.core.utils.Utils;
import scidy.ejb.TypeBaseEjb;
import scidy.entites.Entite;
import scidy.entites.Projet;
import scidy.entites.TypeBase;
import scidy.utils.BeanLocator;

public class ProjetM {
	public static File zip_prototype = new File("ressources/Prototype.zip");
	public static String[] fconf = {
			"/.settings//org.eclipse.wst.common.component", "/.project",
			"-EJB/.settings/org.eclipse.wst.common.component",
			"-EJB/.classpath", "-EJB/.project",
			"-EJB/ejbModule/defaultpackage/utils/BeanLocator.java",
			"-WEB/WebContent/WEB-INF/web.xml", "-WEB/WebContent/index.jsp",
			"-WEB/WebContent/layout/head.jsp",
			"-WEB/WebContent/layout/foot.jsp", "-WEB/.project",
			"-WEB/.classpath",
			"-WEB/.settings/org.eclipse.wst.common.component",
			"-EJB/ejbModule/META-INF/persistence.xml" };

	private List<EntiteM> entites = new ArrayList<EntiteM>();
	private String racine_projet;
	private String nom_projet;
	private String type_base;
	private String nom_base;
	private String source_donnees_ds; // fichier ds

	public ProjetM(Projet projet, String base_projet) {
		this.nom_projet = projet.getNomProjet();
		this.racine_projet = base_projet;
		this.type_base = projet.getTypeBase().getDriver();
		this.nom_base = projet.getNomBase();
		this.source_donnees_ds = projet.getSourceDonneesDs();
		
		for (Iterator<Entite> iterator = projet.getEntiteList().iterator(); iterator.hasNext();) {
			Entite entite = (Entite) iterator.next();
			this.ajouterEntite(new EntiteM(entite));
		}
	}

	public String getNom_base() {
		return nom_base;
	}

	public void setNom_base(String nom_base) {
		this.nom_base = nom_base;
	}

	public String getData_source() {
		return source_donnees_ds;
	}

	public void setData_source(String data_source) {
		this.source_donnees_ds = data_source;
	}

	public ProjetM(String base_projet, String nom_projet, String type_base) {
		this.nom_projet = nom_projet;
		this.racine_projet = base_projet;
		this.type_base = type_base;
		this.nom_base = nom_projet;
	}

	public static Enumeration<String> DBDrivers() {
		return dialects().keys();
	}

	public static Hashtable<String, String> dialects() {
		Hashtable<String, String> dialects = new Hashtable<String, String>();
		List<TypeBase> bases = BeanLocator.defaultLookup(TypeBaseEjb.class)
				.findAll();
		for (Iterator<TypeBase> iterator = bases.iterator(); iterator.hasNext();) {
			TypeBase base = (TypeBase) iterator.next();
			dialects.put(base.getDriver(), base.getDialect());
		}
		return dialects;
	}

	public void ajouterEntite(EntiteM entite) {
		this.entites.add(entite);
	}

	public List<EntiteM> getEntites() {
		return entites;
	}

	public void genererBaseProjet() throws IOException {
		File folder = new File(this.racine_projet + this.nom_projet + '/');
		folder.mkdirs();

		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(
				new FileInputStream(zip_prototype.getCanonicalFile())));

		// extractions des entrées du fichiers zip (i.e. le contenu du zip)
		ZipEntry ze = null;
		try {
			while ((ze = zis.getNextEntry()) != null) {

				// Pour chaque entrée, on crée un fichier
				// dans le répertoire de sortie "folder"
				File f = new File(folder.getCanonicalPath(), ze.getName());

				// Si l'entrée est un répertoire,
				// on le crée dans le répertoire de sortie
				// et on passe à l'entrée suivante (continue)
				if (ze.isDirectory()) {
					f.mkdirs();
					continue;
				}

				// L'entrée est un fichier, on crée une OutputStream
				// pour écrire le contenu du nouveau fichier
				f.getParentFile().mkdirs();
				OutputStream fos = new BufferedOutputStream(
						new FileOutputStream(f));

				// On écrit le contenu du nouveau fichier
				// qu'on lit à partir de la ZipInputStream
				// au moyen d'un buffer (byte[])
				try {
					try {
						final byte[] buf = new byte[8192];
						int bytesRead;
						while (-1 != (bytesRead = zis.read(buf)))
							fos.write(buf, 0, bytesRead);
					} finally {
						fos.close();
					}
				} catch (final IOException ioe) {
					// en cas d'erreur on efface le fichier
					f.delete();
					throw ioe;
				}
			}
		} finally {
			// fermeture de la ZipInputStream
			zis.close();
		}
		this.genererBaseConfig();
	}

	public void genererBaseConfig() throws IOException {
		// renommage des dossiers
		File folder = new File(this.racine_projet + this.nom_projet
				+ "/Prototype");
		File folder_dest = new File(this.racine_projet + this.nom_projet + "/"
				+ this.nom_projet);
		folder.renameTo(folder_dest);

		folder = new File(this.racine_projet + this.nom_projet
				+ "/Prototype-EJB");
		folder_dest = new File(this.racine_projet + this.nom_projet + "/"
				+ this.nom_projet + "-EJB");
		folder.renameTo(folder_dest);

		folder = new File(this.racine_projet + this.nom_projet
				+ "/Prototype-WEB");
		folder_dest = new File(this.racine_projet + this.nom_projet + "/"
				+ this.nom_projet + "-WEB");
		folder.renameTo(folder_dest);

		// adaptation des fichiers de configuration
		for (int i = 0; i < fconf.length; i++) {
			String ancien_contenu = Utils
					.recupererContenuFichier(this.racine_projet
							+ this.nom_projet + "/" + this.nom_projet
							+ fconf[i]);

			String nouveau_contenu = transformerTexte(ancien_contenu);

			Utils.mettreDansFichier(this.racine_projet + this.nom_projet + "/"
					+ this.nom_projet + fconf[i], nouveau_contenu);
		}
	}

	public void genererEntites() throws IOException {
		for (Iterator<EntiteM> itEntites = entites.iterator(); itEntites
				.hasNext();) {
			EntiteM e = (EntiteM) itEntites.next();
			e.generer(this.racine_projet, this.nom_projet);
		}
	}

	public void genererActions() throws IOException {
		for (Iterator<EntiteM> itEntites = entites.iterator(); itEntites
				.hasNext();) {
			EntiteM e = (EntiteM) itEntites.next();
			e.genererActions(this.racine_projet, this.nom_projet);
		}
	}

	public void genererStrutsConfig() throws IOException {
		String texte = Utils
				.recupererContenuFichier("ressources/config/struts-config-entites.xml");

		texte = transformerTexte(texte);

		Utils.mettreDansFichier(this.racine_projet + this.nom_projet + "/"
				+ this.nom_projet
				+ "-WEB/WebContent/WEB-INF/struts-config-entites.xml", texte);
	}

	public String getFormBeans() throws IOException {
		String formBeans = "";
		for (Iterator<EntiteM> itEntites = entites.iterator(); itEntites
				.hasNext();) {
			EntiteM e = (EntiteM) itEntites.next();
			formBeans += e.getFormBeans();
		}
		return formBeans;
	}

	public String getActionMappings() throws IOException {
		String actionMappings = "";
		for (Iterator<EntiteM> itEntites = entites.iterator(); itEntites
				.hasNext();) {
			EntiteM e = (EntiteM) itEntites.next();
			actionMappings += e.getActionMappings();
		}
		return actionMappings;
	}

	public String getMenu() {
		String text = "";
		for (Iterator<EntiteM> itEntites = this.entites.iterator(); itEntites
				.hasNext();) {
			EntiteM e = (EntiteM) itEntites.next();
			text += "<a href='list"
					+ Utils.capitalizeFirstLetters(e.getLibelle()) + ".do'>"
					+ e.getLibelle() + "</a> |";
		}
		return text;
	}

	private String transformerTexte(String s) throws IOException {
		String[] patterns = { "Prototype", "NOM_BASE", "DATA_SOURCE",
				"DIALECT", "FORM_BEANS", "ACTION_MAPPINGS", "MENU" };
		String[] dattums = { this.nom_projet, this.nom_base,
				this.source_donnees_ds, dialects().get(this.type_base),
				this.getFormBeans(), this.getActionMappings(), this.getMenu() };

		return Utils.tranformerTexte(s, patterns, dattums);
	}

	public void genererVues() throws IOException {
		for (Iterator<EntiteM> itEntites = this.entites.iterator(); itEntites
				.hasNext();) {
			EntiteM e = (EntiteM) itEntites.next();
			e.genererVues(this.racine_projet, this.nom_projet);
		}
	}

	public void generer() throws IOException {
		this.genererBaseProjet();
		this.genererEntites();
		this.genererStrutsConfig();
		this.genererActions();
		this.genererVues();
	}
}