/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "CONTACT")
public class Contact extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "clnt_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Set<ClntPhone> clntPhones;

    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Set<Address> addresses;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Set<ClntEmail> clntEmails;
    
    @JsonIgnore
    @JoinColumn(name = "CMPNY_RLTD_PRSN_UUID", referencedColumnName = "ID")
    @ManyToOne(fetch =  FetchType.LAZY)
    private CmpnyRltdPrsn cmpnyRltdPrsn;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNTCT_PRSN_TYP_ID",
            nullable = false)
    private String cntctPrsnTypId;
    
    @Column(name = "SCHM_UUID")
    private UUID schmUuid;
    
    @Column(name = "ENTTY_UUID")
    private UUID enttyUuid;
    
    @Column(name = "TTL_TYP_ID")
    private String ttlTypCd;
    
    @Size(max = 20)
    @Column(name = "CMM_TYP_ID",
            length = 20)
    private String cmmTypId;
    
    @Size(max = 20)
    @Column(name = "LNGG_TYP_ID",
            length = 20)
    private String lnggTypId;
    
    @Column(name = "DRCT_MRKT_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short drctMrktFlg;
    
    @Column(name = "RCV_PPR_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short rcvPprFlg;
    
    @Size(max = 200)
    @Column(name = "JB_PSTN_TXT",
            length = 200)
    private String jbPstnTxt;
    
    @NotNull
    @Column(name = "EFCTV_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;
    
    @Column(name = "LST_NM")
    @Size(max = 100)
    private String lstNm;
    
    @Column(name = "FRST_NM",
            length = 100)
    @Size(max = 100)
    private String frstNm;
    
    @Column(name = "clnt_uuid",
            insertable = false,
            updatable = false)
    private UUID clntUuid;

    public Contact() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ClntPhone> getClntPhones() {
        return clntPhones;
    }

    public void setClntPhones(Set<ClntPhone> clntPhones) {
        this.clntPhones = clntPhones;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Short getRcvPprFlg() {
        return rcvPprFlg;
    }

    public void setRcvPprFlg(Short rcvPprFlg) {
        this.rcvPprFlg = rcvPprFlg;
    }

    public String getCntctPrsnTypId() {
        return cntctPrsnTypId;
    }

    public void setCntctPrsnTypId(String cntctPrsnTypId) {
        this.cntctPrsnTypId = cntctPrsnTypId;
    }

    public UUID getSchmUuid() {
        return schmUuid;
    }

    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }

    public UUID getEnttyUuid() {
        return enttyUuid;
    }

    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }

    public String getTtlTypCd() {
        return ttlTypCd;
    }

    public void setTtlTypCd(String ttlTypCd) {
        this.ttlTypCd = ttlTypCd;
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

    public Short getDrctMrktFlg() {
        return drctMrktFlg;
    }

    public void setDrctMrktFlg(Short drctMrktFlg) {
        this.drctMrktFlg = drctMrktFlg;
    }

    public String getLstNm() {
        return lstNm;
    }

    public void setLstNm(String lstNm) {
        this.lstNm = lstNm;
    }

    public String getJbPstnTxt() {
        return jbPstnTxt;
    }

    public void setJbPstnTxt(String jbPstnTxt) {
        this.jbPstnTxt = jbPstnTxt;
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

    public String getFrstNm() {
        return frstNm;
    }

    public void setFrstNm(String frstNm) {
        this.frstNm = frstNm;
    }
    
    
    
    public CmpnyRltdPrsn getCmpnyRltdPrsn() {
		return cmpnyRltdPrsn;
	}

	public void setCmpnyRltdPrsn(CmpnyRltdPrsn cmpnyRltdPrsn) {
		this.cmpnyRltdPrsn = cmpnyRltdPrsn;
	}
    
    public UUID getClntUuid() {
        return clntUuid;
    }
    
    public void setClntUuid(UUID clntUuid) {
        this.clntUuid = clntUuid;
    }

    public Set<ClntEmail> getClntEmails() {
        return clntEmails;
    }

    public void setClntEmails(Set<ClntEmail> clntEmails) {
        this.clntEmails = clntEmails;
        
        if(clntEmails!=null){
            clntEmails.stream().filter(email -> email.getContact()==null).forEachOrdered(email -> {
                email.setContact(this);
            });
        }
    }

}
