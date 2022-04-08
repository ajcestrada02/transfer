package org.life.transfer.entity;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

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
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "TRANSACTION")
public class Transaction extends BaseEntityUuid {
    
	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonIgnore
    @JoinColumn(name = "ENTTY_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientRelationship clientRelationship;

    @NotNull
    @JoinColumn(name = "CNTRB_TYP_ID",
                referencedColumnName = "CNTRB_TYP_ID",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, 
               optional = false)
    private ContributionTyp contributionTyp;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trns")
    private Set<TrnsFund> trnsFunds;
    
    @Column(name = "ENTTY_UUID",
            insertable = false,
            updatable = false)
    private UUID enttyUuid;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "ACTY_TYP_ID",
            nullable = false,
            length = 20)
    private String actyTypId;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "ACTY_SUB_ID",
            nullable = false,
            length = 20)
    private String actySubId;
    
    @Column(name = "CNTRB_TYP_ID",
            insertable = false,
            updatable = false)
    private String cntrbTypId;
    
    @Column(name = "GRS_AMT",
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal grsAmt;
    
    @Column(name = "OTHR_AMT",
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal othrAmt;
    
    @Column(name = "NET_AMT",
            columnDefinition = "NUMBER(18, 2)")
    private BigDecimal netAmt;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            nullable = false,
            length = 50, 
            unique = true)
    private String refNoTxt;
    
	@Column(name = "REV_FLG", 
            columnDefinition = "NUMBER(3, 0)")
	private Short revFlg;
    
	@Column(name = "ORGNL_RQST_SBMSSN_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgnlRqstSbmssnDt;
	
	@NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CRT_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date crtDt;

    public Set<TrnsFund> getTrnsFunds() {
        return trnsFunds;
    }

    public void setTrnsFunds(Set<TrnsFund> trnsFunds) {
        this.trnsFunds = trnsFunds;
        
        if(trnsFunds!=null){
            for(TrnsFund trnsFund: trnsFunds){
                trnsFund.setTrns(this);
            }
        }
    }

    public UUID getEnttyUuid() {
        return enttyUuid;
    }

    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }
    
    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }
    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }
    public String getActyTypId() {
        return actyTypId;
    }
    public void setActyTypId(String actyTypId) {
        this.actyTypId = actyTypId;
    }
    public String getActySubId() {
        return actySubId;
    }
    public void setActySubId(String actySubId) {
        this.actySubId = actySubId;
    }
    public String getCntrbTypId() {
        return cntrbTypId;
    }
    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }
    public BigDecimal getGrsAmt() {
        return grsAmt;
    }
    public void setGrsAmt(BigDecimal grsAmt) {
        this.grsAmt = grsAmt;
    }
    public BigDecimal getOthrAmt() {
        return othrAmt;
    }
    public void setOthrAmt(BigDecimal othrAmt) {
        this.othrAmt = othrAmt;
    }
    public BigDecimal getNetAmt() {
        return netAmt;
    }
    public void setNetAmt(BigDecimal netAmt) {
        this.netAmt = netAmt;
    }
    public String getRefNoTxt() {
        return refNoTxt;
    }
    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }
//		public Short getRevFlg() {
//			return revFlg;
//		}
//		public void setRevFlg(Short revFlg) {
//			this.revFlg = revFlg;
//		}
    public Date getOrgnlRqstSbmssnDt() {
        return orgnlRqstSbmssnDt;
    }
    public void setOrgnlRqstSbmssnDt(Date orgnlRqstSbmssnDt) {
        this.orgnlRqstSbmssnDt = orgnlRqstSbmssnDt;
    }
    public Date getEfctvDt() {
        return efctvDt;
    }
    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }
    public Date getCrtDt() {
        return crtDt;
    }
    public void setCrtDt(Date crtDt) {
        this.crtDt = crtDt;
    }

	public ContributionTyp getContributionTyp() {
		return contributionTyp;
	}

	public void setContributionTyp(ContributionTyp contributionTyp) {
		this.contributionTyp = contributionTyp;
	}
    
    public Short getRevFlg() {
        return revFlg;
    }
    
    public void setRevFlg(Short revFlg) {
        this.revFlg = revFlg;
    }
}
