package org.life.transfer.entity;

import java.util.Date;

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
 * @author Arbe Padilla <ArbeJorgeA.Padilla@pccw.com>
 */

@Entity
@Table(name = "ER_REG_AUTH_PRSN")
public class ErRegAuthPrsn extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, 
               optional = false)
    @JoinColumn(name = "REF_NO_TXT",
                referencedColumnName = "REF_NO_TXT",
                nullable = false)
    private ErRegCmpny erRegCmpny;

  
    @Column(name = "REF_NO_TXT",
            insertable = false,
            updatable = false,
            length = 50)
    private String refNoTxt;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "REG_AUTH_PRSNL_CD_TXT",
            nullable = false,
            length = 20)
    private String regAuthPrsnlCdTxt;

    @Size(max = 20)
    @Column(name = "TTL_TYP_ID",
            length = 20)
    private String ttlTypId;
    
    @Size(max = 200)
    @Column(name = "FRST_NM",
            length = 200)
    private String frstNm;
    
    @Size(max = 200)
    @Column(name = "LST_NM",
            length = 200)
    private String lstNm;
    
    @Size(max = 200)
    @Column(name = "FRST_CHNS_NM",
            length = 200)
    private String frstChnsNm;
    
    @Size(max = 200)
    @Column(name = "LST_CHNS_NM",
            length = 200)
    private String lstChnsNm;
    
    @Size(max = 20)
    @Column(name = "GNDR_TYP_ID",
            length = 20)
    private String gndrTypId;
    
    @Size(max = 20)
    @Column(name = "USR_INPUT_BRTH_DT",
            length = 20)
    private String usrInputBrthDt;
    
    @Column(name = "BRTH_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date brthDt;
    
    @Column(name = "TX_RSDNC_HK_FLG", 
            columnDefinition = "Number(3, 0)")
    private Short txRsdncHkFlg;
    
    @Size(max = 10)
    @Column(name = "NTNLTY_CNTRY_TYP_CD",
            length = 10)
    private String ntnltyCntryTypCd;
    
    @Size(max = 10)
    @Column(name = "POB_CNTRY_TYP_CD",
            length = 10)
    private String pobCntryTypCd;
    
    @Size(max = 200)
    @Column(name = "JB_PSTN_TXT",
            length = 200)
    private String jbPstnTxt;
    
    @Size(max = 20)
    @Column(name = "ID_TYP_ID",
            length = 20)
    private String idTypId;
    
    @Size(max = 20)
    @Column(name = "ID_NO_TXT",
            length = 20)
    private String idNoTxt;
    
    @Size(max = 10)
    @Column(name = "CNTRY_TYP_CD",
            length = 10)
    private String cntryTypCd;
    
    @Column(name = "MBL_NO", 
            columnDefinition = "NUMBER(15, 0)")
    private Long mblNo;
    
    @Column(name = "FX_NO", 
            columnDefinition = "NUMBER(15, 0)")
    private Long fxNo;
    
    @Size(max = 20)
    @Column(name = "CMM_TYP_ID",
            length = 20)
    private String cmmTypId;
    
    @Size(max = 20)
    @Column(name = "LNGG_TYP_ID",
            length = 20)
    private String lnggTypId;
    
    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    private Date chgDt;
    
    @Size(max = 50)
    @Column(name = "eml_addr_txt",
            length = 50)
    private String emlAddTxt;

    public String getRefNoTxt() {
        return refNoTxt;
    }

    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }

    public String getRegAuthPrsnlCdTxt() {
        return regAuthPrsnlCdTxt;
    }

    public void setRegAuthPrsnlCdTxt(String regAuthPrsnlCdTxt) {
        this.regAuthPrsnlCdTxt = regAuthPrsnlCdTxt;
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

    public String getFrstChnsNm() {
        return frstChnsNm;
    }

    public void setFrstChnsNm(String frstChnsNm) {
        this.frstChnsNm = frstChnsNm;
    }

    public String getLstChnsNm() {
        return lstChnsNm;
    }

    public void setLstChnsNm(String lstChnsNm) {
        this.lstChnsNm = lstChnsNm;
    }

    public String getGndrTypId() {
        return gndrTypId;
    }

    public void setGndrTypId(String gndrTypId) {
        this.gndrTypId = gndrTypId;
    }

    public String getUsrInputBrthDt() {
        return usrInputBrthDt;
    }

    public void setUsrInputBrthDt(String usrInputBrthDt) {
        this.usrInputBrthDt = usrInputBrthDt;
    }

    public Date getBrthDt() {
        return brthDt;
    }

    public void setBrthDt(Date brthDt) {
        this.brthDt = brthDt;
    }

    public Short getTxRsdncHkFlg() {
        return txRsdncHkFlg;
    }

    public void setTxRsdncHkFlg(Short txRsdncHkFlg) {
        this.txRsdncHkFlg = txRsdncHkFlg;
    }

    public String getNtnltyCntryTypCd() {
        return ntnltyCntryTypCd;
    }

    public void setNtnltyCntryTypCd(String ntnltyCntryTypCd) {
        this.ntnltyCntryTypCd = ntnltyCntryTypCd;
    }

    public String getPobCntryTypCd() {
        return pobCntryTypCd;
    }

    public void setPobCntryTypCd(String pobCntryTypCd) {
        this.pobCntryTypCd = pobCntryTypCd;
    }

    public String getJbPstnTxt() {
        return jbPstnTxt;
    }

    public void setJbPstnTxt(String jbPstnTxt) {
        this.jbPstnTxt = jbPstnTxt;
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

    public String getCntryTypCd() {
        return cntryTypCd;
    }

    public void setCntryTypCd(String cntryTypCd) {
        this.cntryTypCd = cntryTypCd;
    }

    public Long getMblNo() {
        return mblNo;
    }

    public void setMblNo(Long mblNo) {
        this.mblNo = mblNo;
    }

    public Long getFxNo() {
        return fxNo;
    }

    public void setFxNo(Long fxNo) {
        this.fxNo = fxNo;
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

	public String getTtlTypId() {
		return ttlTypId;
	}

	public void setTtlTypId(String ttlTypId) {
		this.ttlTypId = ttlTypId;
	}
    
    public String getEmlAddTxt() {
        return emlAddTxt;
    }
    
    public void setEmlAddTxt(String emlAddTxt) {
        this.emlAddTxt = emlAddTxt;
    }
    
    public ErRegCmpny getErRegCmpny() {
        return erRegCmpny;
    }
    
    public void setErRegCmpny(ErRegCmpny erRegCmpny) {
        this.erRegCmpny = erRegCmpny;
    }
}
