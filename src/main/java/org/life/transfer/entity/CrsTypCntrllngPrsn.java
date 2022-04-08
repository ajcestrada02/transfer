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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jan Louie
 *
 */
@Entity
@Table(name = "CRS_TYP_CNTRLLNG_PRSN")
public class CrsTypCntrllngPrsn extends BaseEntityUuid{
	
	@NotNull
	@JsonIgnore
    @JoinColumn(name="crs_uuid",
				referencedColumnName="id",
				nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CrsHeader crsHeader;
	
	@Size(max = 3)
	@Column(name = "ENTTY_SEQ_NMBR",
			length = 3)
	private String enttySeqNmbr;
	
	@Size(max = 20)
	@Column(name = "TYP_OF_ENTTY",
			length = 20)
	private String typOfEntty;
	
	@Size(max = 20)
	@Column(name = "TYP_OF_CNTRLLNG_PRSN",
			length = 20)
	private String typOfCtrllngPrsn;
	
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
	
	public CrsTypCntrllngPrsn() {
	}

	public CrsHeader getCrsHeader() {
		return crsHeader;
	}

	public void setCrsHeader(CrsHeader crsHeader) {
		this.crsHeader = crsHeader;
	}

	public String getEnttySeqNmbr() {
		return enttySeqNmbr;
	}

	public void setEnttySeqNmbr(String enttySeqNmbr) {
		this.enttySeqNmbr = enttySeqNmbr;
	}

	public String getTypOfEntty() {
		return typOfEntty;
	}

	public void setTypOfEntty(String typOfEntty) {
		this.typOfEntty = typOfEntty;
	}

	public String getTypOfCtrllngPrsn() {
		return typOfCtrllngPrsn;
	}

	public void setTypOfCtrllngPrsn(String typOfCtrllngPrsn) {
		this.typOfCtrllngPrsn = typOfCtrllngPrsn;
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
