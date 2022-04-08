package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

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
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ER_GRD_CTGRY_DTL")
public class ErGrdCtgryDtl extends BaseEntityUuid {

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "ER_GRD_CNTRB_TYP_RLTNSHP_UUID",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    private ErGrdCntrbTypRltnshp erGrdCntrbTypRltnshp;

    @Column(name = "CTGRY_DTL_SEQ_NMBR",
            columnDefinition = "NUMBER(5, 0)")
    private Short ctgryDtlSeqNmbr;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CTGRY_TYP_UUID",
                referencedColumnName = "id", 
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    private CategoryTyp categoryTyp;

    @Column(name = "RNG_FRM", 
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal rngFrm;

    @Column(name = "RNG_TO", 
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal rngTo;

    @Column(name = "CNTRB_RT", 
            columnDefinition = "NUMBER(5, 4)")
    private BigDecimal cntrbRt;

    @Column(name = "CNTRB_AMT", 
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal cntrbAmt;

    @Column(name = "TERM_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDt;
    
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
    
    @Column(name = "er_grd_cntrb_typ_rltnshp_uuid",
            insertable = false,
            updatable = false)
    private UUID erGrdCntrbTypRltnshpUuid;
    
    @Column(name = "ctgry_typ_uuid",
            insertable = false,
            updatable = false)
	private UUID ctgryTypUuid;
	
	@Size(max = 50)
	@Column(name = "nmrc_rng_dscrptn",
            length = 50)
	private String nmrcRngDscrptn;

    public ErGrdCtgryDtl() {
    }

    public ErGrdCntrbTypRltnshp getErGrdCntrbTypRltnshp() {
        return erGrdCntrbTypRltnshp;
    }

    public void setErGrdCntrbTypRltnshp(ErGrdCntrbTypRltnshp erGrdCntrbTypRltnshp) {
        this.erGrdCntrbTypRltnshp = erGrdCntrbTypRltnshp;
    }

    public Short getCtgryDtlSeqNmbr() {
        return ctgryDtlSeqNmbr;
    }

    public void setCtgryDtlSeqNmbr(Short ctgryDtlSeqNmbr) {
        this.ctgryDtlSeqNmbr = ctgryDtlSeqNmbr;
    }

    public CategoryTyp getCategoryTyp() {
        return categoryTyp;
    }

    public void setCategoryTyp(CategoryTyp categoryTyp) {
        this.categoryTyp = categoryTyp;
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

    public BigDecimal getCntrbRt() {
        return cntrbRt;
    }

    public void setCntrbRt(BigDecimal cntrbRt) {
        this.cntrbRt = cntrbRt;
    }

    public BigDecimal getCntrbAmt() {
        return cntrbAmt;
    }

    public void setCntrbAmt(BigDecimal cntrbAmt) {
        this.cntrbAmt = cntrbAmt;
    }

    public Date getTermDt() {
        return termDt;
    }

    public void setTermDt(Date termDt) {
        this.termDt = termDt;
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
    
    public UUID getErGrdCntrbTypRltnshpUuid() {
        return erGrdCntrbTypRltnshpUuid;
    }
    
    public void setErGrdCntrbTypRltnshpUuid(UUID erGrdCntrbTypRltnshpUuid) {
        this.erGrdCntrbTypRltnshpUuid = erGrdCntrbTypRltnshpUuid;
    }
    
    public UUID getCtgryTypUuid() {
        return ctgryTypUuid;
    }
    
    public void setCtgryTypUuid(UUID ctgryTypUuid) {
        this.ctgryTypUuid = ctgryTypUuid;
    }
    
    public String getNmrcRngDscrptn() {
        return nmrcRngDscrptn;
    }
    
    public void setNmrcRngDscrptn(String nmrcRngDscrptn) {
        this.nmrcRngDscrptn = nmrcRngDscrptn;
    }
}
