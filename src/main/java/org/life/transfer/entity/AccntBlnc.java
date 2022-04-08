package org.life.transfer.entity;

import java.math.BigDecimal;
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

@Entity
@Table(name = "ACCNT_BLNC")
public class AccntBlnc extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    @JoinColumn(name = "ENTTY_UUID",
                referencedColumnName = "ID",
                nullable = false)
    private ClientRelationship clientRelationship;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
              optional = false)
    @JoinColumn(name = "FUND_UUID",
                referencedColumnName = "ID",
                nullable = false)
    private Fund fund;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CNTRB_TYP_ID",
                referencedColumnName = "CNTRB_TYP_ID",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, 
               optional = false)
    private ContributionTyp cntrbTyp;

    @Column(name = "CNTRB_TYP_ID",
            insertable = false, 
            updatable = false,
            length = 20)
    private String cntrbTypId;

    @Size(max = 200)
    @Column(name = "UNIT_CNT",
            length = 200)
    private BigDecimal unitCnt;

    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @Column(name = "entty_uuid",
            insertable = false,
            updatable = false)
    private UUID enttyUuid; 
    
    @Column(name = "fund_uuid",
            insertable = false,
            updatable = false)
    private UUID fundUuid;

    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }

    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public ContributionTyp getCntrbTyp() {
        return cntrbTyp;
    }

    public void setCntrbTyp(ContributionTyp cntrbTyp) {
        this.cntrbTyp = cntrbTyp;
    }

    public String getCntrbTypId() {
        return cntrbTypId;
    }

    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }

    public BigDecimal getUnitCnt() {
        return unitCnt;
    }

    public void setUnitCnt(BigDecimal unitCnt) {
        this.unitCnt = unitCnt;
    }

    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }
    
    public UUID getEnttyUuid() {
        return enttyUuid;
    }
    
    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }
    
    public UUID getFundUuid() {
        return fundUuid;
    }
    
    public void setFundUuid(UUID fundUuid) {
        this.fundUuid = fundUuid;
    }
}
