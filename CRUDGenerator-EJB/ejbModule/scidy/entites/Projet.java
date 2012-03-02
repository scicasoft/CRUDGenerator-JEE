/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author scicasoft
 */
@Entity
@Table(name = "projet")
@NamedQueries({
    @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p"),
    @NamedQuery(name = "Projet.findById", query = "SELECT p FROM Projet p WHERE p.id = :id"),
    @NamedQuery(name = "Projet.findByNomProjet", query = "SELECT p FROM Projet p WHERE p.nomProjet = :nomProjet"),
    @NamedQuery(name = "Projet.findByRacineProjet", query = "SELECT p FROM Projet p WHERE p.racineProjet = :racineProjet"),
    @NamedQuery(name = "Projet.findByCheminLibStruts", query = "SELECT p FROM Projet p WHERE p.cheminLibStruts = :cheminLibStruts"),
    @NamedQuery(name = "Projet.findByNomBase", query = "SELECT p FROM Projet p WHERE p.nomBase = :nomBase"),
    @NamedQuery(name = "Projet.findBySourceDonneesDs", query = "SELECT p FROM Projet p WHERE p.sourceDonneesDs = :sourceDonneesDs")})
public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nom_projet", length = 50)
    private String nomProjet;
    @Column(name = "racine_projet", length = 255)
    private String racineProjet;
    @Column(name = "chemin_lib_struts", length = 500)
    private String cheminLibStruts;
    @Column(name = "nom_base", length = 50)
    private String nomBase;
    @Column(name = "source_donnees_ds", length = 100)
    private String sourceDonneesDs;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;
    @JoinColumn(name = "type_base_id", referencedColumnName = "id")
    @ManyToOne
    private TypeBase typeBase;
    @OneToMany(mappedBy = "projet")
    private List<HistoriqueGeneration> historiqueGenerationList;
    @OneToMany(mappedBy = "projet", fetch = FetchType.EAGER)
    private List<Entite> entiteList;

    public Projet() {
    }

    public Projet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getRacineProjet() {
        return racineProjet;
    }

    public void setRacineProjet(String racineProjet) {
        this.racineProjet = racineProjet;
    }

    public String getCheminLibStruts() {
        return cheminLibStruts;
    }

    public void setCheminLibStruts(String cheminLibStruts) {
        this.cheminLibStruts = cheminLibStruts;
    }

    public String getNomBase() {
        return nomBase;
    }

    public void setNomBase(String nomBase) {
        this.nomBase = nomBase;
    }

    public String getSourceDonneesDs() {
        return sourceDonneesDs;
    }

    public void setSourceDonneesDs(String sourceDonneesDs) {
        this.sourceDonneesDs = sourceDonneesDs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeBase getTypeBase() {
        return typeBase;
    }

    public void setTypeBase(TypeBase typeBase) {
        this.typeBase = typeBase;
    }

    public List<HistoriqueGeneration> getHistoriqueGenerationList() {
        return historiqueGenerationList;
    }

    public void setHistoriqueGenerationList(List<HistoriqueGeneration> historiqueGenerationList) {
        this.historiqueGenerationList = historiqueGenerationList;
    }
    
    public List<Entite> getEntiteList() {
        return entiteList;
    }

    public void setEntiteList(List<Entite> entiteList) {
        this.entiteList = entiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Projet[id=" + id + "]";
    }

}
