/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stars.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eugeny
 */
@Entity
@Table(name = "constellation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constellation.findAll", query = "SELECT c FROM Constellation c"),
    @NamedQuery(name = "Constellation.findById", query = "SELECT c FROM Constellation c WHERE c.id = :id"),
    @NamedQuery(name = "Constellation.findByRussianName", query = "SELECT c FROM Constellation c WHERE c.russianName = :russianName"),
    @NamedQuery(name = "Constellation.findByLatinName", query = "SELECT c FROM Constellation c WHERE c.latinName = :latinName")})
public class Constellation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "russian_name")
    private String russianName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "latin_name")
    private String latinName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constellation", fetch = FetchType.EAGER)
    private Collection<Star> starCollection;

    public Constellation() {
    }

    public Constellation(Integer id) {
        this.id = id;
    }

    public Constellation(Integer id, String latinName) {
        this.id = id;
        this.latinName = latinName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRussianName() {
        return russianName;
    }

    public void setRussianName(String russianName) {
        this.russianName = russianName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    @XmlTransient
    public Collection<Star> getStarCollection() {
        return starCollection;
    }

    public void setStarCollection(Collection<Star> starCollection) {
        this.starCollection = starCollection;
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
        if (!(object instanceof Constellation)) {
            return false;
        }
        Constellation other = (Constellation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stars.server.Constellation[ id=" + id + " ]";
    }
    
}
