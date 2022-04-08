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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaime
 */
@Entity
@Table(name = "FUND_PRICE")
public class FundPrice extends BaseEntityUuid{
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "FUND_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Fund fund;
    
    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @Column(name = "CRT_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crtDt;
    
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDt;
    
    @Column(name = "PRICE_CNT", 
            columnDefinition = "NUMBER(20, 7)")
    private BigDecimal priceCnt;
    
    @Column(name = "OTHR_PRICE_CNT", 
            columnDefinition = "NUMBER(20, 7)")
    private BigDecimal othrPriceCnt;
    
    @Column(name = "fund_uuid",
			insertable = false, 
			updatable = false)
    private UUID fundUuid;
    
    public FundPrice() {}

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }

    public Date getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(Date crtDt) {
        this.crtDt = crtDt;
    }

	public BigDecimal getPriceCnt() {
		return priceCnt;
	}

	public void setPriceCnt(BigDecimal priceCnt) {
		this.priceCnt = priceCnt;
	}

	public BigDecimal getOthrPriceCnt() {
		return othrPriceCnt;
	}

	public void setOthrPriceCnt(BigDecimal othrPriceCnt) {
		this.othrPriceCnt = othrPriceCnt;
	}

	public UUID getFundUuid() {
        return fundUuid;
    }
    
    public void setFundUuid(UUID fundUuid) {
        this.fundUuid = fundUuid;
    }

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
    
}
