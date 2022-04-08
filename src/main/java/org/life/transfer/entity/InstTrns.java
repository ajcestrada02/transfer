package org.life.transfer.entity;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "INST_TRNS")
public class InstTrns extends BaseEntityUuid {
    
    @NotNull
    @JsonIgnore
    @ManyToOne(optional = false,
			   fetch = FetchType.LAZY)
    @JoinColumn(name = "INST_UUID",
				referencedColumnName = "id",
				nullable = false)
    private Instruction instruction;
    
    @JsonIgnore
    @OneToMany(mappedBy = "instTrns")
    private Set<InstFund> instFunds;

	@JsonIgnore
	@ManyToOne(optional = false,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "CNTRB_TYP_UUID",
			referencedColumnName = "id",
			nullable = false)
    private CntrbTyp cntrbTypId;

	@Column(name = "CNTRB_TYP_UUID",
			insertable = false,
			updatable = false)
	private UUID cntrbTypUuid;
    
    @Size(max = 20)
	@Column(name = "cntrb_amt",
			length = 20)
    private BigDecimal cntrbAmt;
    
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
	public CntrbTyp getCntrbTypId() {
		return cntrbTypId;
	}

	public void setCntrbTypId(CntrbTyp cntrbTypId) {
		this.cntrbTypId = cntrbTypId;
	}
	public BigDecimal getCntrbAmt() {
		return cntrbAmt;
	}
	public void setCntrbAmt(BigDecimal cntrbAmt) {
		this.cntrbAmt = cntrbAmt;
	}
	
	public Set<InstFund> getInstFunds() {
		return instFunds;
	}
	
	public void setInstFunds(Set<InstFund> instFunds) {
		this.instFunds = instFunds;
	}
	
	public UUID getInstUuid() {
		return instUuid;
	}
	
	public void setInstUuid(UUID instUuid) {
		this.instUuid = instUuid;
	}
}
