package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "EE_SCHM_CHC")
public class EeSchemeChoice extends BaseEntityUuid {

	
	@NotNull
	@JsonIgnore
	@JoinColumn(name = "IND_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, 
			   optional = false)
	private Individual individual;
	
	@JoinColumn(name = "pyrll_grp_uuid",
				referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private PayrollGroup payrollGroup;
	
	@Column(name = "MBR_GRD_UUID")
	private UUID mbrGrdUuid;
	
	@Column(name = "JN_VC_FLG")
	private Short jnVcFlg;
	
	@Column(name = "CHSN_BY_EE_FLG", 
			columnDefinition = "Number(3,0)")
	private Short chsnByEeFlg;
	
	@Column(name = "CHG_DT",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date chgDt;
	
	@Column(name = "EFCTV_DT",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date efctvDt;
	
	@Column(name = "join_vc_flg", 
			columnDefinition = "Number(3,0)")
	private Short joinVcFlg;

	@NotNull
	@JoinColumn(name = "CMPNY_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, 
			   optional = false)
	private Company company;
	
	@JoinColumn(name = "ER_GRD_UUID",
				referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private EmployerGrade employerGrade;
	
    @Column(name = "cmpny_uuid",
			insertable = false, 
			updatable = false)
    private UUID cmpnyUiid;
    
    @Column(name = "ind_uuid",
			insertable = false, 
			updatable = false)
    private UUID indUuid;
    
    @Column(name = "pyrll_grp_uuid",
			insertable = false, 
			updatable = false)
    private UUID pyrllGrpUuid;
    
    @Column(name = "er_grd_uuid",
			insertable = false, 
			updatable = false)
    private UUID erGrdUuid;
    
	
	public PayrollGroup getPayrollGroup() {
		return this.payrollGroup;
	}

	public void setPayrollGroup(PayrollGroup payrollGroup) {
		this.payrollGroup = payrollGroup;
	}


	public UUID getMbrGrdUuid() {
		return mbrGrdUuid;
	}

	public void setMbrGrdUuid(UUID mbrGrdUuid) {
		this.mbrGrdUuid = mbrGrdUuid;
	}


	public EeSchemeChoice(){
	}
	

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public Date getChgDt() {
		return chgDt;
	}

	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}

	public Date getEfctvDt() {
		return efctvDt;
	}

	public void setEfctvDt(Date efctvDt) {
		this.efctvDt = efctvDt;
	}


	public Short getJnVcFlg() {
		return jnVcFlg;
	}


	public void setJnVcFlg(Short jnVcFlg) {
		this.jnVcFlg = jnVcFlg;
	}


	public Short getChsnByEeFlg() {
		return chsnByEeFlg;
	}


	public void setChsnByEeFlg(Short chsnByEeFlg) {
		this.chsnByEeFlg = chsnByEeFlg;
	}
	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
    

	public EmployerGrade getEmployerGrade() {
		return this.employerGrade;
	}

	public void setEmployerGrade(EmployerGrade employerGrade) {
		this.employerGrade = employerGrade;
	}
	
	public UUID getCmpnyUiid() {
		return cmpnyUiid;
	}
	
	public void setCmpnyUiid(UUID cmpnyUiid) {
		this.cmpnyUiid = cmpnyUiid;
	}
	
	public UUID getIndUuid() {
		return indUuid;
	}
	
	public void setIndUuid(UUID indUuid) {
		this.indUuid = indUuid;
	}
	
	public UUID getPyrllGrpUuid() {
		return pyrllGrpUuid;
	}
	
	public void setPyrllGrpUuid(UUID pyrllGrpUuid) {
		this.pyrllGrpUuid = pyrllGrpUuid;
	}
	
	public Short getJoinVcFlg() {
		return joinVcFlg;
	}
	
	public void setJoinVcFlg(Short joinVcFlg) {
		this.joinVcFlg = joinVcFlg;
	}
	
	public UUID getErGrdUuid() {
		return erGrdUuid;
	}
	
	public void setErGrdUuid(UUID erGrdUuid) {
		this.erGrdUuid = erGrdUuid;
	}
}

