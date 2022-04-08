package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 11 Jun 2021
 */

@Entity
@Table(name = "er_cntrb_typ")
public class ErContributionTyp extends BaseEntityUuid {


    @NotNull
    @JsonIgnore
	@JoinColumn(name = "er_uuid",
				referencedColumnName = "ID",
				nullable = false)
    @ManyToOne(optional = false,
			   fetch = FetchType.LAZY)
    private ClientRelationship clientRelationship;
    
    @NotNull
    @JoinColumn(name = "cntrb_typ_id",
				referencedColumnName = "cntrb_typ_id",
				nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, 
			   optional = false)
    private ContributionTyp contributionTyp;
    
    @NotNull
	@Column(name = "efctv_dt",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date efctvDt;
	
	@Column(name = "term_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date termDt;
	
	@NotNull
	@Column(name = "chg_dt",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date chgDt;
	
	@Column(name = "er_uuid",
			insertable = false, 
			updatable = false)
	private UUID erUuid;
	
	@Column(name = "cntrb_typ_id",
			length = 20, 
			insertable = false, 
			updatable = false)
	private String cntrbTypId;

	public ErContributionTyp() {
		super();
	}

	public ClientRelationship getClientRelationship() {
		return clientRelationship;
	}
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public void setClientRelationship(ClientRelationship oldClientRelationship) {
		this.clientRelationship = oldClientRelationship;
	}

	public ContributionTyp getContributionTyp() {
		return contributionTyp;
	}

	public void setContributionTyp(ContributionTyp contributionTyps) {
		this.contributionTyp = contributionTyps;
	}

	public Date getEfctvDt() {
		return efctvDt;
	}

	public void setEfctvDt(Date efctvDt) {
		this.efctvDt = efctvDt;
	}

	public Date getTermDt() {
		return termDt;
	}

	public void setTermDt(Date termDt) {
		this.termDt = termDt;
	}

	public Date getChgDt() {
		return chgDt;
	}

	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}
	
	public UUID getErUuid() {
		return erUuid;
	}
	
	public void setErUuid(UUID erUuid) {
		this.erUuid = erUuid;
	}
	
	public String getCntrbTypId() {
		return cntrbTypId;
	}
	
	public void setCntrbTypId(String cntrbTypId) {
		this.cntrbTypId = cntrbTypId;
	}
}
