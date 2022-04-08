package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaime
 */
@Entity
@Table(name = "SCHM_ACTY")
@DynamicInsert
@DynamicUpdate
@NamedQueries({
    @NamedQuery(name = "SchmActy.findAll", query = "SELECT s FROM SchmActy s"),
    @NamedQuery(name = "SchmActy.findOne", query = "SELECT s FROM SchmActy s where s.id = :id")})
@NamedEntityGraph(name = "getSchmTrnsRnd", 
        attributeNodes = {
            @NamedAttributeNode(value = "scheme", subgraph = "scheme-subgraph"),
            
        },
        subgraphs = {
            @NamedSubgraph(name = "scheme-subgraph", 
                    attributeNodes = {
                        @NamedAttributeNode(value = "funds")})
        })
public class SchmActy extends BaseEntityUuid {
    
    @JsonIgnore
    @JoinColumn(name = "SCHM_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Scheme scheme;
    
    @Size(max = 20)
    @Column(name = "ACTY_TYP_ID",
            length = 20)
    private String actyTypeId;
    
    @Size(max = 20)
    @Column(name = "ACTY_SUB_ID",
            length = 20)
    private String actySubId;
    
    @Size(max = 20)
    @Column(name = "UNT_RND_TXT",
            length = 20)
    private String untRndTxt;
    
    @Column(name = "UNT_RND_NMBR", 
            columnDefinition = "NUMBER(15, 2)")
    private BigDecimal untRndNmbr;
    
    @Size(max = 20)
    @Column(name = "AMT_RND_TXT",
            length = 20)
    private String amtRndTxt;
    
    @Column(name = "AMT_RND_NMBR", 
            columnDefinition = "NUMBER(15, 2)")
    private BigDecimal amtRndNmbr;
    
    @Column(name = "PRCSS_SEQ_NMBR", 
            columnDefinition = "NUMBER(5, 0)")
    private Integer prcssSeqNmbr;
    
    @Size(max = 50)
    @Column(name = "EXTRCT_CALC_MDL",
            length = 50)
    private String extrctCalcMdl;
   
    public SchmActy() {}

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public String getActyTypeId() {
        return actyTypeId;
    }

    public void setActyTypeId(String actyTypeId) {
        this.actyTypeId = actyTypeId;
    }

    public String getActySubId() {
        return actySubId;
    }

    public void setActySubId(String actySubId) {
        this.actySubId = actySubId;
    }

    public String getUntRndTxt() {
        return untRndTxt;
    }

    public void setUntRndTxt(String untRndTxt) {
        this.untRndTxt = untRndTxt;
    }

    public String getAmtRndTxt() {
        return amtRndTxt;
    }

    public void setAmtRndTxt(String amtRndTxt) {
        this.amtRndTxt = amtRndTxt;
    }

    public Integer getPrcssSeqNmbr() {
        return prcssSeqNmbr;
    }

    public void setPrcssSeqNmbr(Integer prcssSeqNmbr) {
        this.prcssSeqNmbr = prcssSeqNmbr;
    }

	public BigDecimal getUntRndNmbr() {
		return untRndNmbr;
	}

	public void setUntRndNmbr(BigDecimal untRndNmbr) {
		this.untRndNmbr = untRndNmbr;
	}

	public BigDecimal getAmtRndNmbr() {
		return amtRndNmbr;
	}

	public void setAmtRndNmbr(BigDecimal amtRndNmbr) {
		this.amtRndNmbr = amtRndNmbr;
	}

	public String getExtrctCalcMdl() {
		return extrctCalcMdl;
	}

	public void setExtrctCalcMdl(String extrctCalcMdl) {
		this.extrctCalcMdl = extrctCalcMdl;
	}
}