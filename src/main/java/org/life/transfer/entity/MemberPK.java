/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Embeddable
public class MemberPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private ClientRelationship clientRelationship;

    @NotNull
    @Column(name = "mbr_cd",
            nullable = false, 
            columnDefinition = "NUMBER(15, 0)")
    private Long mbrCd;

    @Column(name = "mbr_grp_cd", 
            columnDefinition = "NUMBER(15, 0)")
    private Long mbrGrpCd;

    public MemberPK() {
    }

    public long getMbrCd() {
        return mbrCd;
    }

    public void setMbrCd(long mbrCd) {
        this.mbrCd = mbrCd;
    }

    public long getMbrGrpCd() {
        return mbrGrpCd;
    }

    public void setMbrGrpCd(long mbrGrpCd) {
        this.mbrGrpCd = mbrGrpCd;
    }

    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }

    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }

	@Override
    public int hashCode() {
        int hash = 0;
        hash += Long.hashCode(mbrGrpCd);
        hash += Long.hashCode(mbrCd);
        hash += clientRelationship.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberPK)) {
            return false;
        }
        MemberPK other = (MemberPK) object;
        if (this.mbrGrpCd != other.mbrGrpCd) {
            return false;
        }
        if (this.mbrCd != other.mbrCd) {
            return false;
        }
        if ((this.clientRelationship == null && other.clientRelationship != null) || (this.clientRelationship != null && !(this.clientRelationship.equals(other.clientRelationship)))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "MemberPK{" + "clientRelationship=" + clientRelationship + ", mbrCd=" + mbrCd + ", mbrGrpCd=" + mbrGrpCd + '}';
    }

}
