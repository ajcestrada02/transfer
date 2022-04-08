package org.life.transfer.entity;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 10 Jun 2021
 */

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.life.transfer.entity.BaseEntity;

 
@Entity
@Table(name = "pg_pymnt_mthd")
public class PgPaymentMethod extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private UUID id;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PYRLL_GRP_UUID",
				referencedColumnName = "ID")
	private PayrollGroup payrollGroup;

	@Column(name = "PYMNT_MTHD_TYP_ID", 
			length = 20)
	@Size(max = 20)
	private String paymentMethodTypeId;

	@Column(name = "DDA_LMT_CNT", 
			columnDefinition = "NUMBER(15, 2)")
	private Double ddaLimitCount;

	@Column(name = "DDA_EXPRY_DT")
	private Date ddaExpiryDate;

	@Column(name = "FPS_TEL_NO", 
			columnDefinition = "NUMBER(15, 2)")
	private Double fpsTelNo;
	
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

	public PgPaymentMethod() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public PayrollGroup getPayrollGroup() {
		return payrollGroup;
	}

	public void setPayrollGroup(PayrollGroup payrollGroup) {
		this.payrollGroup = payrollGroup;
	}

	public String getPaymentMethodTypeId() {
		return paymentMethodTypeId;
	}

	public void setPaymentMethodTypeId(String paymentMethodTypeId) {
		this.paymentMethodTypeId = paymentMethodTypeId;
	}

	public Double getDdaLimitCount() {
		return ddaLimitCount;
	}

	public void setDdaLimitCount(Double ddaLimitCount) {
		this.ddaLimitCount = ddaLimitCount;
	}

	public Date getDdaExpiryDate() {
		return ddaExpiryDate;
	}

	public void setDdaExpiryDate(Date ddaExpiryDate) {
		this.ddaExpiryDate = ddaExpiryDate;
	}

	public Double getFpsTelNo() {
		return fpsTelNo;
	}

	public void setFpsTelNo(Double fpsTelNo) {
		this.fpsTelNo = fpsTelNo;
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
	
	@PrePersist
	public void prePersist() {
		if (this.id == null && this.payrollGroup != null) {
            this.id = this.payrollGroup.getId();
       }
	}

}
