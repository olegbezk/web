/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stars.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eugeny
 */
@Entity
@Table(name = "star")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Star.findAll", query = "SELECT s FROM Star s"),
    @NamedQuery(name = "Star.findById", query = "SELECT s FROM Star s WHERE s.starPK.id = :id"),
    @NamedQuery(name = "Star.findByRussianName", query = "SELECT s FROM Star s WHERE s.russianName = :russianName"),
    @NamedQuery(name = "Star.findByLatinName", query = "SELECT s FROM Star s WHERE s.latinName = :latinName"),
    @NamedQuery(name = "Star.findByDeclination", query = "SELECT s FROM Star s WHERE s.declination = :declination"),
    @NamedQuery(name = "Star.findByRightAscension", query = "SELECT s FROM Star s WHERE s.rightAscension = :rightAscension"),
    @NamedQuery(name = "Star.findByConstellationId", query = "SELECT s FROM Star s WHERE s.starPK.constellationId = :constellationId"),
    @NamedQuery(name = "Star.findByMagnitude", query = "SELECT s FROM Star s WHERE s.magnitude = :magnitude"),
    @NamedQuery(name = "Star.findByDistance", query = "SELECT s FROM Star s WHERE s.distance = :distance")})
public class Star implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StarPK starPK;
    @Size(max = 50)
    @Column(name = "russian_name")
    private String russianName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "latin_name")
    private String latinName;
    @Column(name = "declination")
    private Long declination;
    @Column(name = "right_ascension")
    private Long rightAscension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "magnitude")
    private int magnitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distance")
    private int distance;
    @JoinColumn(name = "constellation_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Constellation constellation;

    public Star() {
    }

    public Star(StarPK starPK) {
        this.starPK = starPK;
    }

    public Star(StarPK starPK, String latinName, int magnitude, int distance) {
        this.starPK = starPK;
        this.latinName = latinName;
        this.magnitude = magnitude;
        this.distance = distance;
    }

    public Star(int id, int constellationId) {
        this.starPK = new StarPK(id, constellationId);
    }

    public StarPK getStarPK() {
        return starPK;
    }

    public void setStarPK(StarPK starPK) {
        this.starPK = starPK;
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

    public Long getDeclination() {
        return declination;
    }

    public void setDeclination(Long declination) {
        this.declination = declination;
    }

    public Long getRightAscension() {
        return rightAscension;
    }

    public void setRightAscension(Long rightAscension) {
        this.rightAscension = rightAscension;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (starPK != null ? starPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Star)) {
            return false;
        }
        Star other = (Star) object;
        if ((this.starPK == null && other.starPK != null) || (this.starPK != null && !this.starPK.equals(other.starPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stars.server.Star[ starPK=" + starPK + " ]";
    }
    
}
