package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntityUuid;

@Entity
@Table(name = "BANK")
public class Bank extends BaseEntityUuid{
	
	
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Set<ClientBank> clientBanks;
	
	@Size(max = 100)
	@Column(name = "BNK_NM",
			length = 100)
	private String bnkNm;
	
	@Size(max = 100)
	@Column(name = "BNK_CHNS_NM",
			length = 100)
	private String bnkChnsNm;
	
	@Size(max = 50)
	@Column(name = "BNK_EXT_CD",
			length = 50)
	private String bnkExtCd;
	
	@Size(max = 50)
	@Column(name = "BRNCH_EXT_CD",
			length = 50)
	private String brnchExtCd;
	
	@Column(name = "SWFT_CD",
			columnDefinition = "NUMBER(10, 0)")
	private Long swftCd;
	
	@Size(max = 30)
	@Column(name = "IBAN_TXT",
			length = 30)
	private String ibanTxt;
	
	@Size(max = 30)
	@Column(name = "CRRNCY_TYP_NM",
			length = 30)
	private String crrncyTypNm;
    
    @NotNull
	@Column(name = "EFCTV_DT",
			nullable = false)
    private Date efctvDt;
    
    @NotNull
	@Column(name = "CHG_DT",
			nullable = false)
    private Date chgDt;
    
    public Bank() {
        super();
    }

    public Set<ClientBank> getClientBanks(){
    	return clientBanks;
    }
    
    public void setClientBanks(Set<ClientBank> clientBanks) {
    	this.clientBanks = clientBanks;
    }
    
	public String getBnkNm() {
		return bnkNm;
	}

	public void setBnkNm(String bnkNm) {
		this.bnkNm = bnkNm;
	}

	public String getBnkChnsNm() {
		return bnkChnsNm;
	}

	public void setBnkChnsNm(String bnkChnsNm) {
		this.bnkChnsNm = bnkChnsNm;
	}

	public String getBnkExtCd() {
		return bnkExtCd;
	}

	public void setBnkExtCd(String bnkExtCd) {
		this.bnkExtCd = bnkExtCd;
	}

	public String getBrnchExtCd() {
		return brnchExtCd;
	}

	public void setBrnchExtCd(String brnchExtCd) {
		this.brnchExtCd = brnchExtCd;
	}

	public Long getSwftCd() {
		return swftCd;
	}

	public void setSwftCd(Long swftCd) {
		this.swftCd = swftCd;
	}

	public String getIbanTxt() {
		return ibanTxt;
	}

	public void setIbanTxt(String ibanTxt) {
		this.ibanTxt = ibanTxt;
	}

	public String getCrrncyTypNm() {
		return crrncyTypNm;
	}

	public void setCrrncyTypNm(String crrncyTypNm) {
		this.crrncyTypNm = crrncyTypNm;
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
    
    
    
}
