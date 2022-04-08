package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

@Entity
@Table(name = "er_grd_cntrb_typ_rltnshp")
public class ErGrdCntbnTypRelationship extends BaseEntityUuid {
	
	@Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;
	
	@Column(name = "ER_GRD_UUID")
	private UUID erGradeUuid;
	
	@Size(max = 20)
	@Column(name = "CNTRB_TYP_ID", 
			length = 20)
	private String cntrbTypId;
	
	@Size(max = 20)
	@Column(name = "VC_INCM_DFN_ID",
			length = 20)
	private String vcIncmDfnId;
	
	@Size(max = 20)
	@Column(name = "VC_SRVC_DFN_ID",
			length = 20)
	private String vcSrvcDfnId;
	
	@Size(max = 20)
	@Column(name = "VC_JOIN_DT_ID",
			length = 20)
	private String vcJoinDtId;
	
	@Column(name = "X_VC_JOIN_DT_NMBR", 
			columnDefinition = "Number(4)")
	private Long xVcJoinDtNmbr;
	
	@Column(name = "VC_JOIN_SPCFY_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date vcJoinSpcfyDt;
	
	@Column(name = "CNTRB_RL_HDR_UUID")
	private UUID cntrbRlHdrUuid;
	
	@Column(name = "VSTNG_RL_HDR_UUID")
	private UUID vstngRlHdrUuid;
	
	@NotNull
	@Column(name = "EFCTV_DT",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date effctvDt;
	
	@NotNull
	@Column(name = "CHG_DT",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date chgDt;
	
	@Column(name = "sspnsn_flg", 
			columnDefinition = "NUMBER(3, 0)")
	private Long sspnsnFlg;
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getErGradeUuid() {
		return erGradeUuid;
	}

	public void setErGradeUuid(UUID erGradeUuid) {
		this.erGradeUuid = erGradeUuid;
	}

	public String getCntrbTypId() {
		return cntrbTypId;
	}

	public void setCntrbTypId(String cntrbTypId) {
		this.cntrbTypId = cntrbTypId;
	}

	public String getVcIncmDfnId() {
		return vcIncmDfnId;
	}

	public void setVcIncmDfnId(String vcIncmDfnId) {
		this.vcIncmDfnId = vcIncmDfnId;
	}

	public String getVcSrvcDfnId() {
		return vcSrvcDfnId;
	}

	public void setVcSrvcDfnId(String vcSrvcDfnId) {
		this.vcSrvcDfnId = vcSrvcDfnId;
	}

	public String getVcJoinDtId() {
		return vcJoinDtId;
	}

	public void setVcJoinDtId(String vcJoinDtId) {
		this.vcJoinDtId = vcJoinDtId;
	}

	public Long getxVcJoinDtNmbr() {
		return xVcJoinDtNmbr;
	}

	public void setxVcJoinDtNmbr(Long xVcJoinDtNmbr) {
		this.xVcJoinDtNmbr = xVcJoinDtNmbr;
	}

	public Date getVcJoinSpcfyDt() {
		return vcJoinSpcfyDt;
	}

	public void setVcJoinSpcfyDt(Date vcJoinSpcfyDt) {
		this.vcJoinSpcfyDt = vcJoinSpcfyDt;
	}

	public UUID getCntrbRlHdrUuid() {
		return cntrbRlHdrUuid;
	}

	public void setCntrbRlHdrUuid(UUID cntrbRlHdrUuid) {
		this.cntrbRlHdrUuid = cntrbRlHdrUuid;
	}

	public UUID getVstngRlHdrUuid() {
		return vstngRlHdrUuid;
	}

	public void setVstngRlHdrUuid(UUID vstngRlHdrUuid) {
		this.vstngRlHdrUuid = vstngRlHdrUuid;
	}

	public Date getEffctvDt() {
		return effctvDt;
	}

	public void setEffctvDt(Date effctvDt) {
		this.effctvDt = effctvDt;
	}

	public Date getChgDt() {
		return chgDt;
	}

	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}
	
	public Long getSspnsnFlg() {
		return sspnsnFlg;
	}
	
	public void setSspnsnFlg(Long sspnsnFlg) {
		this.sspnsnFlg = sspnsnFlg;
	}
}