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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "MBR_CSTM_CNTRB")
public class MemberCustomContribution extends BaseEntityUuid {
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "entty_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    private ClientRelationship clientRelationship;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "CNTRB_TYP_ID",
            nullable = false,
            length = 20)
    private String cntrbTypId;
    
    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHG_DT",
            nullable = false)
    private Date chgDt;
    
    @Column(name = "TERM_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDt;
    
    @Column(name = "CNTRB_RT",
            columnDefinition = "NUMBER(5, 4)")
    private BigDecimal cntrbRt;
    
    @Column(name = "CNTRB_AMT", 
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal cntrbAmt;
    
    @Size(max = 20)
    @Column(name = "CNTRB_MD_ID", 
            length = 20)
    private String cntrbMdId;
    
    @Column(name = "ENTTY_UUID",
			insertable = false, 
			updatable = false)
    private UUID enttyUuid;
    
    public MemberCustomContribution() {
    }
    
    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }
    
    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }
    
    public String getCntrbTypId() {
        return cntrbTypId;
    }
    
    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
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
    
    public BigDecimal getCntrbAmt() {
        return cntrbAmt;
    }
    
    public void setCntrbAmt(BigDecimal cntrbAmt) {
        this.cntrbAmt = cntrbAmt;
    }
    
    public String getCntrbMdId() {
        return cntrbMdId;
    }
    
    public void setCntrbMdId(String cntrbMdId) {
        this.cntrbMdId = cntrbMdId;
    }
    
    public BigDecimal getCntrbRt() {
        return cntrbRt;
    }
    
    public void setCntrbRt(BigDecimal cntrbRt) {
        this.cntrbRt = cntrbRt;
    }
    
    public UUID getEnttyUuid() {
        return enttyUuid;
    }
    
    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }
}
