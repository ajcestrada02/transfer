package org.life.transfer.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FUND")
public class Fund extends BaseEntityUuid {
	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonIgnore
	@JoinColumn(name = "SCHM_UUID",
				referencedColumnName = "ID",
				nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Scheme scheme;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fund")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<FundPrice> fundPrices;
	
	@NotNull
	@Size(max = 150)
	@Column(name = "FUND_NM",
			nullable = false,
			unique = true, 
			length = 150)
	private String fundNm;
	
	@NotNull
	@Size(max = 150)
	@Column(name = "FUND_CHNS_NM",
			nullable = false,
			length = 150,
			unique = true)
	private String fundChnsNm;
	
	@Size(max = 20)
	@Column(name = "FUND_TYP_ID",
			length = 20)
	private String fundTypId;
	
	@Size(max = 20)
	@Column(name = "FUND_SUB_TYP_ID",
			length = 20)
	private String fundSubTypID;
	
	@Size(max = 20)
	@Column(name = "FUND_ABB_NM",
			length = 20)
	private String fundAbbNm;
	
	@Column(name = "FUND_CLSS_TYP_NM", 
			columnDefinition = "NUMBER(5, 0)")
	private Short fundClssTypNm;
	
	@Size(max = 50)
	@Column(name = "CRRNCY_TYP_NM", 
	length = 50)
	private String crrncyTypNm;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "RSK_CLSS_NM",
			nullable = false,
			length = 30)
	private String rskClssNm;
	
	@Column(name = "TERM_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date termDt;
	
	@NotNull
	@Column(name = "CMMNCMNT_DT",
			nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cmmncmntDt;
	
	@NotNull
	@Size(max = 5)
	@Column(name = "UNTZD_FLG_TXT",
			nullable = false,
			length = 5)
	private String untzdFlgTxt;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "UNT_RND_TXT",
			nullable = false,
			length = 20)
	private String untRndTxt;
	
	@NotNull
	@Column(name = "UNT_RND_NMBR",
			nullable = false, 
			columnDefinition = "NUMBER(2, 0)")
	private Short untRndNmbr;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "AMT_RND_TXT",
			nullable = false,
			length = 20)
	private String amtRndTxt;
	
	@NotNull
	@Column(name = "AMT_RND_NMBR",
			nullable = false, 
			columnDefinition = "NUMBER(2, 0)")
	private Short amtRndNmbr;
	
	@Column(name = "MPF_CNSRVTV_FUND_FLG", 
			columnDefinition = "NUMBER(3, 0)")
	private Short mpfCnsrvtvFundFlg;
	
	@Size(max = 20)
	@Column(name = "FUND_DDCTN_TYP_TXT", 
			length = 20)
	private String fundDdctnTypTxt;
	
	@Size(max = 5)
	@Column(name = "VRTN_PRICE_FLG_TXT", 
			length = 5)
	private String vrtnPriceFlgTxt;
	
	@Column(name = "RDMPTN_UNT_UPPR_LMT_CNT", 
			columnDefinition = "NUMBER(15, 6)")
	private BigDecimal rdmptnUntUpprLmtCnt;
	
	@Column(name = "FUND_PRICE_AVLBL_DT_CNT", 
			columnDefinition = "NUMBER(3, 0)")
	private Integer fundPriceAvlblDtCnt;
	
	@Column(name = "FUND_PRICE_TLRNC_RT", 
			columnDefinition = "NUMBER(15, 6)")
	private BigDecimal fundPriceTlrncRt;
	
    @Column(name = "schm_uuid",
			insertable = false, 
			updatable = false)
    private UUID schmUuid;

