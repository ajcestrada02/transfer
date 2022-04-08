/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "ACTIVITY_TYP")
public class ActivityTyp extends BaseEntityUuid {
    
    @NotNull
    @NaturalId
    @Column(name = "acty_typ_id",
            unique = true,
            nullable = false,
            length = 20)
    private String actyTypId;
    
    @Size(max = 50)
    @Column(name = "acty_typ_nm",
            length = 50)
    private String actyTypNm;
    
    @Column(name = "is_sbscrptn_flg",
            columnDefinition = "NUMBER(3, 0)")
    private Short isSbscrptnFlg;
    
    @Column(name = "prcss_seq_nmbr",
            columnDefinition = "NUMBER(5, 0)")
    private Integer prcssSeqNmbr;
    
    
    public ActivityTyp() {
    }
    
    public String getActyTypId() {
        return actyTypId;
    }
    
    public void setActyTypId(String actyTypId) {
        this.actyTypId = actyTypId;
    }
    
    public String getActyTypNm() {
        return actyTypNm;
    }
    
    public void setActyTypNm(String actyTypNm) {
        this.actyTypNm = actyTypNm;
    }
    
    public Short getIsSbscrptnFlg() {
        return isSbscrptnFlg;
    }
    
    public void setIsSbscrptnFlg(Short isSbscrptnFlg) {
        this.isSbscrptnFlg = isSbscrptnFlg;
    }
    
    public Integer getPrcssSeqNmbr() {
        return prcssSeqNmbr;
    }
    
    public void setPrcssSeqNmbr(Integer prcssSeqNmbr) {
        this.prcssSeqNmbr = prcssSeqNmbr;
    }
    
}
