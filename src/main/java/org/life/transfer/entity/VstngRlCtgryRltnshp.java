package org.life.transfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;


/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 1 Jul 2021
 */
@Entity
@Table(name = "VSTNG_RL_CTGRY_RLTNSHP")
public class VstngRlCtgryRltnshp extends BaseEntityUuid {
	private static final long serialVersionUID = 2114389172869236484L;

	@NotNull
	@JsonIgnore
	@JoinColumn(name = "VSTNG_RL_HDR_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY,
			   optional = false)
	private VstngRlHdr vstngRlHdr;
	
	@NotNull
	@JsonIgnore
	@JoinColumn(name = "CTGRY_TYP_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY,
			   optional = false)
	private CategoryTyp categoryTyp;
	
	@Column(name = "VSTNG_RL_HDR_UUID",
			insertable = false,
			updatable = false)
	private UUID vstngRlHdrUuid;
	
	@Column(name = "ctgry_typ_uuid",
			insertable = false, 
			updatable = false)
	private UUID ctgryTypUuid;

	public VstngRlCtgryRltnshp() {
	}

	public VstngRlHdr getVstngRlHdr() {
		return vstngRlHdr;
	}

	public void setVstngRlHdr(VstngRlHdr vstngRlHdr) {
		this.vstngRlHdr = vstngRlHdr;
	}

	public CategoryTyp getCategoryTyp() {
		return categoryTyp;
	}

	public void setCategoryTyp(CategoryTyp categoryTyp) {
		this.categoryTyp = categoryTyp;
	}
	
	public UUID getVstngRlHdrUuid() {
		return vstngRlHdrUuid;
	}
	
	public void setVstngRlHdrUuid(UUID vstngRlHdrUuid) {
		this.vstngRlHdrUuid = vstngRlHdrUuid;
	}
	
	public UUID getCtgryTypUuid() {
		return ctgryTypUuid;
	}
	
	public void setCtgryTypUuid(UUID ctgryTypUuid) {
		this.ctgryTypUuid = ctgryTypUuid;
	}
}
