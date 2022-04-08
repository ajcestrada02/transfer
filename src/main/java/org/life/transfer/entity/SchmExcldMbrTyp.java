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
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Aldrine John Carlos - 81258782
 *
 */
@Entity
@Table(name = "SCHM_EXCLD_MBR_TYP")
public class SchmExcldMbrTyp extends BaseEntityUuid {
	
    @JoinColumn(name = "SCHM_UUID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
	private Scheme scheme;

	@Column(name = "SCHM_UUID",
			insertable = false,
			updatable = false)
	private UUID schmUuid;
	
	@Size(max = 20)
	@Column(name = "EXCLD_MBR_TYP_ID", 
			length = 20)
	private String excldMbrTypId;

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

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public UUID getSchmUuid() {
		return schmUuid;
	}

	public void setSchmUuid(UUID schmUuid) {
		this.schmUuid = schmUuid;
	}

	public String getExcldMbrTypId() {
		return excldMbrTypId;
	}

	public void setExcldMbrTypId(String excldMbrTypId) {
		this.excldMbrTypId = excldMbrTypId;
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

}
