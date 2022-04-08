/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import java.util.UUID;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "INST_RSN")
public class InstRsn extends BaseEntityUuid {

    @NotNull
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "INST_UUID",
                referencedColumnName = "id",
                nullable = false)
    private Instruction instruction;
    
    @Size(max = 500)
    @Column(name = "RSN_TXT",
            length = 500)
    private String rsnTxt;
    
    @Column(name = "inst_uuid",
			insertable = false, 
			updatable = false)
    private UUID instUuid;

    public InstRsn() {
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public String getRsnTxt() {
        return rsnTxt;
    }

    public void setRsnTxt(String rsnTxt) {
        this.rsnTxt = rsnTxt;
    }
    
    public UUID getInstUuid() {
        return instUuid;
    }
    
    public void setInstUuid(UUID instUuid) {
        this.instUuid = instUuid;
    }
}
