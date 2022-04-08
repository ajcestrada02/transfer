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
@Table(name = "CRS_ENTTY_TYP")
public class CrsEnttyTyp extends BaseEntityUuid{
	
	@NotNull
	@JsonIgnore
    @JoinColumn(name="crs_uuid",
				referencedColumnName="id",
				nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CrsHeader crsHeader;
	
	@Size(max = 20)
	@Column(name = "ENTTY_TYP",
			length = 20)
	private String enttyTyp;
	
	@Size(max = 20)
	@Column(name = "ENTTY_SUB_TYP",
			length = 20)
	private String enttySubTyp;
	
	@Size(max = 100)
	@Column(name = "INFRMTN_1",
			length = 100)
	private String infrmtn1;
	
	@Size(max = 100)
	@Column(name = "INFRMTN_2",
			length = 100)
	private String infrmtn2;
	
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
	
	public CrsEnttyTyp() {
	}

	public CrsHeader getCrsHeader() {
		return crsHeader;
	}

	public void setCrsHeader(CrsHeader crsHeader) {
		this.crsHeader = crsHeader;
	}

	public String getEnttyTyp() {
		return enttyTyp;
	}

	public void setEnttyTyp(String enttyTyp) {
		this.enttyTyp = enttyTyp;
	}

	public String getEnttySubTyp() {
		return enttySubTyp;
	}

	public void setEnttySubTyp(String enttySubTyp) {
		this.enttySubTyp = enttySubTyp;
	}

	public String getInfrmtn1() {
		return infrmtn1;
	}

	public void setInfrmtn1(String infrmtn1) {
		this.infrmtn1 = infrmtn1;
	}

	public String getInfrmtn2() {
		return infrmtn2;
	}

	public void setInfrmtn2(String infrmtn2) {
		this.infrmtn2 = infrmtn2;
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
