package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "INV_MNDT")
public class InvMndt extends BaseEntityUuid {
	
	@NotNull
	@JsonIgnore
	@JoinColumn(name = "ENTTY_UUID",
				referencedColumnName = "ID",
				nullable = false)
	@ManyToOne(optional = false,
			   fetch = FetchType.LAZY)
	private ClientRelationship clientRelationship;
	
	@NotNull
	@JsonIgnore
	@JoinColumn(name = "FUND_UUID",
				referencedColumnName = "ID",
				nullable = false)
	@ManyToOne(optional = false,
			   fetch = FetchType.LAZY)
	private Fund fund;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "cntrb_typ_id",
			nullable = false,
			length = 20)
	private String cntrbTypId;
	
	@NotNull
	@Column(name = "prcntg_rt",
			nullable = false, 
			columnDefinition = "NUMBER(9, 2)")
	private Short prcntgRt;
	
	@NotNull
	@Column(name = "is_sys_crt_flg",
			nullable = false, 
			columnDefinition = "NUMBER(3, 0)")
	private Short isSysCrtFlg;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFCTV_DT",
			nullable = false)
	private Date efctvDt;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHG_DT",
			nullable = false)
	private Date chgDt;
	
	@Column(name = "ENTTY_UUID",
			insertable = false, 
			updatable = false)
	private UUID enttyUuid;
	
	@Column(name = "fund_uuid",
			insertable = false, 
			updatable = false)
	private UUID fundUuid;
	
	public InvMndt() {
	}
	
	public ClientRelationship getClientRelationship() {
		return clientRelationship;
	}
	public void setClientRelationship(ClientRelationship clientRelationship) {
		this.clientRelationship = clientRelationship;
	}
	public Fund getFund() {
		return fund;
	}
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	public String getCntrbTypId() {
		return cntrbTypId;
	}
	public void setCntrbTypId(String cntrbTypId) {
		this.cntrbTypId = cntrbTypId;
	}
	public Short getPrcntgRt() {
		return prcntgRt;
	}
	public void setPrcntgRt(Short prcntgRt) {
		this.prcntgRt = prcntgRt;
	}
	public Short getIsSysCrtFlg() {
		return isSysCrtFlg;
	}
	public void setIsSysCrtFlg(Short isSysCrtFlg) {
		this.isSysCrtFlg = isSysCrtFlg;
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
	
	public UUID getEnttyUuid() {
		return enttyUuid;
	}
	
	public void setEnttyUuid(UUID enttyUuid) {
		this.enttyUuid = enttyUuid;
	}
	
	public UUID getFundUuid() {
		return fundUuid;
	}
	
	public void setFundUuid(UUID fundUuid) {
		this.fundUuid = fundUuid;
	}
}
