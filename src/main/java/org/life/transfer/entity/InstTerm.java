/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "INST_TERM")
public class InstTerm extends BaseEntityUuid {

	private static final long serialVersionUID = 1L;

	@NotNull
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, 
              optional = false)
    @JoinColumn(name = "INST_UUID",
                referencedColumnName = "id",
                nullable = false,
                unique = true)
    private Instruction instruction;

    @Column(name = "LSPSP_OFFST_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short lspspOffstFlg;
    
    @Size(max = 20)
    @Column(name = "LSPSP_TYP_ID", 
            length = 20)
    private String lspspTypId;
    
    @Column(name = "TTL_EE_LSPSP_ENTTL_AMT", 
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal ttlEeLspspEnttlAmt;
    
    @Column(name = "OFFST_MNS_AMT", 
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal offstMnsAmt;
    
    @Size(max = 200)
    @Column(name = "OFFST_MNS_TXT", 
            length = 200)
    private String offstMnsTxt;
    
    @Column(name = "ORSO_OFFST_AMT", 
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal orsoOffstAmt;
    
    @Size(max = 200)
    @Column(name = "ORSO_SCHM_TXT", 
            length = 200)
    private String orsoSchmTxt;
    
    @Column(name = "ORSO_PAID_AMT", 
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal orsoPaidAmt;
    
    @Column(name = "EMP_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empDt;
    
    @Column(name = "LDOE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ldoeDt;
    
    @Column(name = "ER_PAID_EE_AMT", 
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal erPaidEeAmt;
    
    @Column(name = "EE_NOT_AGR_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short eeNotAgrFlg;
    
    @Column(name = "LSPSP_SEQ_NMBR", 
            columnDefinition = "NUMBER(3, 0)")
    private Short lspspSeqNmbr;
    
    @Column(name = "inst_uuid",
			insertable = false, 
			updatable = false)
    private UUID instUuid;

	public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public Short getLspspOffstFlg() {
        return lspspOffstFlg;
    }

    public void setLspspOffstFlg(Short lspspOffstFlg) {
        this.lspspOffstFlg = lspspOffstFlg;
    }

    public String getLspspTypId() {
        return lspspTypId;
    }

    public void setLspspTypId(String lspspTypId) {
        this.lspspTypId = lspspTypId;
    }

    public BigDecimal getTtlEeLspspEnttlAmt() {
        return ttlEeLspspEnttlAmt;
    }

    public void setTtlEeLspspEnttlAmt(BigDecimal ttlEeLspspEnttlAmt) {
        this.ttlEeLspspEnttlAmt = ttlEeLspspEnttlAmt;
    }

    public BigDecimal getOffstMnsAmt() {
        return offstMnsAmt;
    }

    public void setOffstMnsAmt(BigDecimal offstMnsAmt) {
        this.offstMnsAmt = offstMnsAmt;
    }

    public String getOffstMnsTxt() {
        return offstMnsTxt;
    }

    public void setOffstMnsTxt(String offstMnsTxt) {
        this.offstMnsTxt = offstMnsTxt;
    }

    public BigDecimal getOrsoOffstAmt() {
        return orsoOffstAmt;
    }

    public void setOrsoOffstAmt(BigDecimal orsoOffstAmt) {
        this.orsoOffstAmt = orsoOffstAmt;
    }

    public String getOrsoSchmTxt() {
        return orsoSchmTxt;
    }

    public void setOrsoSchmTxt(String orsoSchmTxt) {
        this.orsoSchmTxt = orsoSchmTxt;
    }

    public BigDecimal getOrsoPaidAmt() {
        return orsoPaidAmt;
    }

    public void setOrsoPaidAmt(BigDecimal orsoPaidAmt) {
        this.orsoPaidAmt = orsoPaidAmt;
    }

    public Date getLdoeDt() {
        return ldoeDt;
    }

    public void setLdoeDt(Date ldoeDt) {
        this.ldoeDt = ldoeDt;
    }

    public BigDecimal getErPaidEeAmt() {
        return erPaidEeAmt;
    }

    public void setErPaidEeAmt(BigDecimal erPaidEeAmt) {
        this.erPaidEeAmt = erPaidEeAmt;
    }

    public Short getEeNotAgrFlg() {
        return eeNotAgrFlg;
    }

    public void setEeNotAgrFlg(Short eeNotAgrFlg) {
        this.eeNotAgrFlg = eeNotAgrFlg;
    }
    
    public Date getEmpDt() {
        return empDt;
    }

    public void setEmpDt(Date empDt) {
        this.empDt = empDt;
    }

	public Short getLspspSeqNmbr() {
		return lspspSeqNmbr;
	}

	public void setLspspSeqNmbr(Short lspspSeqNmbr) {
		this.lspspSeqNmbr = lspspSeqNmbr;
	}
    
    public UUID getInstUuid() {
        return instUuid;
    }
    
    public void setInstUuid(UUID instUuid) {
        this.instUuid = instUuid;
    }
}
