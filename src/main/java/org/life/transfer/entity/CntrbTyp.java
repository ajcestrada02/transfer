package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cntrb_typ")
public class CntrbTyp extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @Size(max = 20)
    @Column(name = "cntrb_typ_id", 
            length = 20)
    private String cntrbTypId;

    @Size(max = 50)
    @Column(name = "cntrb_typ_nm", 
            length = 50)
    private String cntrbTypNm;

    @Size(max = 50)
    @Column(name = "cntrb_grp_nm", 
            length = 50)
    private String cntrbGrpNm;

    @Size(max = 50)
    @Column(name = "cntrb_othr_grp_nm", 
            length = 50)
    private String cntrbOthrGrpNm;

    @Size(max = 10)
    @Column(name = "cntrb_abb_nm", 
            length = 10)
    private String cntrbAbbNm;

    @Column(name = "prcss_seq_nmbr", 
            columnDefinition = "Number(3, 0)")
    private Integer prcssSeqNmbr;

    @NotNull
    @Column(name = "efctv_dt", 
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;

    @NotNull
    @Column(name = "chg_dt", 
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;

    public String getCntrbTypId() {
        return cntrbTypId;
    }

    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }

    public String getCntrbTypNm() {
        return cntrbTypNm;
    }

    public void setCntrbTypNm(String cntrbTypNm) {
        this.cntrbTypNm = cntrbTypNm;
    }

    public String getCntrbGrpNm() {
        return cntrbGrpNm;
    }

    public void setCntrbGrpNm(String cntrbGrpNm) {
        this.cntrbGrpNm = cntrbGrpNm;
    }

    public String getCntrbOthrGrpNm() {
        return cntrbOthrGrpNm;
    }

    public void setCntrbOthrGrpNm(String cntrbOthrGrpNm) {
        this.cntrbOthrGrpNm = cntrbOthrGrpNm;
    }

    public String getCntrbAbbNm() {
        return cntrbAbbNm;
    }

    public void setCntrbAbbNm(String cntrbAbbNm) {
        this.cntrbAbbNm = cntrbAbbNm;
    }

    public Integer getPrcssSeqNmbr() {
        return prcssSeqNmbr;
    }

    public void setPrcssSeqNmbr(Integer prcssSeqNmbr) {
        this.prcssSeqNmbr = prcssSeqNmbr;
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
