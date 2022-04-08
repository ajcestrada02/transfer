package org.life.transfer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Arbe Padilla <ArbeJorgeA.Padilla@pccw.com>
 */

@Entity
@Table(name = "ER_REG_BRNCH")
public class ErRegBrnch extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;
    
    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erRegBrnch")
    private List<RegAddr> regErAddrs;
    
    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, 
               optional = false)
    @JoinColumn(name = "REF_NO_TXT",
                referencedColumnName = "REF_NO_TXT",
                nullable = false)
    private ErRegCmpny erRegCmpny;
    
    @Column(name = "ref_no_txt",
            length = 50,
            insertable = false,
            updatable = false)
    private String ref_no_txt;
    
    @Size(max = 20)
    @Column(name = "reg_brnch_cd_txt",
            length = 20)
    private String regBrnchCdTxt;
    
    @Size(max = 200)
    @Column(name = "brnch_nm",
            length = 200)
    private String brnchNm;
    
    @Size(max = 20)
    @Column(name = "brnch_no_txt",
            length = 20)
    private String brnchNoTxt;
    
    @Size(max = 100)
    @Column(name = "othr_ntr_txt",
            length = 100)
    private String othrNtrTxt;
    
    @NotNull
    @Column(name = "incrprtn_dt", 
            nullable = false)
    private Date incrprtnDt;
    
    @Size(max = 20)
    @Column(name = "cmm_typ_id",
            length = 20)
    private String cmmTypId;
    
    @Size(max = 20)
    @Column(name = "lngg_typ_id",
            length = 20)
    private String lnggTypId;
    
    @NotNull
    @Column(name = "efctv_dt",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "chg_dt",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date chgDt;

    public List<RegAddr> getRegErAddrs() {
        return regErAddrs;
    }

    public void setRegErAddrs(List<RegAddr> regErAddrs) {
        this.regErAddrs = regErAddrs;
    }

    public String getRegBrnchCdTxt() {
        return regBrnchCdTxt;
    }

    public void setRegBrnchCdTxt(String regBrnchCdTxt) {
        this.regBrnchCdTxt = regBrnchCdTxt;
    }

    public String getBrnchNm() {
        return brnchNm;
    }

    public void setBrnchNm(String brnchNm) {
        this.brnchNm = brnchNm;
    }

    public String getBrnchNoTxt() {
        return brnchNoTxt;
    }

    public void setBrnchNoTxt(String brnchNoTxt) {
        this.brnchNoTxt = brnchNoTxt;
    }

    public String getOthrNtrTxt() {
        return othrNtrTxt;
    }

    public void setOthrNtrTxt(String othrNtrTxt) {
        this.othrNtrTxt = othrNtrTxt;
    }

    public Date getIncrprtnDt() {
        return incrprtnDt;
    }

    public void setIncrprtnDt(Date incrprtnDt) {
        this.incrprtnDt = incrprtnDt;
    }

    public String getCmmTypId() {
        return cmmTypId;
    }

    public void setCmmTypId(String cmmTypId) {
        this.cmmTypId = cmmTypId;
    }

    public String getLnggTypId() {
        return lnggTypId;
    }

    public void setLnggTypId(String lnggTypId) {
        this.lnggTypId = lnggTypId;
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

	public String getRef_no_txt() {
		return ref_no_txt;
	}

	public void setRef_no_txt(String ref_no_txt) {
		this.ref_no_txt = ref_no_txt;
	}
    
    public ErRegCmpny getErRegCmpny() {
        return erRegCmpny;
    }
    
    public void setErRegCmpny(ErRegCmpny erRegCmpny) {
        this.erRegCmpny = erRegCmpny;
    }
}
