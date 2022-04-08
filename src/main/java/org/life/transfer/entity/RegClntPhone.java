/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.FetchType;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "REG_CLNT_PHONE")
public class RegClntPhone extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "REG_CNTCT_UUID",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    private RegCntct regCntct;

    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            length = 50)
    private String refNoTxt;
    
    @Size(max = 20)
    @Column(name = "PHN_TYP_ID",
            length = 20)
    private String phnTypId;
    
    @Size(max = 10)
    @Column(name = "PHN_CNTRY_TYP_CD",
            length = 10)
    private String phnCntryTypCd;

    @Column(name = "PHN_NMBR", 
            columnDefinition = "NUMBER(15, 0)")
    private Long phnNmbr;

    @NotNull
    @Column(name = "EFCTV_DT", 
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @Column(name = "reg_cntct_uuid",
			insertable = false, 
			updatable = false)
    private UUID regCntctUuid;

    public RegClntPhone() {
    }

    public RegCntct getRegCntct() {
        return regCntct;
    }

    public void setRegCntct(RegCntct regCntct) {
        this.regCntct = regCntct;
    }

    public String getRefNoTxt() {
        return refNoTxt;
    }

    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }

    public String getPhnTypId() {
        return phnTypId;
    }

    public void setPhnTypId(String phnTypId) {
        this.phnTypId = phnTypId;
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
    
    public UUID getRegCntctUuid() {
        return regCntctUuid;
    }
    
    public void setRegCntctUuid(UUID regCntctUuid) {
        this.regCntctUuid = regCntctUuid;
    }
}
