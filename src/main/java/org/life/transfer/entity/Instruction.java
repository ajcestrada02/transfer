package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntityUuid;

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
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "INSTRUCTION")
public class Instruction extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "ENTTY_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private ClientRelationship clientRelationship;

    @JsonIgnore
    @JoinColumn(name = "INST_GRP_UUID", referencedColumnName = "ID")
    @OneToOne(cascade = CascadeType.ALL)
    private InstGrp instGrp;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instruction")
    private InstTerm instTerm;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instruction")
    private InstRsn instRsn;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instruction")
    private Set<InstTrns> instTrnses;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instruction")
    private Set<InstVcMember> instVcMembers;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
              mappedBy = "instruction")
    private InstTferInfo instTferInfos;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instruction")
    private InstSspns instSspns;
    
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instruction")
    private Set<ExcptnHst> excptnHst;
    
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

    @Size(max = 20)
    @Column(name = "STTS_TYP_ID",
            length = 20)
    private String sttsTypId;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "REF_NO_TXT",
            unique = true,
            nullable = false,
            length = 50)
    private String refNoTxt;

    @Column(name = "CNCL_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cnclDt;

    @Column(name = "PRCSS_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prcssDt;
    
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

    @Column(name = "ORGNL_RQST_SBMSSN_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgnlRqstSbmssnDt;
    
    @Column(name = "ENTTY_UUID",
			insertable = false, 
			updatable = false)
    private UUID enttyUuid;
    
	public Instruction() {

    }

    public Set<InstVcMember> getInstVcMembers() {
        return instVcMembers;
    }

    public void setInstVcMembers(Set<InstVcMember> instVcMembers) {
        this.instVcMembers = instVcMembers;
    }

    public InstTerm getInstTerm() {
        return instTerm;
    }

    public void setInstTerm(InstTerm instTerm) {
        this.instTerm = instTerm;
        if (instTerm != null) {
            instTerm.setInstruction(this);
        }
    }

    public InstRsn getInstRsn() {
        return instRsn;
    }

    public void setInstRsn(InstRsn instRsn) {
        this.instRsn = instRsn;

        if (instRsn != null) {
            instRsn.setInstruction(this);
        }
    }

    public Set<InstTrns> getInstTrnses() {
        return instTrnses;
    }

    public void setInstTrnses(Set<InstTrns> instTrnses) {
        this.instTrnses = instTrnses;
        if (instTrnses != null) {
            instTrnses.forEach(instTrns -> {
                instTrns.setInstruction(this);
            });
        }
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

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }

    public String getRefNoTxt() {
        return refNoTxt;
    }

    public void setRefNoTxt(String refNoTxt) {
        this.refNoTxt = refNoTxt;
    }

    public Date getCnclDt() {
        return cnclDt;
    }

    public void setCnclDt(Date cnclDt) {
        this.cnclDt = cnclDt;
    }

    public Date getPrcssDt() {
        return prcssDt;
    }

    public void setPrcssDt(Date prcssDt) {
        this.prcssDt = prcssDt;
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

    public InstSspns getInstSspns() {
        return instSspns;
    }

    public void setInstSspns(InstSspns instSspns) {
        this.instSspns = instSspns;
    }

    public Set<ExcptnHst> getExcptnHst() {
        return excptnHst;
    }

    public void setExcptnHst(Set<ExcptnHst> excptnHst) {
        this.excptnHst = excptnHst;
    }
    
    public Date getOrgnlRqstSbmssnDt() {
        return orgnlRqstSbmssnDt;
    }

    public void setOrgnlRqstSbmssnDt(Date orgnlRqstSbmssnDt) {
        this.orgnlRqstSbmssnDt = orgnlRqstSbmssnDt;
    }

	public InstGrp getInstGrp() {
		return instGrp;
	}

	public void setInstGrp(InstGrp instGrp) {
		this.instGrp = instGrp;
	}

    public UUID getEnttyUuid() {
        return enttyUuid;
    }
    
    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }

	public InstTferInfo getInstTferInfos() {
		return instTferInfos;
	}

	public void setInstTferInfos(InstTferInfo instTferInfos) {
		this.instTferInfos = instTferInfos;
	}
}
