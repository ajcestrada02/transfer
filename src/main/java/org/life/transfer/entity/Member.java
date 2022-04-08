/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.OneToOne;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {
    
    private static final long serialVersionUID = 1L;
	
	@JsonIgnore
    @OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private ClientRelationship clientRelationship;
    
    @EmbeddedId
    protected MemberPK memberPK;
    
    @Size(max = 15)
    @Column(name = "mpfa_ref_no_txt",
            length = 15)
    private String mpfaRefNoTxt;
    
    @Size(max = 200)
    @Column(name = "JB_PSTN_TXT",
            length = 200)
    private String jbPstnTxt;
    
    @Size(max = 20)
    @Column(name = "stts_typ_id",
            length = 20)
    private String sttsTypId;
    
    @Size(max = 20)
    @Column(name = "mbr_typ_id",
            length = 20)
    private String mbrTypId;
    
    @NotNull
    @Column(name = "dis_chg_by_dflt_flg",
            nullable = false, 
            columnDefinition = "NUMBER(3, 0)")
    private Short disChgByDfltFlg;
    
    @Column(name = "org_emp_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgEmpDt;
    
    @Column(name = "emp_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empDt;
    
    @Column(name = "term_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDt;
    
    @Size(max = 200)
    @Column(name = "term_rsn_id",
            length = 200)
    private String termRsnId;
    
    @Column(name = "inst_frm_er_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short instFrmErFlg;
    
    @Column(name = "tfer_to_entty_uuid")
    private UUID tferToEnttyUuid;
    
    @Size(max = 20)
    @Column(name = "tfer_typ_id",
            length = 20)
    private String tferTypId;
    
    @Column(name = "er_lspsp_doc_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erLspspDocDt;
    
    @Column(name = "join_schm_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinSchmDt;
    
    @Column(name = "ldoe_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ldoeDt;
    
    @Size(max = 300)
    @Column(name = "addtnl_dtl_txt",
            length = 300)
    private String addtnlDtlTxt;
    
    @Size(max = 20)
    @Column(name = "ee_typ_id",
            length = 20)
    private String eeTypId;
    
    @Size(max = 20)
    @Column(name = "occptn_typ_id",
            length = 20)
    private String occptnTypId;
    
    @Size(max = 20)
    @Column(name = "stff_nmbr_txt",
            length = 20)
    private String stffNmbrTxt;
    
    @Size(max = 20)
    @Column(name = "ntr_typ_id",
            length = 20)
    private String ntrTypId;
    
    @Size(max = 50)
    @Column(name = "reg_ref_no_txt",
            length = 50)
    private String regRefNoTxt;
    
    @Column(name = "enrl_stp_cd", 
            columnDefinition = "NUMBER(5, 0)")
    private Short enrlStpCd;
    
    @Size(max = 100)
    @Column(name = "doc_pth_txt",
            length = 100)
    private String docPthTxt;
    
    @Column(name = "cntrb_paid_to_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntrbPaidToDt;
    
    @Column(name = "frmr_er_uuid")
    private UUID frmrErUuid;
    
    @Size(max = 20)
    @Column(name = "cmm_typ_id",
            length = 20)
    private String cmmTypId;
    
    @Size(max = 20)
    @Column(name = "dprtr_typ_id",
            length = 20)
    private String dprtrTypId;
    
    @Column(name = "dprtr_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dprtrDt;
    
    @Column(name = "acknwldg_tc_pics_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short acknwldgTcPicsFlg;
    
    @Column(name = "e_ntfctn_rgltry_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short eNtfctnRgltryFlg;
    
    @Column(name = "e_ntfctn_non_rgltry_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short eNtfctnNonRgltryFlg;
    
    @Column(name = "visa_iss_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visaIssDt;
    
    @Size(max = 50)
    @Column(name = "trst_mbr_txt",
            length = 50)
    private String trstMbrTxt;
    
    @Size(max = 20)
    @Column(name = "fund_clss_typ_id",
            length = 20)
    private String fundClssTypId;
    
    @Column(name = "cntrb_hldy_vc_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short cntrbHldyVcFlg;
    
    @Column(name = "ntfctn_hrdcpy_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short ntfctnHrdcpyFlg;
    
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
    
    @Column(name = "join_vc_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinVcDt;

    @Column(name = "undr_adt_flg",
            columnDefinition = "NUMBER(3, 0)")
    private Short undrAdtFlg;

    @Column(name = "adt_cmmncmnt_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adtCmmncmntDt;

    @Column(name = "adt_cmplt_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adtCmpltDt;

    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }
    
    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }
    
    public MemberPK getMemberPK() {
        return memberPK;
    }
    
    public void setMemberPK(MemberPK memberPK) {
        this.memberPK = memberPK;
    }
    
    public String getMpfaRefNoTxt() {
        return mpfaRefNoTxt;
    }
    
    public void setMpfaRefNoTxt(String mpfaRefNoTxt) {
        this.mpfaRefNoTxt = mpfaRefNoTxt;
    }
    
    
    public String getSttsTypId() {
        return sttsTypId;
    }
    
    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }
    
    public String getMbrTypId() {
        return mbrTypId;
    }
    
    public void setMbrTypId(String mbrTypId) {
        this.mbrTypId = mbrTypId;
    }
    
    public Short getDisChgByDfltFlg() {
        return disChgByDfltFlg;
    }
    
    public void setDisChgByDfltFlg(Short disChgByDfltFlg) {
        this.disChgByDfltFlg = disChgByDfltFlg;
    }
    
    public Date getOrgEmpDt() {
        return orgEmpDt;
    }
    
    public void setOrgEmpDt(Date orgEmpDt) {
        this.orgEmpDt = orgEmpDt;
    }
    
    public Date getEmpDt() {
        return empDt;
    }
    
    public void setEmpDt(Date empDt) {
        this.empDt = empDt;
    }
    
    public Date getTermDt() {
        return termDt;
    }
    
    public void setTermDt(Date termDt) {
        this.termDt = termDt;
    }
    
    public void setTermRsnTxt(String termRsnId) {
        this.termRsnId = termRsnId;
    }
    
    public Short getInstFrmErFlg() {
        return instFrmErFlg;
    }
    
    public void setInstFrmErFlg(Short instFrmErFlg) {
        this.instFrmErFlg = instFrmErFlg;
    }
    
    public UUID getTferToEnttyUuid() {
        return tferToEnttyUuid;
    }
    
    public void setTferToEnttyUuid(UUID tferToEnttyUuid) {
        this.tferToEnttyUuid = tferToEnttyUuid;
    }
    
    public String getTferTypId() {
        return tferTypId;
    }
    
    public void setTferTypId(String tferTypId) {
        this.tferTypId = tferTypId;
    }
    
    public Date getErLspspDocDt() {
        return erLspspDocDt;
    }
    
    public void setErLspspDocDt(Date erLspspDocDt) {
        this.erLspspDocDt = erLspspDocDt;
    }
    
    public Date getJoinSchmDt() {
        return joinSchmDt;
    }
    
    public void setJoinSchmDt(Date joinSchmDt) {
        this.joinSchmDt = joinSchmDt;
    }
    
    public Date getLdoeDt() {
        return ldoeDt;
    }
    
    public void setLdoeDt(Date ldoeDt) {
        this.ldoeDt = ldoeDt;
    }
    
    public String getAddtnlDtlTxt() {
        return addtnlDtlTxt;
    }
    
    public void setAddtnlDtlTxt(String addtnlDtlTxt) {
        this.addtnlDtlTxt = addtnlDtlTxt;
    }
    
    public String getEeTypId() {
        return eeTypId;
    }
    
    public void setEeTypId(String eeTypId) {
        this.eeTypId = eeTypId;
    }
    
    public String getStffNmbrTxt() {
        return stffNmbrTxt;
    }
    
    public void setStffNmbrTxt(String stffNmbrTxt) {
        this.stffNmbrTxt = stffNmbrTxt;
    }
    
    public String getNtrTypId() {
        return ntrTypId;
    }
    
    public void setNtrTypId(String ntrTypId) {
        this.ntrTypId = ntrTypId;
    }
    
    public String getRegRefNoTxt() {
        return regRefNoTxt;
    }
    
    public void setRegRefNoTxt(String regRefNoTxt) {
        this.regRefNoTxt = regRefNoTxt;
    }
    
    public Short getEnrlStpCd() {
        return enrlStpCd;
    }
    
    public void setEnrlStpCd(Short enrlStpCd) {
        this.enrlStpCd = enrlStpCd;
    }
    
    public String getDocPthTxt() {
        return docPthTxt;
    }
    
    public void setDocPthTxt(String docPthTxt) {
        this.docPthTxt = docPthTxt;
    }
    
    public Date getCntrbPaidToDt() {
        return cntrbPaidToDt;
    }
    
    public void setCntrbPaidToDt(Date cntrbPaidToDt) {
        this.cntrbPaidToDt = cntrbPaidToDt;
    }
    
    public UUID getFrmrErUuid() {
        return frmrErUuid;
    }
    
    public void setFrmrErUuid(UUID frmrErUuid) {
        this.frmrErUuid = frmrErUuid;
    }
    
    public String getCmmTypId() {
        return cmmTypId;
    }
    
    public void setCmmTypId(String cmmTypId) {
        this.cmmTypId = cmmTypId;
    }
    
    public String getDprtrTypId() {
        return dprtrTypId;
    }
    
    public void setDprtrTypId(String dprtrTypId) {
        this.dprtrTypId = dprtrTypId;
    }
    
    public Short getAcknwldgTcPicsFlg() {
        return acknwldgTcPicsFlg;
    }
    
    public void setAcknwldgTcPicsFlg(Short acknwldgTcPicsFlg) {
        this.acknwldgTcPicsFlg = acknwldgTcPicsFlg;
    }
    
    public Short geteNtfctnRgltryFlg() {
        return eNtfctnRgltryFlg;
    }
    
    public void seteNtfctnRgltryFlg(Short eNtfctnRgltryFlg) {
        this.eNtfctnRgltryFlg = eNtfctnRgltryFlg;
    }
    
    public Short geteNtfctnNonRgltryFlg() {
        return eNtfctnNonRgltryFlg;
    }
    
    public void seteNtfctnNonRgltryFlg(Short eNtfctnNonRgltryFlg) {
        this.eNtfctnNonRgltryFlg = eNtfctnNonRgltryFlg;
    }
    
    public String getTrstMbrTxt() {
        return trstMbrTxt;
    }
    
    public void setTrstMbrTxt(String trstMbrTxt) {
        this.trstMbrTxt = trstMbrTxt;
    }
    
    public Date getEfctvDt() {
        return efctvDt;
    }
    
    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }
    
    public String getJbPstnTxt() {
        return jbPstnTxt;
    }
    
    public void setJbPstnTxt(String jbPstnTxt) {
        this.jbPstnTxt = jbPstnTxt;
    }
    
    public String getTermRsnId() {
        return termRsnId;
    }
    
    public void setTermRsnId(String termRsnId) {
        this.termRsnId = termRsnId;
    }
    
    public String getOccptnTypId() {
        return occptnTypId;
    }
    
    public void setOccptnTypId(String occptnTypId) {
        this.occptnTypId = occptnTypId;
    }
    
    public Date getDprtrDt() {
        return dprtrDt;
    }
    
    public void setDprtrDt(Date dprtrDt) {
        this.dprtrDt = dprtrDt;
    }
    
    public Date getVisaIssDt() {
        return visaIssDt;
    }
    
    public void setVisaIssDt(Date visaIssDt) {
        this.visaIssDt = visaIssDt;
    }
    
    public String getFundClssTypId() {
        return fundClssTypId;
    }
    
    public void setFundClssTypId(String fundClssTypId) {
        this.fundClssTypId = fundClssTypId;
    }
    
    public Short getCntrbHldyVcFlg() {
        return cntrbHldyVcFlg;
    }
    
    public void setCntrbHldyVcFlg(Short cntrbHldyVcFlg) {
        this.cntrbHldyVcFlg = cntrbHldyVcFlg;
    }
    
    public Short getNtfctnHrdcpyFlg() {
        return ntfctnHrdcpyFlg;
    }
    
    public void setNtfctnHrdcpyFlg(Short ntfctnHrdcpyFlg) {
        this.ntfctnHrdcpyFlg = ntfctnHrdcpyFlg;
    }
    
    public Date getChgDt() {
        return chgDt;
    }
    
    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }
    
    public Date getJoinVcDt() {
        return joinVcDt;
    }
    
    public void setJoinVcDt(Date joinVcDt) {
        this.joinVcDt = joinVcDt;
    }

    public Short getUndrAdtFlg() {
        return undrAdtFlg;
    }

    public void setUndrAdtFlg(Short undrAdtFlg) {
        this.undrAdtFlg = undrAdtFlg;
    }

    public Date getAdtCmmncmntDt() {
        return adtCmmncmntDt;
    }

    public void setAdtCmmncmntDt(Date adtCmmncmntDt) {
        this.adtCmmncmntDt = adtCmmncmntDt;
    }

    public Date getAdtCmpltDt() {
        return adtCmpltDt;
    }

    public void setAdtCmpltDt(Date adtCmpltDt) {
        this.adtCmpltDt = adtCmpltDt;
    }
}