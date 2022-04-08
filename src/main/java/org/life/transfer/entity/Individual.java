/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.life.transfer.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "INDIVIDUAL")
public class Individual extends BaseEntity {

    @Id
    @Column(name = "id",
            nullable = false,
            unique = true)
    private UUID id;

    @JsonIgnore
    @JoinColumn(name="id",
                referencedColumnName="id",
                updatable = false,
                insertable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Client client;
    
    @Size(max = 15)
    @Column(name = "IND_CD",
            length = 15)
    private Long indCd;
    
    @Size(max = 20)
    @Column(name = "PNSN_ID_TXT",
            length = 20)
    private String pnsnIdTxt;
    
    @Size(max = 20)
    @Column(name = "TTL_TYP_ID",
            length = 20)
    private String ttlTypId;
    
    @Size(max = 50)
    @Column(name = "FRST_NM",
            length = 50)
    private String frstNm;
    
    @Size(max = 50)
    @Column(name = "LST_NM",
            length = 50)
    private String lstNm;
    
    @Size(max = 10)
    @Column(name = "CHNS_FRST_NM",
            length = 10)
    private String chnsFrstNm;
    
    @Size(max = 10)
    @Column(name = "CHNS_LST_NM",
            length = 10)
    private String chnsLstNm;
    
    @Size(max = 20)
    @Column(name = "GNDR_TYP_ID",
            length = 20)
    private String gndrTypId;
    
    @Column(name = "BRTH_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date brthDt;
    
    @Size(max = 10)
    @Column(name = "USR_INPUT_BRTH_DT",
            length = 10)
    private String usrInputBrthDt;
    
    @Size(max = 10)
    @Column(name = "POB_CNTRY_TYP_CD",
            length = 10)
    private String pobCntryTypCd;
    
    @Size(max = 10)
    @Column(name = "NTNLTY_CNTRY_TYP_CD",
            length = 10)
    private String ntnltyCntryTypCd;
    
    @Size(max = 3)
    @Column(name = "BNKRPTCY_FLG",
            length = 3)
    private Short bnkrptcyFlg;
    
    @Size(max = 20)
    @Column(name = "AML_RSK_ID",
            length = 20)
    private String amlRskId;
    
    @Column(name = "DCLRTN_CMPLT_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dclrtnCmpltDt;
    
    @Column(name = "DTH_PRF_RCVD_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthPrfRcvdDt;
    
    @Size(max = 20)
    @Column(name = "CEE_NMBR",
            length = 20)
    private String ceeNmbr;
    
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

    @Formula("concat(FRST_NM, concat(' ', LST_NM))")
    private String fullName;

    @Formula("concat(CHNS_FRST_NM, concat(' ', CHNS_LST_NM))")
    private String fullChName;
    
    public Individual() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullChName() {
        return fullChName;
    }
    
    public Date getChgDt() {
        return chgDt;
    }
    
    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    
    public Long getIndCd() {
        return indCd;
    }
    
    public void setIndCd(Long indCd) {
        this.indCd = indCd;
    }
    
    public String getPnsnIdTxt() {
        return pnsnIdTxt;
    }
    
    public void setPnsnIdTxt(String pnsnIdTxt) {
        this.pnsnIdTxt = pnsnIdTxt;
    }
    
    public String getTtlTypId() {
        return ttlTypId;
    }
    
    public void setTtlTypId(String ttlTypId) {
        this.ttlTypId = ttlTypId;
    }
    
    public String getFrstNm() {
        return frstNm;
    }
    
    public void setFrstNm(String frstNm) {
        this.frstNm = frstNm;
    }
    
    public String getLstNm() {
        return lstNm;
    }
    
    public void setLstNm(String lstNm) {
        this.lstNm = lstNm;
    }
    
    public String getChnsFrstNm() {
        return chnsFrstNm;
    }
    
    public void setChnsFrstNm(String chnsFrstNm) {
        this.chnsFrstNm = chnsFrstNm;
    }
    
    public String getChnsLstNm() {
        return chnsLstNm;
    }
    
    public void setChnsLstNm(String chnsLstNm) {
        this.chnsLstNm = chnsLstNm;
    }
    
    public String getGndrTypId() {
        return gndrTypId;
    }
    
    public void setGndrTypId(String gndrTypId) {
        this.gndrTypId = gndrTypId;
    }
    
    public Date getBrthDt() {
        return brthDt;
    }
    
    public void setBrthDt(Date brthDt) {
        this.brthDt = brthDt;
    }
    
    public String getUsrInputBrthDt() {
        return usrInputBrthDt;
    }
    
    public void setUsrInputBrthDt(String usrInputBrthDt) {
        this.usrInputBrthDt = usrInputBrthDt;
    }
    
    public String getPobCntryTypCd() {
        return pobCntryTypCd;
    }
    
    public void setPobCntryTypCd(String pobCntryTypCd) {
        this.pobCntryTypCd = pobCntryTypCd;
    }
    
    public String getNtnltyCntryTypCd() {
        return ntnltyCntryTypCd;
    }
    
    public void setNtnltyCntryTypCd(String ntnltyCntryTypCd) {
        this.ntnltyCntryTypCd = ntnltyCntryTypCd;
    }
    
    public Short getBnkrptcyFlg() {
        return bnkrptcyFlg;
    }
    
    public void setBnkrptcyFlg(Short bnkrptcyFlg) {
        this.bnkrptcyFlg = bnkrptcyFlg;
    }
    
    public Date getEfctvDt() {
        return efctvDt;
    }
    
    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }

	public String getAmlRskId() {
		return amlRskId;
	}

	public void setAmlRskId(String amlRskId) {
		this.amlRskId = amlRskId;
	}

	public Date getDclrtnCmpltDt() {
		return dclrtnCmpltDt;
	}

	public void setDclrtnCmpltDt(Date dclrtnCmpltDt) {
		this.dclrtnCmpltDt = dclrtnCmpltDt;
	}

	public Date getDthPrfRcvdDt() {
		return dthPrfRcvdDt;
	}

	public void setDthPrfRcvdDt(Date dthPrfRcvdDt) {
		this.dthPrfRcvdDt = dthPrfRcvdDt;
	}

	public String getCeeNmbr() {
		return ceeNmbr;
	}

	public void setCeeNmbr(String ceeNmbr) {
		this.ceeNmbr = ceeNmbr;
	}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @PrePersist
    public void prePersist() {
        if (this.id == null && this.client != null) {
            this.id = this.client.getId();
        }
    }
}
