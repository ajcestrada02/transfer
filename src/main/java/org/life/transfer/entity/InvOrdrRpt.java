package org.life.transfer.entity;
 
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "INV_ORDR_RPT")
public class InvOrdrRpt extends BaseEntityUuid {

    @JsonIgnore
    @JoinColumn(name="INST_FUND_UUID",
            referencedColumnName="ID")
    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    private InstFund instFund;

    @Column(name = "INST_FUND_UUID",
            insertable = false,
            updatable = false)
    private UUID instFundUuid;

    @Size(max = 20)
    @Column(name = "ORDR_TYP_NM",
            length = 20)
    private String ordrTypNm;

    @Size(max = 20)
    @Column(name = "ORDR_STTS_TYP_NM",
            length = 20)
    private String ordrSttsTypNm;

    @Column(name = "ORDR_RCVD_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordrRcvdDt;

    @Column(name = "ORDR_PNDNG_EXCTN_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordrPndngExctnDt;

    @Column(name = "ORDR_CMPLTD_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordrCmpltdDt;

    @Column(name = "GEN_DT_TM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gnrtDtTm;

    @Column(name = "SBSCRPTN_AMT",
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal sbscrptnAmt;

    @Column(name = "SBSCRPTN_UNT",
            columnDefinition = "NUMBER(18, 6)")
    private BigDecimal sbscrptnUnt;

    @Column(name = "RDMPTN_UNT",
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal rdmptnUnt;

    @Column(name = "RDMPTN_AMT",
            columnDefinition = "NUMBER(18, 6)")
    private BigDecimal rdmptnAmt;

    public InvOrdrRpt() {
    }

    public InstFund getInstFund() {
        return instFund;
    }

    public void setInstFund(InstFund instFund) {
        this.instFund = instFund;
    }

    public String getOrdrTypNm() {
        return ordrTypNm;
    }

    public void setOrdrTypNm(String ordrTypNm) {
        this.ordrTypNm = ordrTypNm;
    }

    public String getOrdrSttsTypNm() {
        return ordrSttsTypNm;
    }

    public void setOrdrSttsTypNm(String ordrSttsTypNm) {
        this.ordrSttsTypNm = ordrSttsTypNm;
    }

    public Date getOrdrRcvdDt() {
        return ordrRcvdDt;
    }

    public void setOrdrRcvdDt(Date ordrRcvdDt) {
        this.ordrRcvdDt = ordrRcvdDt;
    }

    public Date getOrdrPndngExctnDt() {
        return ordrPndngExctnDt;
    }

    public void setOrdrPndngExctnDt(Date ordrPndngExctnDt) {
        this.ordrPndngExctnDt = ordrPndngExctnDt;
    }

    public Date getOrdrCmpltdDt() {
        return ordrCmpltdDt;
    }

    public void setOrdrCmpltdDt(Date ordrCmpltdDt) {
        this.ordrCmpltdDt = ordrCmpltdDt;
    }

    public Date getGnrtDtTm() {
        return gnrtDtTm;
    }

    public void setGnrtDtTm(Date gnrtDtTm) {
        this.gnrtDtTm = gnrtDtTm;
    }

    public BigDecimal getSbscrptnAmt() {
        return sbscrptnAmt;
    }

    public void setSbscrptnAmt(BigDecimal sbscrptnAmt) {
        this.sbscrptnAmt = sbscrptnAmt;
    }

    public BigDecimal getSbscrptnUnt() {
        return sbscrptnUnt;
    }

    public void setSbscrptnUnt(BigDecimal sbscrptnUnt) {
        this.sbscrptnUnt = sbscrptnUnt;
    }

    public BigDecimal getRdmptnUnt() {
        return rdmptnUnt;
    }

    public void setRdmptnUnt(BigDecimal rdmptnUnt) {
        this.rdmptnUnt = rdmptnUnt;
    }

    public BigDecimal getRdmptnAmt() {
        return rdmptnAmt;
    }

    public void setRdmptnAmt(BigDecimal rdmptnAmt) {
        this.rdmptnAmt = rdmptnAmt;
    }
}
