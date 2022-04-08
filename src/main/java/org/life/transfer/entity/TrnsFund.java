package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaime
 */
@Entity
@Table(name = "TRNS_FUND")
public class TrnsFund extends BaseEntityUuid {
    
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "TRNS_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Transaction trns;
            
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "FUND_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Fund fund;
    
    @Column(name = "UNIT_CNT",
            columnDefinition = "NUMBER(20, 6)")
    private BigDecimal unitCnt;
    
    @Column(name = "TRNS_AMT",
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal trnsAmt;
    
    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    private Date chgDt;
    
    @Column(name = "trns_uuid",
			insertable = false, 
			updatable = false)
    private UUID trnsUuid;
    
    @Column(name = "fund_uuid",
			insertable = false, 
			updatable = false)
    private UUID fundUuid;
    
    public TrnsFund() {}

    public TrnsFund(Transaction trns, Fund fund, BigDecimal unitCnt, 
        BigDecimal trnsAmt, Date efctvDt, Date chgDt) {
        
        this.trns = trns;
        this.fund = fund;
        this.unitCnt = unitCnt;
        this.trnsAmt = trnsAmt;
        this.efctvDt = efctvDt;
        this.chgDt = chgDt;
    }
    
    public Transaction getTrns() {
        return trns;
    }

    public void setTrns(Transaction trns) {
        this.trns = trns;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public BigDecimal getUnitCnt() {
        return unitCnt;
    }

    public void setUnitCnt(BigDecimal unitCnt) {
        this.unitCnt = unitCnt;
    }

    public BigDecimal getTrnsAmt() {
        return trnsAmt;
    }

    public void setTrnsAmt(BigDecimal trnsAmt) {
        this.trnsAmt = trnsAmt;
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
    
    public UUID getTrnsUuid() {
        return trnsUuid;
    }
    
    public void setTrnsUuid(UUID trnsUuid) {
        this.trnsUuid = trnsUuid;
    }
    
    public UUID getFundUuid() {
        return fundUuid;
    }
    
    public void setFundUuid(UUID fundUuid) {
        this.fundUuid = fundUuid;
    }
}

