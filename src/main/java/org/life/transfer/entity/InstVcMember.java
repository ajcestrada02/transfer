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
@Table(name = "INST_VC_MBR")
public class InstVcMember extends BaseEntityUuid {

    @JsonIgnore
    @JoinColumn(name = "INST_UUID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Instruction instruction;

    @Size(max = 20)
    @Column(name = "CNTRB_TYP_ID", 
            length = 20)
    private String cntrbTypId;

    @Column(name = "CNTRB_RT", 
            columnDefinition = "NUMBER(9, 2)")
    private Short cntrbRt;

    @Column(name = "SSPNS_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Long sspnsFlg;

    @Column(name = "CNTRB_AMT", 
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal cntrbAmt;

    @Size(max = 20)
    @Column(name = "CNTRB_MD_ID", 
            length = 20)
    private String cntrbMdId;

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
    
    @Column(name = "inst_uuid",
            insertable = false,
            updatable = false)
    private UUID instUuid;

    public InstVcMember() {
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public String getCntrbTypId() {
        return cntrbTypId;
    }

    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }

    public Short getCntrbRt() {
        return cntrbRt;
    }

    public void setCntrbRt(Short cntrbRt) {
        this.cntrbRt = cntrbRt;
    }

    public Long getSspnsFlg() {
        return sspnsFlg;
    }

    public void setSspnsFlg(Long sspnsFlg) {
        this.sspnsFlg = sspnsFlg;
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
    
    public UUID getInstUuid() {
        return instUuid;
    }
    
    public void setInstUuid(UUID instUuid) {
        this.instUuid = instUuid;
    }
}
