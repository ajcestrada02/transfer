package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(
        name = "INST_TFER"
)
public class InstTfer extends BaseEntityUuid {
    @JsonIgnore
    @JoinColumn(
            name = "INST_UUID",
            referencedColumnName = "id"
    )
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Instruction instruction;

    @Size(
            max = 20
    )
    @Column(
            name = "CNTRB_TYP_ID",
            length = 20
    )
    private String cntrbTypId;

    public InstTfer() {
    }

    public Instruction getInstruction() {
        return this.instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public String getCntrbTypId() {
        return this.cntrbTypId;
    }

    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }
}
