/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "COUNTRY_TYP")
public class CountryTyp extends BaseEntityUuid {

	@NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CNTRY_TYP_CD",
            unique = true,
            nullable = false,
            length = 10)
    private String cntryTypCd;
	
	@NotNull
    @Size(max = 100)
    @Column(name = "CNTRY_TYP_NM",
            nullable = false,
            length = 100)
    private String cntryTypNm;
	
	@NotNull
    @Column(name = "TEL_CNTRY_CD_NMBR",
            nullable = false,
            columnDefinition = "NUMBER(5, 0)")
    private Integer telCntryCdNmbr;
	
	@NotNull
	@Size(max = 100)
    @Column(name = "CNTRY_CHNS_TYP_NM",
            nullable = false,
            length = 100)
    private String cntryChnsTypNm;
    
    public String getCntryChnsTypNm() {
		return cntryChnsTypNm;
	}

	public void setCntryChnsTypNm(String cntryChnsTypNm) {
		this.cntryChnsTypNm = cntryChnsTypNm;
	}

	public CountryTyp() {
    }

    public CountryTyp(String cntryTypCd) {
        this.cntryTypCd = cntryTypCd;
    }

    public String getCntryTypCd() {
        return cntryTypCd;
    }

    public void setCntryTypCd(String cntryTypCd) {
        this.cntryTypCd = cntryTypCd;
    }

    public String getCntryTypNm() {
        return cntryTypNm;
    }

    public void setCntryTypNm(String cntryTypNm) {
        this.cntryTypNm = cntryTypNm;
    }

    public Integer getTelCntryCdNmbr() {
        return telCntryCdNmbr;
    }

    public void setTelCntryCdNmbr(Integer telCntryCdNmbr) {
        this.telCntryCdNmbr = telCntryCdNmbr;
    }
    
}
