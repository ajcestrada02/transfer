package org.life.transfer.entity;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CEE_INV_MNDT")
public class CeeInvMndt {    

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(generator="UUID")
    private UUID id;
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "IND_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Individual individual;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "SCHM_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Scheme scheme;
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "FUND_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Fund fund;

    @NotNull
    @Size(max = 20)
    @Column(name = "cntrb_typ_id",
            nullable = false,
            length = 20)
    private String cntrbTypId;
    
    @NotNull
    @Column(name = "prcntg_rt",
            nullable = false, 
            columnDefinition = "NUMBER(9, 2)")
    private BigDecimal prcntgRt;
    
    @NotNull
    @Column(name = "is_sys_crt_flg",
            nullable = false, 
            columnDefinition = "NUMBER(3, 0)")
    private Short isSysCrtFlg;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EFCTV_DT",
            nullable = false)
    private Date efctvDt;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHG_DT",
            nullable = false)
    private Date chgDt;
    
    @NotNull
    @Column(name = "ind_uuid",
			insertable = false, 
			updatable = false)
    private UUID indUuid;
    
    @Column(name = "schm_uuid",
			insertable = false, 
			updatable = false)
    private UUID schmUuid;
    
    @Column(name = "fund_uuid",
			insertable = false, 
			updatable = false)
    private UUID fundUuid;
    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public String getCntrbTypId() {
        return cntrbTypId;
    }

    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }

    public BigDecimal getPrcntgRt() {
        return prcntgRt;
    }

    public void setPrcntgRt(BigDecimal prcntgRt) {
        this.prcntgRt = prcntgRt;
    }

    public Short getIsSysCrtFlg() {
        return isSysCrtFlg;
    }

    public void setIsSysCrtFlg(Short isSysCrtFlg) {
        this.isSysCrtFlg = isSysCrtFlg;
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
    
    public UUID getIndUuid() {
        return indUuid;
    }
    
    public void setIndUuid(UUID indUuid) {
        this.indUuid = indUuid;
    }
    
    public UUID getSchmUuid() {
        return schmUuid;
    }
    
    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }
    
    public UUID getFundUuid() {
        return fundUuid;
    }
    
    public void setFundUuid(UUID fundUuid) {
        this.fundUuid = fundUuid;
    }
}
