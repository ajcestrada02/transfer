/**
 * 
 */
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
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jan Louie
 *
 */
@Entity
@Table(name = "CRS_JRSDCTN")
@DynamicInsert
@DynamicUpdate
public class CrsJrsdctn extends BaseEntityUuid{
	
	@NotNull
	@JsonIgnore
    @JoinColumn(name="crs_uuid",
				referencedColumnName="id",
				nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CrsHeader crsHeader;
	
	@Size(max = 3)
	@Column(name = "JRSDCTN_RSDNC", 
			length = 3)
	private String jrsdctnRsdnc;
	
	@Size(max = 50)
	@Column(name = "TIN",
			length = 50)
	private String tin;
	
	@Size(max = 10)
	@Column(name = "RSN_NO_TIN",
			length = 10)
	private String rsNoTin;
	
	@Size(max = 100)
	@Column(name = "EXPLN_NO_TIN_RSN_b",
			length = 100)
	private String explnNoTinRsnB;
	
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
    
    @Column(name = "crs_uuid",
			insertable = false, 
			updatable = false)
	private UUID crsUuid;
	
	public CrsJrsdctn() {
	}

	public CrsHeader getCrsHeader() {
		return crsHeader;
	}

	public void setCrsHeader(CrsHeader crsHeader) {
		this.crsHeader = crsHeader;
	}

	public String getJrsdctnRsdnc() {
		return jrsdctnRsdnc;
	}

	public void setJrsdctnRsdnc(String jrsdctnRsdnc) {
		this.jrsdctnRsdnc = jrsdctnRsdnc;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getRsNoTin() {
		return rsNoTin;
	}

	public void setRsNoTin(String rsNoTin) {
		this.rsNoTin = rsNoTin;
	}

	public String getExplnNoTinRsnB() {
		return explnNoTinRsnB;
	}

	public void setExplnNoTinRsnB(String explnNoTinRsnB) {
		this.explnNoTinRsnB = explnNoTinRsnB;
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
	
	public UUID getCrsUuid() {
		return crsUuid;
	}
	
	public void setCrsUuid(UUID crsUuid) {
		this.crsUuid = crsUuid;
	}
}
