/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scidy.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author scicasoft
 */
@Entity
@Table(name = "historique_generation")
@NamedQueries({
    @NamedQuery(name = "HistoriqueGeneration.findAll", query = "SELECT h FROM HistoriqueGeneration h"),
    @NamedQuery(name = "HistoriqueGeneration.findById", query = "SELECT h FROM HistoriqueGeneration h WHERE h.id = :id"),
    @NamedQuery(name = "HistoriqueGeneration.findByDate", query = "SELECT h FROM HistoriqueGeneration h WHERE h.date = :date")})
public class HistoriqueGeneration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "projet_id", referencedColumnName = "id")
    @ManyToOne
    private Projet projet;

    public HistoriqueGeneration() {
    }

    public HistoriqueGeneration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
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
        if (!(object instanceof HistoriqueGeneration)) {
            return false;
        }
        HistoriqueGeneration other = (HistoriqueGeneration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.HistoriqueGeneration[id=" + id + "]";
    }

}
