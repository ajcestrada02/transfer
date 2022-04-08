/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;


/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "REG_CNTCT")
public class RegCntct extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            length = 50,
            nullable = false)
    private String refNoTxt;

    @Size(max = 20)
    @Column(name = "CNTCT_PRSN_TYP_ID",
            length = 20)
    private String cntctPrsnTypId;
    
    @Size(max = 20)
    @Column(name = "TTL_TYP_ID",
            length = 20)
    private String ttlTypId;
    
    @Size(max = 50)
    @Column(name = "FRST_NM",
            length = 50)
    private String frstNm;
    
    @Size(max = 50)
    @Column(name = "LST_NM",
            length = 50)
    private String lstNm;
    
    @Size(max = 20)
    @Column(name = "CMM_TYP_ID",
            length = 20)
    private String cmmTypId;
    
    @Size(max = 20)
    @Column(name = "LNGG_TYP_ID",
            length = 20)
    private String lnggTypId;
    
    @Column(name = "RCV_PPR_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short rcvPprFlg;

    @Column(name = "RCV_DRCT_MRKT_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short rcvDrctMrktFlg;

    @Column(name = "SCNDRY_CNTCT_NO", 
            columnDefinition = "NUMBER(15, 0)")
    private Long scndryCntctNo;
    
    @Size(max = 100)
    @Column(name = "EML_ADDR_TXT",
            length = 100)
    private String emlAddrTxt;

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

    public RegCntct() {
    }

    public void setTtlTypId(String ttlTypId) {
        this.ttlTypId = ttlTypId;
    }

    public String getRefNoTxt() {
        return refNoTxt;
    }

    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }

    public String getEmlAddrTxt() {
        return emlAddrTxt;
    }

    public void setEmlAddrTxt(String emlAddrTxt) {
        this.emlAddrTxt = emlAddrTxt;
    }

    public Long getScndryCntctNo() {
        return scndryCntctNo;
    }

    public void setScndryCntctNo(Long scndryCntctNo) {
        this.scndryCntctNo = scndryCntctNo;
    }

    public String getCntctPrsnTypId() {
        return cntctPrsnTypId;
    }

    public void setCntctPrsnTypId(String cntctPrsnTypId) {
        this.cntctPrsnTypId = cntctPrsnTypId;
    }

    public String getTtlTypId() {
        return ttlTypId;
    }

    public String getFrstNm() {
        return frstNm;
    }

    public void setFrstNm(String frstNm) {
        this.frstNm = frstNm;
    }

    public String getLstNm() {
        return lstNm;
    }

    public void setLstNm(String lstNm) {
        this.lstNm = lstNm;
    }

    public String getCmmTypId() {
        return cmmTypId;
    }

    public void setCmmTypId(String cmmTypId) {
        this.cmmTypId = cmmTypId;
    }

    public String getLnggTypId() {
        return lnggTypId;
    }

    public void setLnggTypId(String lnggTypId) {
        this.lnggTypId = lnggTypId;
    }

    public Short getRcvPprFlg() {
        return rcvPprFlg;
    }

    public void setRcvPprFlg(Short rcvPprFlg) {
        this.rcvPprFlg = rcvPprFlg;
    }

    public Short getRcvDrctMrktFlg() {
        return rcvDrctMrktFlg;
    }

    public void setRcvDrctMrktFlg(Short rcvDrctMrktFlg) {
        this.rcvDrctMrktFlg = rcvDrctMrktFlg;
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
