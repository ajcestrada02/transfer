package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
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
 * @author Arbe Padilla <ArbeJorgeA.Padilla@pccw.com>
 */

@Entity
@Table(name = "ER_REG_CMPNY")
public class ErRegCmpny extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            unique = true,
            nullable = false,
            length = 50)
    private String refNoTxt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erRegCmpny")
    private Set<ErRegBrnch> erRegBrnchs;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erRegCmpny")
    private Set<ErRegAuthPrsn> erRegAuthPrsns;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erRegCmpny")
    private Set<RegAddr> regAddrs;

    @NotNull
    @Size(max = 50)
    @Column(name = "CMPNY_NM",
            nullable = false,
            length = 50)
    private String cmpnyNm;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "CMPNY_CHNS_NM",
            nullable = false,
            length = 100)
    private String cmpnyChnsNm;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "CMPNY_TYP_ID",
            nullable = false,
            length = 20)
    private String cmpnyTypId;
    
    @Column(name = "INCRPRTN_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incrprtnDt;
    
    @Size(max = 10)
    @Column(name = "CNTRY_TYP_CD",
            length = 10)
    private String cntryTypCd;
    
    @Size(max = 100)
    @Column(name = "TX_JRSDCTN_NM",
            length = 100)
    private String txJrsdctnNm;
    
    @Size(max = 20)
    @Column(name = "ID_TYP_ID",
            length = 20)
    private String idTypId;
    
    @Size(max = 200)
    @Column(name = "ID_NMBR_TXT",
            length = 200)
    private String idNmbrTxt;
    
    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            length = 20)
    private String sttsTypId;
    
    @Size(max = 20)
    @Column(name = "RJCT_TYP_ID",
            length = 20)
    private String rjctTypId;
    
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

    public ErRegCmpny() {

    }

    public String getRefNoTxt() {
        return refNoTxt;
    }

    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }

    public String getCmpnyNm() {
        return cmpnyNm;
    }

    public void setCmpnyNm(String cmpnyNm) {
        this.cmpnyNm = cmpnyNm;
    }

    public String getCmpnyChnsNm() {
        return cmpnyChnsNm;
    }

    public void setCmpnyChnsNm(String cmpnyChnsNm) {
        this.cmpnyChnsNm = cmpnyChnsNm;
    }

    public String getCmpnyTypId() {
        return cmpnyTypId;
    }

    public void setCmpnyTypId(String cmpnyTypId) {
        this.cmpnyTypId = cmpnyTypId;
    }

    public Date getIncrprtnDt() {
        return incrprtnDt;
    }

    public void setIncrprtnDt(Date incrprtnDt) {
        this.incrprtnDt = incrprtnDt;
    }

    public String getCntryTypCd() {
        return cntryTypCd;
    }

    public void setCntryTypCd(String cntryTypCd) {
        this.cntryTypCd = cntryTypCd;
    }

    public String getTxJrsdctnNm() {
        return txJrsdctnNm;
    }

    public void setTxJrsdctnNm(String txJrsdctnNm) {
        this.txJrsdctnNm = txJrsdctnNm;
    }

    public String getIdTypId() {
        return idTypId;
    }

    public void setIdTypId(String idTypId) {
        this.idTypId = idTypId;
    }

    public String getIdNmbrTxt() {
        return idNmbrTxt;
    }

    public void setIdNmbrTxt(String idNmbrTxt) {
        this.idNmbrTxt = idNmbrTxt;
    }

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }

    public String getRjctTypId() {
        return rjctTypId;
    }

    public void setRjctTypId(String rjctTypId) {
        this.rjctTypId = rjctTypId;
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

    public void setErRegBrnchs(Set<ErRegBrnch> erRegBrnchs) {
        this.erRegBrnchs = erRegBrnchs;
    }

    public Set<ErRegBrnch> getErRegBrnchs() {
        return erRegBrnchs;
    }

    public Set<RegAddr> getRegAddrs() {
        return regAddrs;
    }

    public void setRegAddrs(Set<RegAddr> regAddrs) {
        this.regAddrs = regAddrs;
    }
    
    public Set<ErRegAuthPrsn> getErRegAuthPrsns() {
        return erRegAuthPrsns;
    }
    
    public void setErRegAuthPrsns(Set<ErRegAuthPrsn> erRegAuthPrsns) {
        this.erRegAuthPrsns = erRegAuthPrsns;
    }
}
