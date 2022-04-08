/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cristian Realuyo <CristianEldrian.M.Realuyo@pccw.com>
 * 
 * 25 Aug 2021
 */
@Entity
@Table(name = "excptn_hst")
public class ExcptnHst extends BaseEntityUuid {
    
    @Column(name = "excptn_dt")
    private String excptnDt;
    
    @Size(max = 20)
    @Column(name = "excptn_typ_id",
            length = 20)
    private String excptnTypid;
    
    @JoinColumn(name = "inst_uuid",
        referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Instruction instruction;
    
    @Size(max = 300)
    @Column(name = "excptn_rsn_txt",
            length = 300)
    private String excptnRsnTxt;
    
    @Column(name = "fllwup_typ_id")
    private String fllwupTypId;

    public String getExcptnDt() {
        return excptnDt;
    }

    public void setExcptnDt(String excptnDt) {
        this.excptnDt = excptnDt;
    }

    public String getExcptnTypid() {
        return excptnTypid;
    }

    public void setExcptnTypid(String excptnTypid) {
        this.excptnTypid = excptnTypid;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public String getExcptnRsnTxt() {
        return excptnRsnTxt;
    }

    public void setExcptnRsnTxt(String excptnRsnTxt) {
        this.excptnRsnTxt = excptnRsnTxt;
    }

    public String getFllwupTypId() {
        return fllwupTypId;
    }

    public void setFllwupTypId(String fllwupTypId) {
        this.fllwupTypId = fllwupTypId;
    }
}
