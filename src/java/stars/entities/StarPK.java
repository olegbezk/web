/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stars.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eugeny
 */
@Embeddable
public class StarPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "constellation_id")
    private int constellationId;

    public StarPK() {
    }

    public StarPK(int id, int constellationId) {
        this.id = id;
        this.constellationId = constellationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(int constellationId) {
        this.constellationId = constellationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) constellationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StarPK)) {
            return false;
        }
        StarPK other = (StarPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.constellationId != other.constellationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stars.server.StarPK[ id=" + id + ", constellationId=" + constellationId + " ]";
    }
    
}
