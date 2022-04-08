package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 11 Jun 2021
 */

@Entity
@Table(name = "cntrb_typ")
public class ContributionTyp extends BaseEntityUuid{

	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contributionTyp", fetch = FetchType.LAZY)
	private Set<Transaction> transactions;
	
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributionTyp")
    private Set<ErContributionTyp> erContributionTyps;
    
    @NotNull
    @Column(name = "cntrb_typ_id",
			nullable = false,
			unique = true, 
			length = 20)
    @Size(max = 20)
    @NaturalId
    private String cntrbTypId;
    
    @Column(name = "cntrb_typ_nm", 
			length = 50)
    @Size(max = 50)
    private String cntrbTypNm;
    
    @Column(name = "cntrb_grp_nm", 
			length = 50)
    @Size(max = 50)
    private String cntrbGrpNm;
    
    @Column(name = "cntrb_othr_grp_nm", 
			length = 50)
    @Size(max = 50)
    private String cntrbOthrGrpNm;
	
    @Column(name = "cntrb_abb_nm", 
			length = 10)
    @Size(max = 10)
    private String cntrbAbbNm;
     
    @Column(name = "prcss_seq_nmbr", 
			columnDefinition = "Number(3, 0)")
    private Short prcssSeqNmbr;
	
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

	public ContributionTyp() {
		super();
	}
	
	public Set<ErContributionTyp> getErContributionTyps() {
		return erContributionTyps;
	}

	public void setErContributionTyps(Set<ErContributionTyp> erContributionTyps) {
		this.erContributionTyps = erContributionTyps;
	}

	public String getCntrbTypId() {
		return cntrbTypId;
	}

	public void setCntrbTypId(String cntrbTypId) {
		this.cntrbTypId = cntrbTypId;
	}

	public String getCntrbTypNm() {
		return cntrbTypNm;
	}

	public void setCntrbTypNm(String cntrbTypNm) {
		this.cntrbTypNm = cntrbTypNm;
	}

	public String getCntrbGrpNm() {
		return cntrbGrpNm;
	}

	public void setCntrbGrpNm(String cntrbGrpNm) {
		this.cntrbGrpNm = cntrbGrpNm;
	}

	public String getCntrbOthrGrpNm() {
		return cntrbOthrGrpNm;
	}

	public void setCntrbOthrGrpNm(String cntrbOthrGrpNm) {
		this.cntrbOthrGrpNm = cntrbOthrGrpNm;
	}

	public String getCntrbAbbNm() {
		return cntrbAbbNm;
	}

	public void setCntrbAbbNm(String cntrbAbbNm) {
		this.cntrbAbbNm = cntrbAbbNm;
	}

	public Short getPrcssSeqNmbr() {
		return prcssSeqNmbr;
	}

	public void setPrcssSeqNmbr(Short prcssSeqNmbr) {
		this.prcssSeqNmbr = prcssSeqNmbr;
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

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
