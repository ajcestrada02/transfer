/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Embeddable
public class CycleDatePK implements Serializable {

    @Column(name = "SCHM_UUID",
            insertable = false,
            updatable = false)
    private UUID schmUuid;
	
    @NotNull
    @Column(name = "CYCLE_DT_STP_CD",
            nullable = false)
    private Short cycleDtStpCd;

    public CycleDatePK() {
    }

    public CycleDatePK(short cycleDtStpCd) {
        this.cycleDtStpCd = cycleDtStpCd;
    }

    public CycleDatePK(short cycleDtStpCd, UUID schmUuid) {
        this.cycleDtStpCd = cycleDtStpCd;
        this.schmUuid = schmUuid;
    }

    public short getCycleDtStpCd() {
        return cycleDtStpCd;
    }

    public void setCycleDtStpCd(short cycleDtStpCd) {
        this.cycleDtStpCd = cycleDtStpCd;
    }

    public UUID getSchmUuid() {
        return schmUuid;
    }

    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cycleDtStpCd;
        hash += (schmUuid.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CycleDatePK)) {
            return false;
        }
        CycleDatePK other = (CycleDatePK) object;
        if (this.cycleDtStpCd != other.cycleDtStpCd) {
            return false;
        }
        return !((this.schmUuid == null && other.schmUuid != null) || (this.schmUuid != null && !this.schmUuid.equals(other.schmUuid)));
    }

    @Override
    public String toString() {
        return "org.life.entity.CycleDatePK[ cycleDtStpCd=" + cycleDtStpCd + ", schmUuid=" + schmUuid + " ]";
    }
    
}
