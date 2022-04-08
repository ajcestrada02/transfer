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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "SYSTEM_PARAMETERS")
public class SystemParameters extends BaseEntityUuid {
    
    @Column(name = "SCHM_UUID")
    private UUID schmUuid;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "PRMTR_NM",
            nullable = false,
            length = 100)
    private String prmtrNm;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "PRMTR_TYP",
            nullable = false,
            length = 20)
    private String prmtrTyp;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "PRMTR_VAL",
            nullable = false,
            length = 200)
    private String prmtrVal;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "PRMTR_DSCRPTN",
            nullable = false,
            length = 200)
    private String prmtrDscrptn;
    
    @NotNull
    @Column(name = "PRMTR_EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date prmtrEfctvDt;

    public SystemParameters() {
    }

    public UUID getSchmUuid() {
        return schmUuid;
    }

    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }

    public String getPrmtrNm() {
        return prmtrNm;
    }

    public void setPrmtrNm(String prmtrNm) {
        this.prmtrNm = prmtrNm;
    }

    public String getPrmtrTyp() {
        return prmtrTyp;
    }

    public void setPrmtrTyp(String prmtrTyp) {
        this.prmtrTyp = prmtrTyp;
    }

    public String getPrmtrVal() {
        return prmtrVal;
    }

    public void setPrmtrVal(String prmtrVal) {
        this.prmtrVal = prmtrVal;
    }

    public String getPrmtrDscrptn() {
        return prmtrDscrptn;
    }

    public void setPrmtrDscrptn(String prmtrDscrptn) {
        this.prmtrDscrptn = prmtrDscrptn;
    }

    public Date getPrmtrEfctvDt() {
        return prmtrEfctvDt;
    }

    public void setPrmtrEfctvDt(Date prmtrEfctvDt) {
        this.prmtrEfctvDt = prmtrEfctvDt;
    }
    
}
