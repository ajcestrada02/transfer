/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "EMPLOYER")
public class Employer extends BaseEntity {


    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private Set<ClientRelationship> clientRelationships;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private Set<EmployerGrade> employerGrades;
    
    @Column(name = "er_cd", 
            columnDefinition = "NUMBER(15, 0)")
    private Long erCd;
    
    @Size(max = 20)
    @Column(name = "stts_typ_id",
            length = 20)
    private String sttsTypId;
    
    @Column(name = "cmmncmnt_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cmmncmntDt;
    
    @Column(name = "sep_cs_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sepCsDt;
    
    @Column(name = "term_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDt;
    
    @Size(max = 100)
    @Column(name = "pymnt_mthd_txt",
            length = 100)
    private String pymntMthdTxt;
    
    @Column(name = "optn_out_ntfctn_flg", 
            columnDefinition = "NUMBER(3, 0)")
    private Short optnOutNtfctnFlg;
    
    @Size(max = 20)
    @Column(name = "qb_grp_id", 
            length = 20)
    private UUID qbGrpUuid;
    
    @Column(name = "cpy_frm_er_cd", 
            columnDefinition = "NUMBER(15, 0)")
    private Long cpyFrmErCd;
    
    @Size(max = 100)
    @Column(name = "trst_er_cd",
            length = 100)
    private String trstErCd;
    
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
    
    @Size(max = 50)
    @Column(name = "MPFA_REF_NO_TXT",
            length = 50)
    private String mpfaRefNoTxt;
    
    @Column(name = "MBR_CNT", 
            columnDefinition = "NUMBER(7, 0)")
    private String mbrCnt;
    
    @Size(max = 50)
    @Column(name = "src_of_fund",
            length = 50)
    private String srcOfFund;
    
    @Size(max = 20)
    @Column(name = "FUND_CLSS_TYP_ID",
            length = 20)
    private String fundClssTypId;
    
    @Size(max = 20)
    @Column(name = "UNVST_BNFT_ID",
            length = 20)
    private String unvstBnftId;
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<EmployerGrade> getEmployerGrades() {
		return employerGrades;
	}
    
    public void setEmployerGrades(Set<EmployerGrade> employerGrades) {
        this.employerGrades = employerGrades;
    }
    
    public Set<ClientRelationship> getClientRelationships() {
        return clientRelationships;
    }
    
    public void setClientRelationships(Set<ClientRelationship> clientRelationships) {
        this.clientRelationships = clientRelationships;
    }
    
    public Long getErCd() {
        return erCd;
    }

    public void setErCd(Long erCd) {
        this.erCd = erCd;
    }

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }

    public Date getCmmncmntDt() {
        return cmmncmntDt;
    }

    public void setCmmncmntDt(Date cmmncmntDt) {
        this.cmmncmntDt = cmmncmntDt;
    }

    public Date getSepCsDt() {
        return sepCsDt;
    }

    public void setSepCsDt(Date sepCsDt) {
        this.sepCsDt = sepCsDt;
    }

    public Date getTermDt() {
        return termDt;
    }

    public void setTermDt(Date termDt) {
        this.termDt = termDt;
    }

    public String getPymntMthdTxt() {
        return pymntMthdTxt;
    }

    public void setPymntMthdTxt(String pymntMthdTxt) {
        this.pymntMthdTxt = pymntMthdTxt;
    }

    public Short getOptnOutNtfctnFlg() {
        return optnOutNtfctnFlg;
    }

    public void setOptnOutNtfctnFlg(Short optnOutNtfctnFlg) {
        this.optnOutNtfctnFlg = optnOutNtfctnFlg;
    }
    
    public Long getCpyFrmErCd() {
        return cpyFrmErCd;
    }

    public void setCpyFrmErCd(Long cpyFrmErCd) {
        this.cpyFrmErCd = cpyFrmErCd;
    }

    public String getTrstErCd() {
        return trstErCd;
    }

    public void setTrstErCd(String trstErCd) {
        this.trstErCd = trstErCd;
    }

    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }

    public String getMpfaRefNoTxt() {
        return mpfaRefNoTxt;
    }

    public void setMpfaRefNoTxt(String mpfaRefNoTxt) {
        this.mpfaRefNoTxt = mpfaRefNoTxt;
    }

    public String getMbrCnt() {
        return mbrCnt;
    }

    public void setMbrCnt(String mbrCnt) {
        this.mbrCnt = mbrCnt;
    }

    public Date getChgDt() {
        return chgDt;
    }

    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }

    public String getSrcOfFund() {
        return srcOfFund;
    }

    public void setSrcOfFund(String srcOfFund) {
        this.srcOfFund = srcOfFund;
    }

	public UUID getQbGrpUuid() {
		return qbGrpUuid;
	}

	public void setQbGrpUuid(UUID qbGrpId) {
		this.qbGrpUuid = qbGrpId;
	}

	public String getFundClssTypId() {
		return fundClssTypId;
	}

	public void setFundClssTypId(String fundClssTypId) {
		this.fundClssTypId = fundClssTypId;
	}

	public String getUnvstBnftId() {
		return unvstBnftId;
	}

	public void setUnvstBnftId(String unvstBnftId) {
		this.unvstBnftId = unvstBnftId;
	}
}
