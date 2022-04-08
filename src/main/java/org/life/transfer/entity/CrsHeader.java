/**
 * 
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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jan Louie
 *
 */

@Entity
@Table(name = "CRS_HEADER")
@DynamicInsert
@DynamicUpdate
@NamedEntityGraph(name = "getCrsIndForm", //
attributeNodes = {
        @NamedAttributeNode(value = "client", subgraph = "client-subgraph"),
        @NamedAttributeNode(value = "crsJrsdctn"),
}, subgraphs = {

		@NamedSubgraph(name = "client-subgraph", attributeNodes = {
                @NamedAttributeNode(value = "identifications"),
                @NamedAttributeNode(value = "individual")
        })
 })

@NamedEntityGraph(name = "getCrsFormLst", //
attributeNodes = {
        @NamedAttributeNode(value = "client", subgraph = "client-subgraph"),
        @NamedAttributeNode(value = "crsJrsdctn"),
        @NamedAttributeNode(value = "company")
}, subgraphs = {

		@NamedSubgraph(name = "client-subgraph", attributeNodes = {
                @NamedAttributeNode(value = "identifications"),
                @NamedAttributeNode(value = "individual")
        })
 })
public class CrsHeader extends BaseEntityUuid{
	
	@NotNull
	@JsonIgnore
    @JoinColumn(name="clnt_uuid",
				referencedColumnName="id",
				nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
	
	@JsonIgnore
    @JoinColumn(name = "CMPNY_UUID",
				referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
	
	@Size(max = 50)
	@Column(name = "FORM_TYP_ID",
			length = 50)
	private String formTyp;
	
	@Size(max = 10)
	@Column(name = "FORM_STTS_ID",
			length = 10)
	private String formStts;
	
	@Size(max = 10)
	@Column(name = "TX_RSDNC_ID",
			length = 10)
	private String txRsdnc;
	
	@Size(max = 100)
	@Column(name = "FLLNG_PRSN_NM",
			length = 100)
	private String fllngPrsnNm;
	
	@Size(max = 50)
	@Column(name = "FLLNG_PRSN_CPCTY",
			length = 50)
	private String fllngPrsnCpcty;
	
	@Column(name = "clnt_uuid",
            insertable = false, 
            updatable = false)
    private UUID clntUuid;
	
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
    
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crsHeader")
    private Set<CrsEnttyAcctHldr> crsEnttyAcctHldr;
    
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crsHeader")
    private Set<CrsEnttyTyp> crsEnttyTyp;
    
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crsHeader")
    private Set<CrsJrsdctn> crsJrsdctn;
    
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crsHeader")
    private Set<CrsTypCntrllngPrsn> crsTypCntrllngPrsn;
    
    
    public CrsHeader() {
    }
    
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getFormTyp() {
		return formTyp;
	}
	public void setFormTyp(String formTyp) {
		this.formTyp = formTyp;
	}
	public String getFormStts() {
		return formStts;
	}
	public void setFormStts(String formStts) {
		this.formStts = formStts;
	}
	public String getTxRsdnc() {
		return txRsdnc;
	}
	public void setTxRsdnc(String txRsdnc) {
		this.txRsdnc = txRsdnc;
	}
	public String getFllngPrsnNm() {
		return fllngPrsnNm;
	}
	public void setFllngPrsnNm(String fllngPrsnNm) {
		this.fllngPrsnNm = fllngPrsnNm;
	}
	public String getFllngPrsnCpcty() {
		return fllngPrsnCpcty;
	}
	public void setFllngPrsnCpcty(String fllngPrsnCpcty) {
		this.fllngPrsnCpcty = fllngPrsnCpcty;
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

	public Set<CrsEnttyAcctHldr> getCrsEnttyAcctHldr() {
		return crsEnttyAcctHldr;
	}

	public void setCrsEnttyAcctHldr(Set<CrsEnttyAcctHldr> crsEnttyAcctHldr) {
		this.crsEnttyAcctHldr = crsEnttyAcctHldr;
	}

	public Set<CrsEnttyTyp> getCrsEnttyTyp() {
		return crsEnttyTyp;
	}

	public void setCrsEnttyTyp(Set<CrsEnttyTyp> crsEnttyTyp) {
		this.crsEnttyTyp = crsEnttyTyp;
	}

	public Set<CrsJrsdctn> getCrsJrsdctn() {
		return crsJrsdctn;
	}

	public void setCrsJrsdctn(Set<CrsJrsdctn> crsJrsdctn) {
		this.crsJrsdctn = crsJrsdctn;
	}

	public Set<CrsTypCntrllngPrsn> getCrsTypCntrllngPrsn() {
		return crsTypCntrllngPrsn;
	}

	public void setCrsTypCntrllngPrsn(Set<CrsTypCntrllngPrsn> crsTypCntrllngPrsn) {
		this.crsTypCntrllngPrsn = crsTypCntrllngPrsn;
	}
	
	public UUID getClntUuid() {
		return clntUuid;
	}
	
	public void setClntUuid(UUID clntUuid) {
		this.clntUuid = clntUuid;
	}
}
