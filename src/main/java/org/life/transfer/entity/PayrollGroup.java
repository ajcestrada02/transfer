/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;


/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "payroll_grp")
public class PayrollGroup extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private UUID id;
	
//	@Id
//	@Column(name = "id", nullable = false, unique = true)
//	@GenericGenerator(name = "SetIdIfProvided", strategy = "org.life.entity.SetIdIfProvided")
//	@GeneratedValue(generator = "SetIdIfProvided")
//	private UUID id;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "payrollGroup")
	private PgPaymentMethod paymentMethod;

	@JsonIgnore
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private ClientRelationship clientRelationship;
	
	@Size(max = 50)
	@Column(name = "pyrll_grp_nm",
			length = 50)
	private String pyrllGrpNm;
	
	@Size(max = 20)
	@Column(name = "mbr_typ_id",
			length = 20)
	private String mbrTypId;
	
	@Size(max = 20)
	@Column(name = "cntrb_dy_optn_typ_id",
			length = 20)
	private String cntrbDyOptnTypId;
	
	@Size(max = 20)
	@Column(name = "pyrll_grp_stts_id",
			length = 20)
	private String pyrllGrpSttsId;
	
	@Size(max = 20)
	@Column(name = "frqncy_typ_id",
			length = 20)
	private String frqncyTypId;
	
	@Size(max = 20)
	@Column(name = "bll_frqncy_typ_id",
			length = 20)
	private String bllFrqncyTypId;
	
	@Column(name = "bgn_cntrb_prd_strt_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bgnCntrbPrdStrtDt;
	
	@Column(name = "bgn_bll_prd_strt_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bgnBllPrdStrtDt;
	
	@Size(max = 2)
	@Column(name = "cntrb_prd_strt_dy",
			length = 2)
	private String cntrbPrdStrtDy;
	
	@Size(max = 2)
	@Column(name = "cntrb_prd_strt_dy2",
			length = 2)
	private String cntrbPrdStrtDy2;
	
	@Size(max = 2)
	@Column(name = "bll_prd_strt_dy",
			length = 2)
	private String bllPrdStrtDy;
	
	@Size(max = 2)
	@Column(name = "bll_prd_strt_dy2",
			length = 2)
	private String bllPrdStrtDy2;

	@Size(max = 20)
	@Column(name = "prtl_pymnt_hndl_optn_flg",
			length = 20)
	private String prtlPymntHndlOptnId;
	
	@Column(name = "nxt_cntrb_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nxtCntrbDt;
	
	@Column(name = "nxt_bll_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nxtBllDt;
	
	@Column(name = "dflt_pyrll_grp_flg", 
			columnDefinition = "Number(3,0)")
	private Integer dfltPyrllGrpFlg;
	
	@Size(max = 20)
	@Column(name = "ppr_rs_optn_id",
			length = 20)
	private String pprRsOptnId;
	
	@Column(name = "cntrb_apprvl_flg", 
			columnDefinition = "Number(3,0)")
	private Integer cntrbApprvlFlg;
	
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
	
	@Size(max = 20)
	@Column(name= "PYRLL_GRP_ABB_NM",
			length = 20)
    private String pyrllGrpAbbNm;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public PgPaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PgPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ClientRelationship getClientRelationship() {
		return clientRelationship;
	}

	public void setClientRelationship(ClientRelationship clientRelationship) {
		this.clientRelationship = clientRelationship;
	}

	public String getPyrllGrpNm() {
		return pyrllGrpNm;
	}

	public void setPyrllGrpNm(String pyrllGrpNm) {
		this.pyrllGrpNm = pyrllGrpNm;
	}

	public String getMbrTypId() {
		return mbrTypId;
	}

	public void setMbrTypId(String mbrTypId) {
		this.mbrTypId = mbrTypId;
	}

	public String getCntrbDyOptnTypId() {
		return cntrbDyOptnTypId;
	}

	public void setCntrbDyOptnTypId(String cntrbDyOptnTypId) {
		this.cntrbDyOptnTypId = cntrbDyOptnTypId;
	}

	public String getPyrllGrpSttsId() {
		return pyrllGrpSttsId;
	}

	public void setPyrllGrpSttsId(String pyrllGrpSttsId) {
		this.pyrllGrpSttsId = pyrllGrpSttsId;
	}

	public String getFrqncyTypId() {
		return frqncyTypId;
	}

	public void setFrqncyTypId(String frqncyTypId) {
		this.frqncyTypId = frqncyTypId;
	}

	public String getBllFrqncyTypId() {
		return bllFrqncyTypId;
	}

	public void setBllFrqncyTypId(String bllFrqncyTypId) {
		this.bllFrqncyTypId = bllFrqncyTypId;
	}

	public Date getBgnCntrbPrdStrtDt() {
		return bgnCntrbPrdStrtDt;
	}

	public void setBgnCntrbPrdStrtDt(Date bgnCntrbPrdStrtDt) {
		this.bgnCntrbPrdStrtDt = bgnCntrbPrdStrtDt;
	}

	public Date getBgnBllPrdStrtDt() {
		return bgnBllPrdStrtDt;
	}

	public void setBgnBllPrdStrtDt(Date bgnBllPrdStrtDt) {
		this.bgnBllPrdStrtDt = bgnBllPrdStrtDt;
	}

	public String getCntrbPrdStrtDy() {
		return cntrbPrdStrtDy;
	}

	public void setCntrbPrdStrtDy(String cntrbPrdStrtDy) {
		this.cntrbPrdStrtDy = cntrbPrdStrtDy;
	}

	public String getCntrbPrdStrtDy2() {
		return cntrbPrdStrtDy2;
	}

	public void setCntrbPrdStrtDy2(String cntrbPrdStrtDy2) {
		this.cntrbPrdStrtDy2 = cntrbPrdStrtDy2;
	}

	public String getBllPrdStrtDy() {
		return bllPrdStrtDy;
	}

	public void setBllPrdStrtDy(String bllPrdStrtDy) {
		this.bllPrdStrtDy = bllPrdStrtDy;
	}

	public String getBllPrdStrtDy2() {
		return bllPrdStrtDy2;
	}

	public void setBllPrdStrtDy2(String bllPrdStrtDy2) {
		this.bllPrdStrtDy2 = bllPrdStrtDy2;
	}

	public String getPrtlPymntHndlOptnId() {
		return prtlPymntHndlOptnId;
	}

	public void setPrtlPymntHndlOptnId(String prtlPymntHndlOptnId) {
		this.prtlPymntHndlOptnId = prtlPymntHndlOptnId;
	}

	public Date getNxtCntrbDt() {
		return nxtCntrbDt;
	}

	public void setNxtCntrbDt(Date nxtCntrbDt) {
		this.nxtCntrbDt = nxtCntrbDt;
	}

	public Date getNxtBllDt() {
		return nxtBllDt;
	}

	public void setNxtBllDt(Date nxtBllDt) {
		this.nxtBllDt = nxtBllDt;
	}

	public Integer getDfltPyrllGrpFlg() {
		return dfltPyrllGrpFlg;
	}

	public void setDfltPyrllGrpFlg(Integer dfltPyrllGrpFlg) {
		this.dfltPyrllGrpFlg = dfltPyrllGrpFlg;
	}

	public String getPprRsOptnId() {
		return pprRsOptnId;
	}

	public void setPprRsOptnId(String pprRsOptnId) {
		this.pprRsOptnId = pprRsOptnId;
	}

	public Integer getCntrbApprvlFlg() {
		return cntrbApprvlFlg;
	}

	public void setCntrbApprvlFlg(Integer cntrbApprvlFlg) {
		this.cntrbApprvlFlg = cntrbApprvlFlg;
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

	public String getPyrllGrpAbbNm() {
		return pyrllGrpAbbNm;
	}

	public void setPyrllGrpAbbNm(String pyrllGrpAbbNm) {
		this.pyrllGrpAbbNm = pyrllGrpAbbNm;
	}
	
	@PrePersist
	public void prePersist() {
		if (this.id == null && this.clientRelationship != null) {
            this.id = this.clientRelationship.getId();
       }
	}

	
}

