/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "IDENTIFICATION")
public class Identification extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CLNT_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    @Column(name = "CLNT_UUID",
            insertable = false,
            updatable = false)
    private UUID clntUuid;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_TYP_ID",
            nullable = false, 
            length = 20)
    private String idTypId;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ID_NO_TXT",
            nullable = false, 
            length = 50)
    private String idNoTxt;

    @Size(min = 1, max = 1)
    @Column(name = "ID_CHK_DGT_TXT",
            length = 1)
    private String idChkDgtTxt;
    
    @Size(max = 10)
    @Column(name = "ID_CNTRY_TYP_CD",
            length = 10)
    private String idCntryTypCd;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BSNSS_REG_EXPRY_DT")
    private Date bsnssRegExpryDt;

    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;

    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;

    public Identification() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public UUID getClntUuid() {
        return clntUuid;
    }

    public void setClntUuid(UUID clntUuid) {
        this.clntUuid = clntUuid;
    }

    public Date getChgDt() {
        return chgDt;
    }

    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }

    public String getIdTypId() {
        return idTypId;
    }

    public void setIdTypId(String idTypId) {
        this.idTypId = idTypId;
    }

    public String getIdNoTxt() {
        return idNoTxt;
    }

    public void setIdNoTxt(String idNoTxt) {
        this.idNoTxt = idNoTxt;
    }

    public String getIdChkDgtTxt() {
        return idChkDgtTxt;
    }

    public void setIdChkDgtTxt(String idChkDgtTxt) {
        this.idChkDgtTxt = idChkDgtTxt;
    }

    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }

	public String getIdCntryTypCd() {
		return idCntryTypCd;
	}

	public void setIdCntryTypCd(String idCntryTypCd) {
		this.idCntryTypCd = idCntryTypCd;
	}

	public Date getBsnssRegExpryDt() {
		return bsnssRegExpryDt;
	}

	public void setBsnssRegExpryDt(Date bsnssRegExpryDt) {
		this.bsnssRegExpryDt = bsnssRegExpryDt;
	}
}
