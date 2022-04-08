package org.life.transfer.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 1 Jul 2021
 */

@Entity
@Table(name = "vstng_scl_dflt_sttng")
public class VstngSclDfltSttng extends BaseEntityUuid{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@JoinColumn(name = "VSTNG_RL_HDR_UUID",
				referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private VstngRlHdr vstngRlHdr;
	
	@Column(name = "VSTNG_SEQ_NMBR", 
			columnDefinition = "NUMBER(5, 0)")
	private Short vstngSeqNmbr;
	
	@JsonIgnore
	@JoinColumn(name = "CTGRY_TYP_UUID",
				referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CategoryTyp categoryTyp;
	
	@Column(name = "NMRC_RNG_DSCRPTN", 
			length = 50)
	@Size(max = 50)
	private String nmrcRngDscrptn;

	@Column(name = "VSTNG_OPTN_ID", 
			length = 20)
	@Size(max = 20)
	private String vstngOptnId;

	@Column(name = "RNG_FRM", 
			columnDefinition = "NUMBER(18, 2)")
	private BigDecimal rngFrm;
	
	@Column(name = "RNG_TO", 
			columnDefinition = "NUMBER(18, 2)")
	private BigDecimal rngTo;
	
	@Column(name = "VSTNG_RT", 
			columnDefinition = "NUMBER(5, 4)")
	private BigDecimal vstngRt;
	
	@NotNull
	@Column(name = "EFCTV_DT", 
			nullable = false)
	private Date efctvDt;
	
	@NotNull
	@Column(name = "CHG_DT",
			nullable = false)
	private Date chgDt;
	
	@Column(name = "TERM_DT")
	private Date termDt;
	
	@Column(name = "VSTNG_RL_HDR_UUID",
			insertable = false,
			updatable = false)
	private UUID vstngRlHdrUuid;
	
	@Column(name = "CTGRY_TYP_UUID",
            insertable = false,
            updatable = false)
    private UUID ctgryTypUuid;

	public VstngSclDfltSttng() {
	}

	public VstngRlHdr getVstngRlHdr() {
		return vstngRlHdr;
	}

	public void setVstngRlHdr(VstngRlHdr vstngRlHdr) {
		this.vstngRlHdr = vstngRlHdr;
	}

	public Short getVstngSeqNmbr() {
		return vstngSeqNmbr;
	}

	public void setVstngSeqNmbr(Short vstngSeqNmbr) {
		this.vstngSeqNmbr = vstngSeqNmbr;
	}

	public CategoryTyp getCategoryTyp() {
		return categoryTyp;
	}

	public void setCategoryTyp(CategoryTyp categoryTyp) {
		this.categoryTyp = categoryTyp;
	}

	public String getNmrcRngDscrptn() {
		return nmrcRngDscrptn;
	}

	public void setNmrcRngDscrptn(String nmrcRngDscrptn) {
		this.nmrcRngDscrptn = nmrcRngDscrptn;
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

	public Date getTermDt() {
		return termDt;
	}

	public void setTermDt(Date termDt) {
		this.termDt = termDt;
	}

	public String getVstngOptnId() {
		return vstngOptnId;
	}

	public void setVstngOptnId(String vstngOptnId) {
		this.vstngOptnId = vstngOptnId;
	}

	public BigDecimal getRngFrm() {
		return rngFrm;
	}

	public void setRngFrm(BigDecimal rngFrm) {
		this.rngFrm = rngFrm;
	}

	public BigDecimal getRngTo() {
		return rngTo;
	}

	public void setRngTo(BigDecimal rngTo) {
		this.rngTo = rngTo;
	}

	public BigDecimal getVstngRt() {
		return vstngRt;
	}

	public void setVstngRt(BigDecimal vstngRt) {
		this.vstngRt = vstngRt;
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
