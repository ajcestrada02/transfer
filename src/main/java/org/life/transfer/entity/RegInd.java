/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
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

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "REG_IND")
public class RegInd extends BaseEntityUuid {
	
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name="REF_NO_TXT",
                referencedColumnName = "REF_NO_TXT",
                nullable = false,
                updatable = false,
                insertable = false)
    private Set<RegCntct> regCntcts;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name="REF_NO_TXT",
                referencedColumnName = "REF_NO_TXT",
                nullable = false,
                updatable = false,
                insertable = false)
    private Set<RegClntPhone> regClntPhones;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name="REF_NO_TXT",
                referencedColumnName = "REF_NO_TXT",
                nullable = false,
                updatable = false,
                insertable = false)
    private Set<RegAddr> regAddrs;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            length = 50, 
            nullable = false)
    private String refNoTxt;
    
    @Size(max = 20)
    @Column(name = "PNSN_ID_TXT",
            length = 20)
    private String pnsnIdTxt;
    
    @Size(max = 50)
    @Column(name = "FRST_NM",
            length = 50)
    private String frstNm;
    
    @Size(max = 50)
    @Column(name = "LST_NM",
            length = 50)
    private String lstNm;
    
    @Size(max = 50)
    @Column(name = "CHNS_FRST_NM",
            length = 50)
    private String chnsFrstNm;
    
    @Size(max = 50)
    @Column(name = "CHNS_LST_NM",
            length = 50)
    private String chnsLstNm;
    
    @Size(max = 20)
    @Column(name = "GNDR_TYP_ID",
            length = 20)
    private String gndrTypId;
    
    @Size(max = 20)
    @Column(name = "ID_TYP_ID",
            length = 20)
    private String idTypId;
    
    @Size(max = 50)
    @Column(name = "ID_NO_TXT",
            length = 50)
    private String idNoTxt;
    
    @Column(name = "BRTH_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date brthDt;
    
    @Size(max = 10)
    @Column(name = "USR_INPUT_BRTH_DT",
            length = 10)
    private String usrInputBrthDt;
    
    @Size(max = 10)
    @Column(name = "POB_CNTRY_TYP_CD",
            length = 10)
    private String pobCntryTypCd;
    
    @Size(max = 10)
    @Column(name = "NTNLTY_CNTRY_TYP_CD",
            length = 10)
    private String ntnltyCntryTypCd;
    
    @Column(name = "TX_RSDNC_HK_FLG")
    private Short txRsdncHkFlg;
    
    @Size(max = 10)
    @Column(name = "TX_CNTRY_TYP_CD",
            length = 10)
    private String txCntryTypCd;
    
    @Size(max = 20)
    @Column(name = "TIN_TXT",
            length = 20)
    private String tinTxt;
    
    @Size(max = 200)
    @Column(name = "RSN_WO_TIN_TXT",
            length = 200)
    private String rsnWoTinTxt;
    
    @Size(max = 200)
    @Column(name = "FRTHR_RSN_TXT",
            length = 200)
    private String frthrRsnTxt;
    
    @Size(max = 10)
    @Column(name = "TX2_CNTRY_TYP_CD",
            length = 10)
    private String tx2CntryTypCd;
    
    @Size(max = 20)
    @Column(name = "TIN2_TXT",
            length = 20)
    private String tin2Txt;
    
    @Size(max = 200)
    @Column(name = "RSN_WO_TIN2_TXT",
            length = 200)
    private String rsnWoTin2Txt;
    
    @Size(max = 200)
    @Column(name = "FRTHR_RSN2_TXT",
            length = 200)
    private String frthrRsn2Txt;
    
    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            length = 20)
    private String sttsTypId;
    
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
    
    public RegInd() {
    }
    
    public Set<RegAddr> getRegAddrs() {
        return regAddrs;
    }
    
    public void setRegAddrs(Set<RegAddr> regAddrs) {
        this.regAddrs = regAddrs;
    }
    
    public Set<RegClntPhone> getRegClntPhones() {
        return regClntPhones;
    }
    
    public void setRegClntPhones(Set<RegClntPhone> regClntPhones) {
        this.regClntPhones = regClntPhones;
        if(regClntPhones!=null){
            for(RegClntPhone regClntPhone: regClntPhones){
                if(regClntPhone.getRefNoTxt()==null){
                    regClntPhone.setRefNoTxt(this.refNoTxt);
                }
            }
        }
    }
    
    public Set<RegCntct> getRegCntcts() {
        return regCntcts;
    }
    
    public void setRegCntcts(Set<RegCntct> regCntcts) {
        this.regCntcts = regCntcts;
        if(regCntcts!=null){
            for(RegCntct regCntct: regCntcts){
                if(regCntct.getRefNoTxt()==null){
                    regCntct.setRefNoTxt(this.refNoTxt);
                }
            }
        }
    }
    
    public String getRefNoTxt() {
        return refNoTxt;
    }
    
    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }
    
    public String getPnsnIdTxt() {
        return pnsnIdTxt;
    }
    
    public void setPnsnIdTxt(String pnsnIdTxt) {
        this.pnsnIdTxt = pnsnIdTxt;
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
    
    public String getChnsFrstNm() {
        return chnsFrstNm;
    }
    
    public void setChnsFrstNm(String chnsFrstNm) {
        this.chnsFrstNm = chnsFrstNm;
    }
    
    public String getChnsLstNm() {
        return chnsLstNm;
    }
    
    public void setChnsLstNm(String chnsLstNm) {
        this.chnsLstNm = chnsLstNm;
    }
    
    public String getGndrTypId() {
        return gndrTypId;
    }
    
    public void setGndrTypId(String gndrTypId) {
        this.gndrTypId = gndrTypId;
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
    
    public Date getBrthDt() {
        return brthDt;
    }
    
    public void setBrthDt(Date brthDt) {
        this.brthDt = brthDt;
    }
    
    public String getUsrInputBrthDt() {
        return usrInputBrthDt;
    }
    
    public void setUsrInputBrthDt(String usrInputBrthDt) {
        this.usrInputBrthDt = usrInputBrthDt;
    }
    
    public String getPobCntryTypCd() {
        return pobCntryTypCd;
    }
    
    public void setPobCntryTypCd(String pobCntryTypCd) {
        this.pobCntryTypCd = pobCntryTypCd;
    }
    
    public String getNtnltyCntryTypCd() {
        return ntnltyCntryTypCd;
    }
    
    public void setNtnltyCntryTypCd(String ntnltyCntryTypCd) {
        this.ntnltyCntryTypCd = ntnltyCntryTypCd;
    }
    
    public Short getTxRsdncHkFlg() {
        return txRsdncHkFlg;
    }
    
    public void setTxRsdncHkFlg(Short txRsdncHkFlg) {
        this.txRsdncHkFlg = txRsdncHkFlg;
    }
    
    public String getTinTxt() {
        return tinTxt;
    }
    
    public void setTinTxt(String tinTxt) {
        this.tinTxt = tinTxt;
    }
    
    public String getRsnWoTinTxt() {
        return rsnWoTinTxt;
    }
    
    public void setRsnWoTinTxt(String rsnWoTinTxt) {
        this.rsnWoTinTxt = rsnWoTinTxt;
    }
    
    public String getFrthrRsnTxt() {
        return frthrRsnTxt;
    }
    
    public void setFrthrRsnTxt(String frthrRsnTxt) {
        this.frthrRsnTxt = frthrRsnTxt;
    }
    
    public String getTin2Txt() {
        return tin2Txt;
    }
    
    public void setTin2Txt(String tin2Txt) {
        this.tin2Txt = tin2Txt;
    }
    
    public String getRsnWoTin2Txt() {
        return rsnWoTin2Txt;
    }
    
    public void setRsnWoTin2Txt(String rsnWoTin2Txt) {
        this.rsnWoTin2Txt = rsnWoTin2Txt;
    }
    
    public String getFrthrRsn2Txt() {
        return frthrRsn2Txt;
    }
    
    public void setFrthrRsn2Txt(String frthrRsn2Txt) {
        this.frthrRsn2Txt = frthrRsn2Txt;
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

	public String getTxCntryTypCd() {
		return txCntryTypCd;
	}

	public void setTxCntryTypCd(String txCntryTypCd) {
		this.txCntryTypCd = txCntryTypCd;
	}

	public String getTx2CntryTypCd() {
		return tx2CntryTypCd;
	}

	public void setTx2CntryTypCd(String tx2CntryTypCd) {
		this.tx2CntryTypCd = tx2CntryTypCd;
	}

	public Date getChgDt() {
		return chgDt;
	}

	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}
    
}
