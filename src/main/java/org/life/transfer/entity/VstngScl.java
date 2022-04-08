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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "VSTNG_SCL")
public class VstngScl extends BaseEntityUuid {
    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "ER_GRD_CNTRB_TYP_RLTNSHP_UUID",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, 
               optional = false)
    private ErGrdCntrbTypRltnshp erGrdCntrbTypRltnshp;

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

    @Column(name = "RNG_FRM", 
            columnDefinition = "NUMBER(18, 2)")
    private Double rngFrm;

    @Column(name = "RNG_TO", 
            columnDefinition = "NUMBER(18, 2)")
    private Double rngTo;

    @Column(name = "VSTNG_RT", 
            columnDefinition = "NUMBER(5, 4)")
    private Double vstngRt;

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
    
    @Column(name = "er_grd_cntrb_typ_rltnshp_uuid",
            insertable = false,
            updatable = false)
    private UUID erGrdCntrbTypRltnshpUuid;
    
    @Column(name = "CTGRY_TYP_UUID",
            insertable = false,
            updatable = false)
    private UUID ctgryTypUuid;

    public VstngScl() {
    }

    public ErGrdCntrbTypRltnshp getErGrdCntrbTypRltnshp() {
        return erGrdCntrbTypRltnshp;
    }

    public void setErGrdCntrbTypRltnshp(ErGrdCntrbTypRltnshp erGrdCntrbTypRltnshp) {
        this.erGrdCntrbTypRltnshp = erGrdCntrbTypRltnshp;
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

    public Double getRngFrm() {
        return rngFrm;
    }

    public void setRngFrm(Double rngFrm) {
        this.rngFrm = rngFrm;
    }

    public Double getRngTo() {
        return rngTo;
    }

    public void setRngTo(Double rngTo) {
        this.rngTo = rngTo;
    }

    public Double getVstngRt() {
        return vstngRt;
    }

    public void setVstngRt(Double vstngRt) {
        this.vstngRt = vstngRt;
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
}
