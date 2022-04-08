package org.life.transfer.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * as per eMPF Table Structure V2.4
 */
@Entity
@Table(name = "INST_SSPNS")
public class InstSspns extends BaseEntityUuid {

    @NotNull
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,
			  optional = false)
    @JoinColumn(name = "INST_UUID",
				referencedColumnName = "id",
				nullable = false)
    private Instruction instruction;
    


    @Column(name = "INST_AMT", 
			columnDefinition = "NUMBER(20, 2)")
    private BigDecimal instAmt;
    
    @Column(name = "inst_uuid",
			insertable = false, 
			updatable = false)
    private UUID instUuid;
    
    @Column(name = "sspns_uuid")
    private UUID sspnsUuid;
    
    
    public InstSspns() {

    }
	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}


	public BigDecimal getInstAmt() {
		return instAmt;
	}

	public void setInstAmt(BigDecimal instAmt) {
		this.instAmt = instAmt;
	}
	
	public UUID getInstUuid() {
		return instUuid;
	}
	
	public void setInstUuid(UUID instUuid) {
		this.instUuid = instUuid;
	}
	
	public UUID getSspnsUuid() {
		return sspnsUuid;
	}
	
	public void setSspnsUuid(UUID sspnsUuid) {
		this.sspnsUuid = sspnsUuid;
	}
}
