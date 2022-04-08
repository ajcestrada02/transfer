/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "SCHEME")
public class Scheme extends BaseEntityUuid {
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheme")
    private List<ClientRelationship> clientRelationships;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheme")
    private Set<SchmExcldMbrTyp> schmExcldMbrTyps;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheme")
    private Set<InstTferInfo> instTferInfos;
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "TRST_UUID",
            referencedColumnName = "id",
            nullable = false)
    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    private Trustee trustee;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "scheme")
    private Set<Fund> funds;
    
    
    @NotNull
    @Column(name = "SCHM_CD",
            unique = true,
            nullable = false,
            columnDefinition = "NUMBER(15, 0)")
    private Long schmCd;
    
    @Size(max = 200)
    @NotNull
    @Column(name = "SCHM_NM",
            nullable = false,
            length = 200)
    private String schmNm;
    
    @Size(max = 200)
    @NotNull
    @Column(name = "SCHM_CHNS_NM",
            nullable = false,
            length = 200)
    private String schmChnsNm;
    
    @Size(max = 20)
    @Column(name = "SCHM_TYP_ID",
            length = 20)
    private String schmTypId;
    
    @Size(max = 20)
    @Column(name = "SCHM_REG_NO_TXT",
            length = 20)
    private String schmRegNoTxt;
    
    @Size(max = 10)
    @NotNull
    @Column(name = "SCHM_ABB_NM",
            nullable = false,
            length = 10)
    private String schmAbbNm;
    
    @Size(max = 5)
    @Column(name = "FNNCL_YR_DT_TXT",
            length = 5)
    private String fnnclYrDtTxt;
    
    @Column(name = "MX_SW_RBL_CNT",
            columnDefinition = "NUMBER(3,0)")
    private Short mxSwRblCnt;
    
    @Column(name = "MX_CHG_INV_MNDT_CNT",
            columnDefinition = "NUMBER(3,0)")
    private Short mxChgInvMndtCnt;
    
    @Column(name = "MX_ECA_WO_CHRG_CNT",
            columnDefinition = "NUMBER(3,0)")
    private Short mxEcaWoChrgCnt;
    
    @Column(name = "ALLW_PRTL_DIS_FLG",
            columnDefinition = "NUMBER(3,0)")
    private Short allwPrtlDisFlg;
    
    @Column(name = "MN_VC_AMT",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal mnVcAmt;
    
    @Column(name = "MX_VC_AMT",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal mxVcAmt;
    
    @Column(name = "TVC_MN_AMT",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal tvcMnAmt;
    
    @Column(name = "SVC_MN_AMT",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal svcMnAmt;
    
    @Column(name = "MN_SW_PRCNTG_RT",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal mnSwPrcntgRt;
    
    @Size(max = 200)
    @Column(name = "FUND_DLNG_DT_NM",
            length = 200)
    private String fundDlngDtNm;
    
    @Column(name = "PRTL_WTHDRWL_VC_FLG")
    private Short prtlWthdrwlVcFlg;
    
    @Column(name = "PHS_WTHDRWL_MN_AMT",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal phsWthdrwlMnAmt;
    
    @Column(name = "PHS_WTHDRWL_FREE_CNT",
            columnDefinition = "NUMBER(3,0)")
    private Short phsWthdrwlFreeCnt;
    
    @Column(name = "PHS_WTHDRWL_FEE",
            columnDefinition = "NUMBER(19, 2)")
    private BigDecimal phsWthdrwlFee;
    
    @Size(max = 20)
    @Column(name = "FUND_SWTCH_TYP_ID",
            length = 20)
    private String fundSwtchTypId;
    
    @Column(name = "SCHM_UNDR_ADT_FLG")
    private Short schmUndrAdtFlg;
    
    @Column(name = "ADT_CMPLT_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adtCmpltDt;
    
    @Column(name = "ADT_CMMNCMNT_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adtCmmncmntDt;
    
    @Column(name = "SCHM_UNDR_INVTGTN_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short schmUndrInvtgtnFlg;
    
    @Column(name = "ALLW_VC_TFER_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short allwVcTferFlg;
    
    @Column(name = "ALLW_VC_WTHDRWL_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short allwVcWthdrwlFlg;
    
    @Column(name = "ALLW_VC_WTHDRWL_ALL_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short allwVcWthdrwlAllFlg;
    
    @Column(name = "ALLW_VC_WTHDRWL_PRCNTG_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short allwVcWthdrwlPrcntgFlg;
    
    @Column(name = "ALLW_VC_WTHDRWL_FUND_PRCNTG_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short allwVcWthdrwlFundPrcntgFlg;
    
    @Column(name = "VC_WTHDRWL_PRCNTG_IN_MLTPL",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlPrcntgInMltpl;
    
    @Column(name = "VC_WTHDRWL_MIN_PRCNTG",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlMinPrcntg;
    
    @Column(name = "VC_WTHDRWL_FUND_PRCNTG_IN_MLTPL",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlFundPrcntgInMltpl;
    
    @Column(name = "VC_WTHDRWL_MIN_FUND_PRCNTG",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlMinFundPrcntg;
    
    @Column(name = "VC_WTHDRWL_MIN_AMT",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlMinAmt;
    
    @Column(name = "VC_WTHDRWL_AMT_IN_MLTPL",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlAmtInMltpl;
    
    @Column(name = "VC_WTHDRWL_ER_CNSNT",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlErCnsnt;
    
    @Column(name = "VC_WTHDRWL_TR_CNSNT",
            columnDefinition = "NUMBER(3, 0)")
    private Short vcWthdrwlTrCnsnt;
    
    @Column(name = "UNCLM_REINV_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Short unclmReinvFlg;
    
    @Size(max = 20)
    @Column(name = "CNTRB_RUN_FRQNCY_TYP_ID",
            length = 20)
    private String cntrbRunFrqncyTypId;
    
    @Size(max = 20)
    @Column(name = "BLL_RUN_FRQNCY_TYP_ID",
            length = 20)
    private String bllRunFrqncyTypId;
    
    @Size(max = 2)
    @Column(name = "CNTRB_RUN_DY",
            length = 2)
    private String cntrbRunDy;
    
    @Size(max = 2)
    @Column(name = "BLL_RUN_DY",
            length = 2)
    private String bllRunDy;
    
    @Size(max = 50)
    @Column(name = "DIS_TRGGR_TXT",
            length = 50)
    private String disTrggrTxt;
    
    @Column(name = "ON_BRD_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short onBrdFlg;
    
    @Column(name = "RDMPTN_BFFR_RT", 
            columnDefinition = "NUMBER(3, 0)")
    private Short rdmptnBffrRt;
    
    @Column(name = "RDMPTN_UPPR_LMT_RT", 
            columnDefinition = "NUMBER(3, 0)")
    private Short rdmptnUpprLmtRt;
	
	@Column(name = "UNIT_RCNCLTN_THRSHLD_CNT",
            columnDefinition = "NUMBER(20, 6)")
    private BigDecimal unitRcncltnThrshldCnt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt; 
    
    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @Column(name = "trst_uuid",
            insertable = false,
            updatable = false)
    private UUID trstUuid;
    
    public Scheme() {
    }
    
    public List<ClientRelationship> getClientRelationships() {
        return clientRelationships;
    }
    
    public void setClientRelationships(List<ClientRelationship> clientRelationships) {
        this.clientRelationships = clientRelationships;
        
        for (ClientRelationship clientRelationship : clientRelationships)
            if (clientRelationship.getScheme() == null)
                clientRelationship.setScheme(this);
    }
    
    public Set<Fund> getFunds() {
        return funds;
    }
    
    public void setFunds(Set<Fund> funds) {
        this.funds = funds;
        
        for (Fund fund : funds) {
            if (fund.getScheme() == null) {
                fund.setScheme(this);
            }
        }
    }
    
    public Trustee getTrustee() {
        return trustee;
    }
    
    public void setTrustee(Trustee trustee) {
        this.trustee = trustee;
    }
    
    public Long getSchmCd() {
        return schmCd;
    }
    
    public void setSchmCd(Long schmCd) {
        this.schmCd = schmCd;
    }
    
    public String getSchmNm() {
        return schmNm;
    }
    
    public void setSchmNm(String schmNm) {
        this.schmNm = schmNm;
    }
    
    public String getSchmChnsNm() {
        return schmChnsNm;
    }
    
    public void setSchmChnsNm(String schmChnsNm) {
        this.schmChnsNm = schmChnsNm;
    }
    
    public String getSchmTypId() {
        return schmTypId;
    }
    
    public void setSchmTypId(String schmTypId) {
        this.schmTypId = schmTypId;
    }
    
    public String getSchmRegNoTxt() {
        return schmRegNoTxt;
    }
    
    public void setSchmRegNoTxt(String schmRegNoTxt) {
        this.schmRegNoTxt = schmRegNoTxt;
    }
    
    public String getSchmAbbNm() {
        return schmAbbNm;
    }
    
    public void setSchmAbbNm(String schmAbbNm) {
        this.schmAbbNm = schmAbbNm;
    }
    
    public String getFnnclYrDtTxt() {
        return fnnclYrDtTxt;
    }
    
    public void setFnnclYrDtTxt(String fnnclYrDtTxt) {
        this.fnnclYrDtTxt = fnnclYrDtTxt;
    }
    
    public Short getMxSwRblCnt() {
        return mxSwRblCnt;
    }
    
    public void setMxSwRblCnt(Short mxSwRblCnt) {
        this.mxSwRblCnt = mxSwRblCnt;
    }
    
    public Short getMxChgInvMndtCnt() {
        return mxChgInvMndtCnt;
    }
    
    public void setMxChgInvMndtCnt(Short mxChgInvMndtCnt) {
        this.mxChgInvMndtCnt = mxChgInvMndtCnt;
    }
    
    public Short getMxEcaWoChrgCnt() {
        return mxEcaWoChrgCnt;
    }
    
    public void setMxEcaWoChrgCnt(Short mxEcaWoChrgCnt) {
        this.mxEcaWoChrgCnt = mxEcaWoChrgCnt;
    }
    
    public Short getAllwPrtlDisFlg() {
        return allwPrtlDisFlg;
    }
    
    public void setAllwPrtlDisFlg(Short allwPrtlDisFlg) {
        this.allwPrtlDisFlg = allwPrtlDisFlg;
    }
    
    public BigDecimal getMnVcAmt() {
        return mnVcAmt;
    }
    
    public void setMnVcAmt(BigDecimal mnVcAmt) {
        this.mnVcAmt = mnVcAmt;
    }
    
    public BigDecimal getMxVcAmt() {
        return mxVcAmt;
    }
    
    public void setMxVcAmt(BigDecimal mxVcAmt) {
        this.mxVcAmt = mxVcAmt;
    }
    
    public BigDecimal getTvcMnAmt() {
        return tvcMnAmt;
    }
    
    public void setTvcMnAmt(BigDecimal tvcMnAmt) {
        this.tvcMnAmt = tvcMnAmt;
    }
    
    public BigDecimal getSvcMnAmt() {
        return svcMnAmt;
    }
    
    public void setSvcMnAmt(BigDecimal svcMnAmt) {
        this.svcMnAmt = svcMnAmt;
    }
    
    public BigDecimal getMnSwPrcntgRt() {
        return mnSwPrcntgRt;
    }
    
    public void setMnSwPrcntgRt(BigDecimal mnSwPrcntgRt) {
        this.mnSwPrcntgRt = mnSwPrcntgRt;
    }
    
    public String getFundDlngDtNm() {
        return fundDlngDtNm;
    }
    
    public void setFundDlngDtNm(String fundDlngDtNm) {
        this.fundDlngDtNm = fundDlngDtNm;
    }
    
    public Short getPrtlWthdrwlVcFlg() {
        return prtlWthdrwlVcFlg;
    }
    
    public void setPrtlWthdrwlVcFlg(Short prtlWthdrwlVcFlg) {
        this.prtlWthdrwlVcFlg = prtlWthdrwlVcFlg;
    }
    
    public BigDecimal getPhsWthdrwlMnAmt() {
        return phsWthdrwlMnAmt;
    }
    
    public void setPhsWthdrwlMnAmt(BigDecimal phsWthdrwlMnAmt) {
        this.phsWthdrwlMnAmt = phsWthdrwlMnAmt;
    }
    
    public Short getPhsWthdrwlFreeCnt() {
        return phsWthdrwlFreeCnt;
    }
    
    public void setPhsWthdrwlFreeCnt(Short phsWthdrwlFreeCnt) {
        this.phsWthdrwlFreeCnt = phsWthdrwlFreeCnt;
    }
    
    public BigDecimal getPhsWthdrwlFee() {
        return phsWthdrwlFee;
    }
    
    public void setPhsWthdrwlFee(BigDecimal phsWthdrwlFee) {
        this.phsWthdrwlFee = phsWthdrwlFee;
    }
    
    public String getFundSwtchTypId() {
        return fundSwtchTypId;
    }
    
    public void setFundSwtchTypId(String fundSwtchTypId) {
        this.fundSwtchTypId = fundSwtchTypId;
    }
    
    public Short getSchmUndrAdtFlg() {
        return schmUndrAdtFlg;
    }
    
    public void setSchmUndrAdtFlg(Short schmUndrAdtFlg) {
        this.schmUndrAdtFlg = schmUndrAdtFlg;
    }
    
    public Date getAdtCmpltDt() {
        return adtCmpltDt;
    }
    
    public void setAdtCmpltDt(Date adtCmpltDt) {
        this.adtCmpltDt = adtCmpltDt;
    }
    
    public Short getSchmUndrInvtgtnFlg() {
        return schmUndrInvtgtnFlg;
    }
    
    public void setSchmUndrInvtgtnFlg(Short schmUndrInvtgtnFlg) {
        this.schmUndrInvtgtnFlg = schmUndrInvtgtnFlg;
    }
    
    public Short getAllwVcTferFlg() {
        return allwVcTferFlg;
    }
    
    public void setAllwVcTferFlg(Short allwVcTferFlg) {
        this.allwVcTferFlg = allwVcTferFlg;
    }
    
    public Short getAllwVcWthdrwlFlg() {
        return allwVcWthdrwlFlg;
    }
    
    public void setAllwVcWthdrwlFlg(Short allwVcWthdrwlFlg) {
        this.allwVcWthdrwlFlg = allwVcWthdrwlFlg;
    }
    
    public String getDisTrggrTxt() {
        return disTrggrTxt;
    }
    
    public void setDisTrggrTxt(String disTrggrTxt) {
        this.disTrggrTxt = disTrggrTxt;
    }
    
    public Short getOnBrdFlg() {
        return onBrdFlg;
    }
    
    public void setOnBrdFlg(Short onBrdFlg) {
        this.onBrdFlg = onBrdFlg;
    }
    
    public Date getEfctvDt() {
        return efctvDt;
    }
    
    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }
    
    public Set<SchmExcldMbrTyp> getSchmExcldMbrTyps() {
        return schmExcldMbrTyps;
    }
    
    public void setSchmExcldMbrTyps(Set<SchmExcldMbrTyp> schmExcldMbrTyps) {
        this.schmExcldMbrTyps = schmExcldMbrTyps;
    }
    
    public Short getAllwVcWthdrwlAllFlg() {
        return allwVcWthdrwlAllFlg;
    }
    
    public void setAllwVcWthdrwlAllFlg(Short allwVcWthdrwlAllFlg) {
        this.allwVcWthdrwlAllFlg = allwVcWthdrwlAllFlg;
    }
    
    public Short getAllwVcWthdrwlPrcntgFlg() {
        return allwVcWthdrwlPrcntgFlg;
    }
    
    public void setAllwVcWthdrwlPrcntgFlg(Short allwVcWthdrwlPrcntgFlg) {
        this.allwVcWthdrwlPrcntgFlg = allwVcWthdrwlPrcntgFlg;
    }
    
    public Short getAllwVcWthdrwlFundPrcntgFlg() {
        return allwVcWthdrwlFundPrcntgFlg;
    }
    
    public void setAllwVcWthdrwlFundPrcntgFlg(Short allwVcWthdrwlFundPrcntgFlg) {
        this.allwVcWthdrwlFundPrcntgFlg = allwVcWthdrwlFundPrcntgFlg;
    }
    
    public Short getVcWthdrwlPrcntgInMltpl() {
        return vcWthdrwlPrcntgInMltpl;
    }
    
    public void setVcWthdrwlPrcntgInMltpl(Short vcWthdrwlPrcntgInMltpl) {
        this.vcWthdrwlPrcntgInMltpl = vcWthdrwlPrcntgInMltpl;
    }
    
    public Short getVcWthdrwlMinPrcntg() {
        return vcWthdrwlMinPrcntg;
    }
    
    public void setVcWthdrwlMinPrcntg(Short vcWthdrwlMinPrcntg) {
        this.vcWthdrwlMinPrcntg = vcWthdrwlMinPrcntg;
    }
    
    public Short getVcWthdrwlFundPrcntgInMltpl() {
        return vcWthdrwlFundPrcntgInMltpl;
    }
    
    public void setVcWthdrwlFundPrcntgInMltpl(Short vcWthdrwlFundPrcntgInMltpl) {
        this.vcWthdrwlFundPrcntgInMltpl = vcWthdrwlFundPrcntgInMltpl;
    }
    
    public Short getVcWthdrwlMinFundPrcntg() {
        return vcWthdrwlMinFundPrcntg;
    }
    
    public void setVcWthdrwlMinFundPrcntg(Short vcWthdrwlMinFundPrcntg) {
        this.vcWthdrwlMinFundPrcntg = vcWthdrwlMinFundPrcntg;
    }
    
    public Short getVcWthdrwlMinAmt() {
        return vcWthdrwlMinAmt;
    }
    
    public void setVcWthdrwlMinAmt(Short vcWthdrwlMinAmt) {
        this.vcWthdrwlMinAmt = vcWthdrwlMinAmt;
    }
    
    public Short getVcWthdrwlAmtInMltpl() {
        return vcWthdrwlAmtInMltpl;
    }
    
    public void setVcWthdrwlAmtInMltpl(Short vcWthdrwlAmtInMltpl) {
        this.vcWthdrwlAmtInMltpl = vcWthdrwlAmtInMltpl;
    }
    
    public Short getVcWthdrwlErCnsnt() {
        return vcWthdrwlErCnsnt;
    }
    
    public void setVcWthdrwlErCnsnt(Short vcWthdrwlErCnsnt) {
        this.vcWthdrwlErCnsnt = vcWthdrwlErCnsnt;
    }
    
    public Short getVcWthdrwlTrCnsnt() {
        return vcWthdrwlTrCnsnt;
    }
    
    public void setVcWthdrwlTrCnsnt(Short vcWthdrwlTrCnsnt) {
        this.vcWthdrwlTrCnsnt = vcWthdrwlTrCnsnt;
    }
    
    public Short getUnclmReinvFlg() {
        return unclmReinvFlg;
    }
    
    public void setUnclmReinvFlg(Short unclmReinvFlg) {
        this.unclmReinvFlg = unclmReinvFlg;
    }
    
    public String getCntrbRunFrqncyTypId() {
        return cntrbRunFrqncyTypId;
    }
    
    public void setCntrbRunFrqncyTypId(String cntrbRunFrqncyTypId) {
        this.cntrbRunFrqncyTypId = cntrbRunFrqncyTypId;
    }
    
    public String getBllRunFrqncyTypId() {
        return bllRunFrqncyTypId;
    }
    
    public void setBllRunFrqncyTypId(String bllRunFrqncyTypId) {
        this.bllRunFrqncyTypId = bllRunFrqncyTypId;
    }
    
    public String getCntrbRunDy() {
        return cntrbRunDy;
    }
    
    public void setCntrbRunDy(String cntrbRunDy) {
        this.cntrbRunDy = cntrbRunDy;
    }
    
    public String getBllRunDy() {
        return bllRunDy;
    }
    
    public void setBllRunDy(String bllRunDy) {
        this.bllRunDy = bllRunDy;
    }
    
    public Date getChgDt() {
        return chgDt;
    }
    
    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }
    
    public UUID getTrstUuid() {
        return trstUuid;
    }
    
    public void setTrstUuid(UUID trstUuid) {
        this.trstUuid = trstUuid;
    }
    
    public Date getAdtCmmncmntDt() {
        return adtCmmncmntDt;
    }
    
    public void setAdtCmmncmntDt(Date adtCmmncmntDt) {
        this.adtCmmncmntDt = adtCmmncmntDt;
    }

	public Set<InstTferInfo> getInstTferInfos() {
		return instTferInfos;
	}

	public void setInstTferInfos(Set<InstTferInfo> instTferInfos) {
		this.instTferInfos = instTferInfos;
	}
    
	public Short getRdmptnBffrRt() {
		return rdmptnBffrRt;
	}

	public void setRdmptnBffrRt(Short rdmptnBffrRt) {
		this.rdmptnBffrRt = rdmptnBffrRt;
	}

	public Short getRdmptnUpprLmtRt() {
		return rdmptnUpprLmtRt;
	}

	public void setRdmptnUpprLmtRt(Short rdmptnUpprLmtRt) {
		this.rdmptnUpprLmtRt = rdmptnUpprLmtRt;
	}

	public BigDecimal getUnitRcncltnThrshldCnt() {
		return unitRcncltnThrshldCnt;
	}

	public void setUnitRcncltnThrshldCnt(BigDecimal unitRcncltnThrshldCnt) {
		this.unitRcncltnThrshldCnt = unitRcncltnThrshldCnt;
	}
}
