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
@Table(name = "CRS_ENTTY_ACCT_HLDR")
@DynamicInsert
@DynamicUpdate
public class CrsEnttyAcctHldr extends BaseEntityUuid{
	
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
	
	@Size(max = 200)
	@Column(name = "ACCNT_HLDR_NM", 
			length = 200)
	private String acctHldrNm;
	
	@Column(name = "crs_uuid",
			insertable = false, 
			updatable = false)
	private UUID crsUuid;
	
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
	public String getAcctHldrNm() {
		return acctHldrNm;
	}
	public void setAcctHldrNm(String acctHldrNm) {
		this.acctHldrNm = acctHldrNm;
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
