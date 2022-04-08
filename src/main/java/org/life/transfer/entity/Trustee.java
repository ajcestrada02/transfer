/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "TRUSTEE")
public class Trustee extends BaseEntityUuid {

	@NotNull
    @Column(name = "TRST_CD",
            unique = true, 
            columnDefinition = "NUMBER(15, 0)")
    private Long trstCd;
    
	@NotNull
    @Size(max = 200)
    @Column(name = "TRST_NM",
            unique = true,
            nullable = false,
            length = 200)
    private String trstNm;
    
    @Size(max = 200)
    @Column(name = "TRST_CHNS_NM",
            length = 200)
    private String trstChnsNm;
    
    @NotNull
    @Size(max = 10)
    @Column(name = "TRST_ABB_NM",
            length = 10, 
            nullable = false)
    private String trstAbbNm;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "TRST_APPRVL_NMBR_TXT",
            unique = true,
            length = 200, 
            nullable = false)
    private String trstApprvlNmbrTxt;
    
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

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trustee")
    private List<Scheme> schemes;

    public Trustee() {
    }

    public List<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<Scheme> schemes) {
        this.schemes = schemes;

        for (Scheme scheme : schemes)
            if (scheme.getTrustee() == null)
                scheme.setTrustee(this);
    }

    public Long getTrstCd() {
        return trstCd;
    }

    public void setTrstCd(Long trstCd) {
        this.trstCd = trstCd;
    }

    public String getTrstNm() {
        return trstNm;
    }

    public void setTrstNm(String trstNm) {
        this.trstNm = trstNm;
    }

    public String getTrstChnsNm() {
        return trstChnsNm;
    }

    public void setTrstChnsNm(String trstChnsNm) {
        this.trstChnsNm = trstChnsNm;
    }

    public String getTrstApprvlNmbrTxt() {
        return trstApprvlNmbrTxt;
    }

    public void setTrstApprvlNmbrTxt(String trstApprvlNmbrTxt) {
        this.trstApprvlNmbrTxt = trstApprvlNmbrTxt;
    }

    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }

	public String getTrstAbbNm() {
		return trstAbbNm;
	}

	public void setTrstAbbNm(String trstAbbNm) {
		this.trstAbbNm = trstAbbNm;
	}

	public Date getChgDt() {
		return chgDt;
	}

	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}

}
