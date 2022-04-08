package org.life.transfer.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 30 Jun 2021
 */
@Entity
@Table(name = "cntrb_rl_ctgry_rltnshp")
public class CntrbRlCtgryRltnshp extends BaseEntityUuid{
	private static final long serialVersionUID = -5426409225048107830L;
	
	@NotNull
	@JsonIgnore
	@JoinColumn(name = "CNTRB_RL_HDR_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, 
			   optional = false)
	private CntrbRlHdr cntrbRlHdr;
	
	@NotNull
	@JsonIgnore
	@JoinColumn(name = "CTGRY_TYP_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, 
			   optional = false)
	private CategoryTyp categoryTyp;
	
	@Column(name = "cntrb_rl_hdr_uuid",
            insertable = false,
            updatable = false)
	private UUID cntrbRlHdrUuid;
	
	@Column(name = "ctgry_typ_uuid",
            insertable = false,
            updatable = false)
	private UUID ctgryTypUuid;

	public CntrbRlCtgryRltnshp() {
	}

	public CntrbRlHdr getCntrbRlHdr() {
		return cntrbRlHdr;
	}

	public void setCntrbRlHdr(CntrbRlHdr cntrbRlHdr) {
		this.cntrbRlHdr = cntrbRlHdr;
	}

	public CategoryTyp getCategoryTyp() {
		return categoryTyp;
	}

	public void setCategoryTyp(CategoryTyp categoryTyp) {
		this.categoryTyp = categoryTyp;
	}
	
	public UUID getCntrbRlHdrUuid() {
		return cntrbRlHdrUuid;
	}
	
	public void setCntrbRlHdrUuid(UUID cntrbRlHdrUuid) {
		this.cntrbRlHdrUuid = cntrbRlHdrUuid;
	}
	
	public UUID getCtgryTypUuid() {
		return ctgryTypUuid;
	}
	
	public void setCtgryTypUuid(UUID ctgryTypUuid) {
		this.ctgryTypUuid = ctgryTypUuid;
	}
}
