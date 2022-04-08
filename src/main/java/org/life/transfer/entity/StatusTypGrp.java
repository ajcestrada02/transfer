/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import java.util.Date;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "STTS_TYP_GRP")
public class StatusTypGrp extends BaseEntityUuid {

    @Size(max = 20)
    @Column(name = "wrkstrm_typ_txt", 
            length = 20)
    private String wrkstrmTypTxt;

    @Size(max = 20)
    @Column(name = "stts_typ_id", 
            length = 20)
    private String sttsTypId;

    @NotNull
    @Column(name = "efctv_dt",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "chg_dt",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;


    public String getWrkstrmTypTxt() {
        return wrkstrmTypTxt;
    }

    public void setWrkstrmTypTxt(String wrkstrmTypTxt) {
        this.wrkstrmTypTxt = wrkstrmTypTxt;
    }

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
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

    public StatusTypGrp() {

    }

}