		public Set<FundPrice> getFundPrices() {
		return fundPrices;
	}
		public void setFundPrices(Set<FundPrice> fundPrices) {
		this.fundPrices = fundPrices;
	}
		public Scheme getScheme() {
			return scheme;
		}
		public void setScheme(Scheme scheme) {
			this.scheme = scheme;
		}
		public String getFundNm() {
			return fundNm;
		}
		public void setFundNm(String fundNm) {
			this.fundNm = fundNm;
		}
		public String getFundChnsNm() {
			return fundChnsNm;
		}
		public void setFundChnsNm(String fundChnsNm) {
			this.fundChnsNm = fundChnsNm;
		}
		public String getFundTypId() {
			return fundTypId;
		}
		public void setFundTypId(String fundTypId) {
			this.fundTypId = fundTypId;
		}
		public String getFundAbbNm() {
			return fundAbbNm;
		}
		public void setFundAbbNm(String fundAbbNm) {
			this.fundAbbNm = fundAbbNm;
		}
		public Short getFundClssTypNm() {
			return fundClssTypNm;
		}
		public void setFundClssTypNm(Short fundClssTypNm) {
			this.fundClssTypNm = fundClssTypNm;
		}
		public String getCrrncyTypNm() {
			return crrncyTypNm;
		}
		public void setCrrncyTypNm(String crrncyTypNm) {
			this.crrncyTypNm = crrncyTypNm;
		}
		public String getRskClssNm() {
			return rskClssNm;
		}
		public void setRskClssNm(String rskClssNm) {
			this.rskClssNm = rskClssNm;
		}
		public Date getTermDt() {
			return termDt;
		}
		public void setTermDt(Date termDt) {
			this.termDt = termDt;
		}
		public Date getCmmncmntDt() {
			return cmmncmntDt;
		}
		public void setCmmncmntDt(Date cmmncmntDt) {
			this.cmmncmntDt = cmmncmntDt;
		}
		public String getUntzdFlgTxt() {
			return untzdFlgTxt;
		}
		public void setUntzdFlgTxt(String untzdFlgTxt) {
			this.untzdFlgTxt = untzdFlgTxt;
		}
		public String getUntRndTxt() {
			return untRndTxt;
		}
		public void setUntRndTxt(String untRndTxt) {
			this.untRndTxt = untRndTxt;
		}
		public Short getUntRndNmbr() {
			return untRndNmbr;
		}
		public void setUntRndNmbr(Short untRndNmbr) {
			this.untRndNmbr = untRndNmbr;
		}
		public String getAmtRndTxt() {
			return amtRndTxt;
		}
		public void setAmtRndTxt(String amtRndTxt) {
			this.amtRndTxt = amtRndTxt;
		}
		public Short getAmtRndNmbr() {
			return amtRndNmbr;
		}
		public void setAmtRndNmbr(Short amtRndNmbr) {
			this.amtRndNmbr = amtRndNmbr;
		}
		public Short getMpfCnsrvtvFundFlg() {
			return mpfCnsrvtvFundFlg;
		}
		public void setMpfCnsrvtvFundFlg(Short mpfCnsrvtvFundFlg) {
			this.mpfCnsrvtvFundFlg = mpfCnsrvtvFundFlg;
		}
		public String getFundDdctnTypTxt() {
			return fundDdctnTypTxt;
		}
		public void setFundDdctnTypTxt(String fundDdctnTypTxt) {
			this.fundDdctnTypTxt = fundDdctnTypTxt;
		}
		public String getVrtnPriceFlgTxt() {
			return vrtnPriceFlgTxt;
		}
		public void setVrtnPriceFlgTxt(String vrtnPriceFlgTxt) {
			this.vrtnPriceFlgTxt = vrtnPriceFlgTxt;
		}
		public BigDecimal getRdmptnUntUpprLmtCnt() {
			return rdmptnUntUpprLmtCnt;
		}
		public void setRdmptnUntUpprLmtCnt(BigDecimal rdmptnUntUpprLmtCnt) {
			this.rdmptnUntUpprLmtCnt = rdmptnUntUpprLmtCnt;
		}
	  public Integer getFundPriceAvlblDtCnt() {
			return this.fundPriceAvlblDtCnt;
		}
		public void setFundPriceAvlblDtCnt(Integer fundPriceAvlblDtCnt) {
			this.fundPriceAvlblDtCnt = fundPriceAvlblDtCnt;
		}
	
	public String getFundSubTypID() {
		return fundSubTypID;
	}
	
	public void setFundSubTypID(String fundSubTypID) {
		this.fundSubTypID = fundSubTypID;
	}
	
	public BigDecimal getFundPriceTlrncRt() {
		return fundPriceTlrncRt;
	}
	
	public void setFundPriceTlrncRt(BigDecimal fundPriceTlrncRt) {
		this.fundPriceTlrncRt = fundPriceTlrncRt;
	}
	
	public UUID getSchmUuid() {
		return schmUuid;
	}
	
	public void setSchmUuid(UUID schmUuid) {
		this.schmUuid = schmUuid;
	}
}
