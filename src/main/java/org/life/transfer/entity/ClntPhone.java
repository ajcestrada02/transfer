/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "CLNT_PHONE")
public class ClntPhone extends BaseEntityUuid {

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "clnt_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    
    @JsonIgnore
    @JoinColumn(name="CNTCT_UUID",
                referencedColumnName="id")
    @ManyToOne(fetch = FetchType.LAZY,
               cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotFound(action = NotFoundAction.IGNORE)
    private Contact contact;

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PHN_TYP_ID",
            nullable = false,
            length = 20)
    private String phnTypId;

    @Column(name = "SCHM_UUID")
    private UUID schmUuid;

    @Column(name = "ENTTY_UUID")
    private UUID enttyUuid;

    @Size(max = 10)
    @Column(name = "PHN_CNTRY_TYP_CD")
    private String phnCntryTypCd;

    @Column(name = "PHN_NMBR")
    private Long phnNmbr;
    
    @Column(name = "EFCTV_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @Column(name = "clnt_uuid",
            updatable = false,
            insertable = false)
    private UUID clntUuid;
    
    @NotNull
    @Column(name = "CHG_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;
    
    @Column(name = "CNTCT_UUID",
            insertable = false,
            updatable = false)
    private UUID cntctUuid;
    
    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            length = 20)
    private String sttsTypId;

    public ClntPhone() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPhnTypId() {
        return phnTypId;
    }

    public void setPhnTypId(String phnTypId) {
        this.phnTypId = phnTypId;
    }

    public UUID getSchmUuid() {
        return schmUuid;
    }

    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }

    public UUID getEnttyUuid() {
        return enttyUuid;
    }

    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }

    public String getPhnCntryTypCd() {
        return phnCntryTypCd;
    }

    public void setPhnCntryTypCd(String phnCntryTypCd) {
        this.phnCntryTypCd = phnCntryTypCd;
    }

    public Long getPhnNmbr() {
        return phnNmbr;
    }

    public void setPhnNmbr(Long phnNmbr) {
        this.phnNmbr = phnNmbr;
    }

    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }

    public Date getChgDt() {
        return chgDt;
    }

    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public UUID getCntctUuid() {
		return cntctUuid;
	}

	public void setCntctUuid(UUID cntctUuid) {
		this.cntctUuid = cntctUuid;
	}
	
	public String getSttsTypId() {
		return sttsTypId;
	}

	public void setSttsTypId(String sttsTypId) {
		this.sttsTypId = sttsTypId;
	}
    
    public UUID getClntUuid() {
        return clntUuid;
    }
    
    public void setClntUuid(UUID clntUuid) {
        this.clntUuid = clntUuid;
    }
}
