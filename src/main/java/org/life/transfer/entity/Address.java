/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CLNT_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    @JsonIgnore
    @JoinColumn(name = "CNTCT_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;
    
    @Column(name = "CLNT_UUID",
                insertable = false,
                updatable = false)
    private UUID clntUuid;
    
    @Column(name = "CNTCT_UUID",
                insertable = false,
                updatable = false)
    private UUID cntctUuid;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ADDR_TYP_ID",
            nullable = false,
            length = 20)
    private String addrTypId;
    
    @Size(max = 100)
    @Column(name = "ADDR_RM_TXT",
            length = 100)
    private String addrRmTxt;
    
    @Size(max = 100)
    @Column(name = "ADDR_FLR_TXT", 
            length = 100)
    private String addrFlrTxt;
    
    @Size(max = 100)
    @Column(name = "ADDR_BLCK_TXT",
            length = 100)
    private String addrBlckTxt;
    
    @Size(max = 100)
    @Column(name = "ADDR_BLDNG_NM_TXT",
            length = 100)
    private String addrBldngNmTxt;
    
    @Size(max = 100)
    @Column(name = "ADDR_STRT_TXT",
            length = 100)
    private String addrStrtTxt;
    
    @Size(max = 100)
    @Column(name = "ADDR_DSTRCT_TXT",
            length = 100)
    private String addrDstrctTxt;
    
    @Size(max = 100)
    @Column(name = "ADDR_CTY_TXT",
            length = 100)
    private String addrCtyTxt;
    
    @Size(max = 10)
    @Column(name = "CNTRY_TYP_CD",
            length = 10)
    private String cntryTypCd;

    @NotNull
    @Column(name = "EFCTV_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;
    
    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            length = 20)
    private String sttsTypId;
    
    @Size(max = 15)
    @Column(name = "pstl_cd_txt",
            length = 15)
    private String pstlCdTxt;

    public Address() {
        super();
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

    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public String getAddrTypId() {
        return addrTypId;
    }

    public void setAddrTypId(String addrTypId) {
        this.addrTypId = addrTypId;
    }

    public String getAddrRmTxt() {
        return addrRmTxt;
    }

    public void setAddrRmTxt(String addrRmTxt) {
        this.addrRmTxt = addrRmTxt;
    }

    public String getAddrFlrTxt() {
        return addrFlrTxt;
    }

    public void setAddrFlrTxt(String addrFlrTxt) {
        this.addrFlrTxt = addrFlrTxt;
    }

    public String getAddrBlckTxt() {
        return addrBlckTxt;
    }

    public void setAddrBlckTxt(String addrBlckTxt) {
        this.addrBlckTxt = addrBlckTxt;
    }

    public String getAddrBldngNmTxt() {
        return addrBldngNmTxt;
    }

    public void setAddrBldngNmTxt(String addrBldngNmTxt) {
        this.addrBldngNmTxt = addrBldngNmTxt;
    }

    public String getAddrStrtTxt() {
        return addrStrtTxt;
    }

    public void setAddrStrtTxt(String addrStrtTxt) {
        this.addrStrtTxt = addrStrtTxt;
    }

    public String getAddrDstrctTxt() {
        return addrDstrctTxt;
    }

    public void setAddrDstrctTxt(String addrDstrctTxt) {
        this.addrDstrctTxt = addrDstrctTxt;
    }

    public String getAddrCtyTxt() {
        return addrCtyTxt;
    }

    public void setAddrCtyTxt(String addrCtyTxt) {
        this.addrCtyTxt = addrCtyTxt;
    }

    public String getCntryTypCd() {
        return cntryTypCd;
    }

    public void setCntryTypCd(String cntryTypCd) {
        this.cntryTypCd = cntryTypCd;
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

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }

	public UUID getCntctUuid() {
		return cntctUuid;
	}

	public void setCntctUuid(UUID cntctUuid) {
		this.cntctUuid = cntctUuid;
	}
    
    public String getPstlCdTxt() {
        return pstlCdTxt;
    }
    
    public void setPstlCdTxt(String pstlCdTxt) {
        this.pstlCdTxt = pstlCdTxt;
    }
}
