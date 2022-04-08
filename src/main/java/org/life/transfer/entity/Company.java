/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "COMPANY")
public class Company extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    /**
     *  Primary key of this Entity must identical to {@link Client}
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",
                referencedColumnName = "id",
                insertable = false,
                updatable = false)
    private Client client;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Branch> branches;
    
    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<CmpnyRltdPrsn> cmpnyRltdPrsns;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "PNSN_ID_TXT",
            nullable = false,
            length = 20,
            unique = true)
    private String pnsnIdTxt;
    
    @Column(name = "CMPNY_GRP_CD", 
            columnDefinition = "NUMBER(15, 0)")
    private Long cmpnyGrpCd;
    
    @Size(max = 20)
    @Column(name = "TRST_CMPNY_CD",
            unique = true,
            length = 20)
    private String trstCmpnyCd;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "CMPNY_NM",
            nullable = false,
            length = 200)
    private String cmpnyNm;
    
    @Size(max = 200)
    @Column(name = "CMPNY_CHNS_NM", 
    length = 200)
    private String cmpnyChnsNm;
    
    @Size(max = 20)
    @Column(name = "CMPNY_TYP_ID", 
    length = 20)
    private String cmpnyTypId;
    
    @NotNull
    @Column(name = "INCRPRTN_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date incrprtnDt;
    
    @Size(max = 100)
    @Column(name = "INCRPRTN_CRTFCT_NMBR_TXT",
            length = 100)
    private String incrprtnCrtfctNmbrTxt;
    
    @Size(max = 10)
    @Column(name = "CNTRY_TYP_CD",
            length = 10)
    private String cntryTypCd;
    
    @Size(max = 20)
    @Column(name = "NTR_TYP_ID",
            length = 20)
    private String ntrTypId;
    
    @Column(name = "TERM_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDt;
    
    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            length = 20)
    private String sttsTypId;
    
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
    
    public Company() {
        
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Set<Branch> getBranches() {
        return branches;
    }
    
    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
        if (branches != null) {
            branches.stream().filter(branch -> (branch.getCompany() == null)).forEachOrdered(branch -> {
                branch.setCompany(this);
            });
        }
    }
    
    public Set<CmpnyRltdPrsn> getCmpnyRltdPrsns() {
        return cmpnyRltdPrsns;
    }
    
    public void setCmpnyRltdPrsns(Set<CmpnyRltdPrsn> cmpnyRltdPrsns) {
        this.cmpnyRltdPrsns = cmpnyRltdPrsns;
        if (cmpnyRltdPrsns != null) {
            cmpnyRltdPrsns.stream().filter(cmpnyRltdPrsn -> (cmpnyRltdPrsn.getCompany() == null)).forEachOrdered(cmpnyRltdPrsn -> {
                cmpnyRltdPrsn.setCompany(this);
            });
        }
    }
    
    public String getPnsnIdTxt() {
        return pnsnIdTxt;
    }
    
    public void setPnsnIdTxt(String pnsnIdTxt) {
        this.pnsnIdTxt = pnsnIdTxt;
    }
    
    public Long getCmpnyGrpCd() {
        return cmpnyGrpCd;
    }
    
    public void setCmpnyGrpCd(Long cmpnyGrpCd) {
        this.cmpnyGrpCd = cmpnyGrpCd;
    }
    
    public String getTrstCmpnyCd() {
        return trstCmpnyCd;
    }
    
    public void setTrstCmpnyCd(String trstCmpnyCd) {
        this.trstCmpnyCd = trstCmpnyCd;
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
    
    public String getNtrTypId() {
        return ntrTypId;
    }
    
    public void setNtrTypId(String ntrTypId) {
        this.ntrTypId = ntrTypId;
    }
    
    public Date getTermDt() {
        return termDt;
    }
    
    public void setTermDt(Date termDt) {
        this.termDt = termDt;
    }
    
    public String getSttsTypId() {
        return sttsTypId;
    }
    
    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
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
    
    public String getIncrprtnCrtfctNmbrTxt() {
        return incrprtnCrtfctNmbrTxt;
    }
    
    public void setIncrprtnCrtfctNmbrTxt(String incrprtnCrtfctNmbrTxt) {
        this.incrprtnCrtfctNmbrTxt = incrprtnCrtfctNmbrTxt;
    }
    
}
