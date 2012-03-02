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
@Table(name = "type_base", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"driver"})})
@NamedQueries({
    @NamedQuery(name = "TypeBase.findAll", query = "SELECT t FROM TypeBase t"),
    @NamedQuery(name = "TypeBase.findById", query = "SELECT t FROM TypeBase t WHERE t.id = :id"),
    @NamedQuery(name = "TypeBase.findByDriver", query = "SELECT t FROM TypeBase t WHERE t.driver = :driver"),
    @NamedQuery(name = "TypeBase.findByDialect", query = "SELECT t FROM TypeBase t WHERE t.dialect = :dialect")})
public class TypeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "driver", nullable = false, length = 50)
    private String driver;
    @Column(name = "dialect", length = 100)
    private String dialect;
    @OneToMany(mappedBy = "typeBase")
    private List<Projet> projetList;

    public TypeBase() {
    }

    public TypeBase(Integer id) {
        this.id = id;
    }

    public TypeBase(Integer id, String driver) {
        this.id = id;
        this.driver = driver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
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
        if (!(object instanceof TypeBase)) {
            return false;
        }
        TypeBase other = (TypeBase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.TypeBase[id=" + id + "]";
    }

}
