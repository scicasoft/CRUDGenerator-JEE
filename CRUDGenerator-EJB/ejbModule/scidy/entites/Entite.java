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
 * @author scicasoft
 */
@Entity
@Table(name = "entite", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"nom_entite", "projet_id" }) })
@NamedQueries({
		@NamedQuery(name = "Entite.findAll", query = "SELECT e FROM Entite e"),
		@NamedQuery(name = "Entite.findById", query = "SELECT e FROM Entite e WHERE e.id = :id"),
		@NamedQuery(name = "Entite.findByNomEntite", query = "SELECT e FROM Entite e WHERE e.nomEntite = :nomEntite") })
public class Entite implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "nom_entite", length = 50)
	private String nomEntite;
	@OneToMany(mappedBy = "entite")
	private List<Attribut> attributList;

	@JoinColumn(name = "projet_id", referencedColumnName = "id")
	@ManyToOne
	private Projet projet;

	public Entite() {
	}

	public Entite(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEntite() {
		return nomEntite;
	}

	public void setNomEntite(String nomEntite) {
		this.nomEntite = nomEntite;
	}

	public List<Attribut> getAttributList() {
		return attributList;
	}

	public void setAttributList(List<Attribut> attributList) {
		this.attributList = attributList;
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
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Entite)) {
			return false;
		}
		Entite other = (Entite) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entites.Entite[id=" + id + "]";
	}

}
