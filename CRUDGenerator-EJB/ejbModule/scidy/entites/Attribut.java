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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author scidy
 */
@Entity
@Table(name = "attribut", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"entite_id", "nom_attribut"})})
@NamedQueries({
    @NamedQuery(name = "Attribut.findAll", query = "SELECT a FROM Attribut a"),
    @NamedQuery(name = "Attribut.findByEntiteId", query = "SELECT a FROM Attribut a WHERE a.entite = :entite_id"),
    @NamedQuery(name = "Attribut.findById", query = "SELECT a FROM Attribut a WHERE a.id = :id"),
    @NamedQuery(name = "Attribut.findByNomAttribut", query = "SELECT a FROM Attribut a WHERE a.nomAttribut = :nomAttribut"),
    @NamedQuery(name = "Attribut.findByClePrimaire", query = "SELECT a FROM Attribut a WHERE a.clePrimaire = :clePrimaire"),
    @NamedQuery(name = "Attribut.findByRequis", query = "SELECT a FROM Attribut a WHERE a.requis = :requis"),
    @NamedQuery(name = "Attribut.findByLabel", query = "SELECT a FROM Attribut a WHERE a.label = :label"),
    @NamedQuery(name = "Attribut.findByType", query = "SELECT a FROM Attribut a WHERE a.type = :type"),
    @NamedQuery(name = "Attribut.findByUnique", query = "SELECT a FROM Attribut a WHERE a.unique = :unique")})
public class Attribut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nom_attribut", length = 50)
    private String nomAttribut;
    @Column(name = "cle_primaire")
    private Boolean clePrimaire;
    @Column(name = "requis")
    private Boolean requis;
    @Column(name = "label", length = 100)
    private String label;
    @Column(name = "type", length = 25)
    private String type;
    @Column(name = "attribut_unique")
    private Boolean unique;
    @JoinColumn(name = "entite_id", referencedColumnName = "id")
    @ManyToOne
    private Entite entite;
    @OneToMany(mappedBy = "attribut")
    private List<Attribut> attributList;
    @JoinColumn(name = "foreign_key", referencedColumnName = "id")
    @ManyToOne
    private Attribut attribut;

    public Attribut() {
    }

    public Attribut(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomAttribut() {
        return nomAttribut;
    }

    public void setNomAttribut(String nomAttribut) {
        this.nomAttribut = nomAttribut;
    }

    public Boolean getClePrimaire() {
        return clePrimaire;
    }

    public void setClePrimaire(Boolean clePrimaire) {
        this.clePrimaire = clePrimaire;
    }

    public Boolean getRequis() {
        return requis;
    }

    public void setRequis(Boolean requis) {
        this.requis = requis;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    public List<Attribut> getAttributList() {
        return attributList;
    }

    public void setAttributList(List<Attribut> attributList) {
        this.attributList = attributList;
    }

    public Attribut getAttribut() {
        return attribut;
    }

    public void setAttribut(Attribut attribut) {
        this.attribut = attribut;
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
        if (!(object instanceof Attribut)) {
            return false;
        }
        Attribut other = (Attribut) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Attribut[id=" + id + "]";
    }

}
