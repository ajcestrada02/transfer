package org.life.transfer.entity;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;

@Entity
@Table(name = "INST_FUND")
public class InstFund extends BaseEntityUuid {

    
    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    @JoinColumn(name = "INST_TRNS_UUID",
                referencedColumnName = "id",
                nullable = false)
    private InstTrns instTrns;

    @JsonIgnore
    @OneToMany(mappedBy = "instFund")
    private Set<InvOrdrRpt> invOrdrRpts;

    @Size(max = 20)
    @Column(name = "SW_TYP_ID",
            length = 20)
    private String swTypTxt;
    
    @NotNull
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
              optional = false)
    @JoinColumn(name = "FUND_UUID",
                referencedColumnName = "id",
                nullable = false)
    private Fund fund;
    
    @Column(name = "GRS_AMT", 
            columnDefinition = "NUMBER(20, 2)")
    private BigDecimal grsAmt;
    
    @Column(name = "UNIT_CNT", 
            columnDefinition = "NUMBER(20, 6)")
    private BigDecimal unitCnt;
    
    @Column(name = "PRCNTG_RT", 
            columnDefinition = "NUMBER(5, 0)")
    private Short prcntgRt;
    
    @Column(name = "inst_trns_uuid",
			insertable = false, 
			updatable = false)
    private UUID instTrnsUuid;
    
    @Column(name = "fund_uuid",
			insertable = false, 
			updatable = false)
    private UUID fundUuid;

    public InstTrns getInstTrns() {
        return instTrns;
    }

    public Set<InvOrdrRpt> getInvOrdrRpts() {
        return invOrdrRpts;
    }

    public void setInvOrdrRpts(Set<InvOrdrRpt> invOrdrRpts) {
        this.invOrdrRpts = invOrdrRpts;
    }

    public void setInstTrns(InstTrns instTrns) {
        this.instTrns = instTrns;
    }

	public String getSwTypTxt() {
		return swTypTxt;
	}

	public void setSwTypTxt(String swTypTxt) {
		this.swTypTxt = swTypTxt;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public BigDecimal getGrsAmt() {
		return grsAmt;
	}

	public void setGrsAmt(BigDecimal grsAmt) {
		this.grsAmt = grsAmt;
	}

	public BigDecimal getUnitCnt() {
		return unitCnt;
	}

	public void setUnitCnt(BigDecimal unitCnt) {
		this.unitCnt = unitCnt;
	}

	public Short getPrcntgRt() {
		return prcntgRt;
	}

	public void setPrcntgRt(Short prcntgRt) {
		this.prcntgRt = prcntgRt;
	}
    
    public UUID getInstTrnsUuid() {
        return instTrnsUuid;
    }
    
    public void setInstTrnsUuid(UUID instTrnsUuid) {
        this.instTrnsUuid = instTrnsUuid;
    }
    
    public UUID getFundUuid() {
        return fundUuid;
    }
    
    public void setFundUuid(UUID fundUuid) {
        this.fundUuid = fundUuid;
    }
}
