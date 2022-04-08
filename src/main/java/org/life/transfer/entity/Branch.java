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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.life.transfer.entity.BaseEntity;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "BRANCH")
public class Branch extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;    

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CMPNY_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private Set<ClientRelationship> clientRelationships;
    
    @NotNull
    @Column(name = "BRNCH_CD",
            nullable = false, 
            columnDefinition = "NUMBER(15, 0)")
    private long brnchCd;
    
    @Size(max = 100)
    @Column(name = "BRNCH_NM",
            length = 100)
    private String brnchNm;
    
    @Size(max = 200)
    @Column(name = "BRNCH_DSCRPTN_TXT",
            length = 200)
    private String brnchDscrptnTxt;
    
    @Size(max = 50)
    @Column(name = "BRNCH_NO_TXT",
            length = 50)
    private String brnchNoTxt;
    
    @Size(max = 20)
    @Column(name = "PNSN_ID_TXT",
            length = 20)
    private String pnsnIdTxt;
    
    @Size(max = 50)
    @Column(name = "PYRLL_GRP_TXT",
            length = 50)
    private String pyrllGrpTxt;

    @NotNull
    @Column(name = "INCRPRTN_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date incrprtnDt;
    
    @Size(max = 20)
    @Column(name = "CMM_TYP_ID",
            length = 20)
    private String cmmTypId;
    
    @Size(max = 20)
    @Column(name = "LNGG_TYP_ID",
            length = 20)
    private String lnggTypId;

    @NotNull
    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            nullable = false,
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
    private Date changeDt;
    
    @Column(name = "cmpny_uuid",
			insertable = false, 
			updatable = false)
    private UUID cmpnyUiid;

    public Branch() {
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

    public Date getChangeDt() {
        return changeDt;
    }

    public void setChangeDt(Date changeDt) {
        this.changeDt = changeDt;
    }

    public long getBrnchCd() {
        return brnchCd;
    }

    public void setBrnchCd(long brnchCd) {
        this.brnchCd = brnchCd;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<ClientRelationship> getClientRelationships() {
        return clientRelationships;
    }

    public void setClientRelationships(Set<ClientRelationship> clientRelationships) {
        this.clientRelationships = clientRelationships;
    }

    public String getBrnchNm() {
        return brnchNm;
    }

    public void setBrnchNm(String brnchNm) {
        this.brnchNm = brnchNm;
    }

    public String getBrnchDscrptnTxt() {
        return brnchDscrptnTxt;
    }

    public void setBrnchDscrptnTxt(String brnchDscrptnTxt) {
        this.brnchDscrptnTxt = brnchDscrptnTxt;
    }

    public String getBrnchNoTxt() {
        return brnchNoTxt;
    }

    public void setBrnchNoTxt(String brnchNoTxt) {
        this.brnchNoTxt = brnchNoTxt;
    }

    public String getPnsnIdTxt() {
        return pnsnIdTxt;
    }

    public void setPnsnIdTxt(String pnsnIdTxt) {
        this.pnsnIdTxt = pnsnIdTxt;
    }

    public String getPyrllGrpTxt() {
        return pyrllGrpTxt;
    }

    public void setPyrllGrpTxt(String pyrllGrpTxt) {
        this.pyrllGrpTxt = pyrllGrpTxt;
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
    
    public UUID getCmpnyUiid() {
        return cmpnyUiid;
    }
    
    public void setCmpnyUiid(UUID cmpnyUiid) {
        this.cmpnyUiid = cmpnyUiid;
    }
}
