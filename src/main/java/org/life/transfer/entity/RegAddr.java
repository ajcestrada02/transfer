/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "REG_ADDR")
public class RegAddr extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH},
               fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_NO_TXT",
                referencedColumnName = "REF_NO_TXT",
                insertable = false,
                updatable = false)
    private ErRegCmpny erRegCmpny;

    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, 
               fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_ENTTY_CD_TXT",
                referencedColumnName = "REG_BRNCH_CD_TXT",
                insertable = false,
                updatable = false)
    private ErRegBrnch erRegBrnch;

    @NotNull
    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            nullable = false,
            length = 50)
    private String refNoTxt;

    @Size(max = 20)
    @Column(name = "REG_ENTTY_CD_TXT",
            length = 20)
    private String regEnttyCdTxt;
    
    @Size(max = 10)
    @Column(name = "ADDR_TYP_ID",
            length = 10)
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
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;

    public RegAddr() {

    }

    public ErRegCmpny getErRegCmpny() {
        return erRegCmpny;
    }

    public void setErRegCmpny(ErRegCmpny erRegCmpny) {
        this.erRegCmpny = erRegCmpny;
    }

    public ErRegBrnch getErRegBrnch() {
        return erRegBrnch;
    }

    public void setErRegBrnch(ErRegBrnch erRegBrnch) {
        this.erRegBrnch = erRegBrnch;
    }

    public String getRefNoTxt() {
        return refNoTxt;
    }

    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }

    public String getRegEnttyCdTxt() {
        return regEnttyCdTxt;
    }

    public void setRegEnttyCdTxt(String regEnttyCdTxt) {
        this.regEnttyCdTxt = regEnttyCdTxt;
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

}
