/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Date;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToOne;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "CLIENT_RLTNSHP")
public class ClientRelationship extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @Column(name = "entty_cd", 
            columnDefinition = "NUMBER(15, 0)")
    private Long enttyCd;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private List<AccntBlnc> accntBlncs;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<ClientBank> clientBanks;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<Instruction> instructions;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<PayrollGroup> payrollGroup;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "prty")
    private Set<ClientRelationship> prtys;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<MemberGrade> memberGrades;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<ErContributionTyp> erConntributionTyps;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<EntityAgent> entityAgents;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "clientRelationship")
    private Set<MemberCustomContribution> memberCustomContributions;
	
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "clientRelationship")
    private Set<InstTferInfo> instTferInfos;
    
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
			mappedBy = "memberPK.clientRelationship", fetch = FetchType.LAZY)
	private Member member;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "er_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Employer employer;

    @JsonIgnore
    @JoinColumn(name = "brnch_uuid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;

    @JsonIgnore
    @JoinColumn(name = "clnt_uuid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @JsonIgnore
    @JoinColumn(name = "clnt_uuid",
                referencedColumnName = "id", 
                insertable = false, 
                updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @JsonIgnore
    @JoinColumn(name = "prty_uuid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientRelationship prty;

    @Size(max = 20)
    @Column(name = "clnt_typ_id",
            length = 20)
    private String clntTypId;

	@NotNull
	@JsonIgnore
    @JoinColumn(name = "schm_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Scheme scheme;

	@NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt; 
    
    @NotNull
    @Column(name = "chg_dt",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;
    
    @Column(name = "PRTY_UUID",
            insertable = false,
            updatable = false)
    private UUID partyUuid;
    

    @Column(name = "schm_uuid",
            insertable = false,
            updatable = false)
    private UUID schmUuid;

    @Column(name = "er_uuid",
            insertable = false,
            updatable = false)
    private UUID erUuid;

    @Column(name = "clnt_uuid",
            insertable = false,
            updatable = false)
    private UUID clntUuid;
    
    @Column(name = "brnch_uuid",
            insertable = false,
            updatable = false)
    private UUID brnchUuid; 
    
    public List<AccntBlnc> getAccntBlncs() {
        return accntBlncs;
    }

    public void setAccntBlncs(List<AccntBlnc> accntBlncs) {
        this.accntBlncs = accntBlncs;
        if (accntBlncs != null) {
            accntBlncs.stream().filter(accntBlnc -> (accntBlnc.getClientRelationship() == null)).forEachOrdered(accntBlnc -> {
                accntBlnc.setClientRelationship(this);
            });
        }
    }

    public Set<ClientBank> getClientBanks() {
        return clientBanks;
    }

    public void setClientBanks(Set<ClientBank> clientBanks) {
        this.clientBanks = clientBanks;
        if (clientBanks != null) {
            clientBanks.stream().filter(clientBank -> (clientBank.getClientRelationship() == null)).forEachOrdered(clientBank -> {
                clientBank.setClientRelationship(this);
            });
        }
    }

    public Set<MemberGrade> getMemberGrades() {
        return memberGrades;
    }

    public void setMemberGrades(Set<MemberGrade> memberGrades) {
        this.memberGrades = memberGrades;
        if (memberGrades != null) {
            memberGrades.stream().filter(memberGrade -> (memberGrade.getClientRelationship() == null)).forEachOrdered(memberGrade -> {
                memberGrade.setClientRelationship(this);
            });
        }
    }

    public Set<EntityAgent> getEntityAgents() {
        return entityAgents;
    }

    public void setEntityAgents(Set<EntityAgent> entityAgents) {
        this.entityAgents = entityAgents;
        if (entityAgents != null) {
            entityAgents.stream()
                    .filter(entityAgent -> (entityAgent.getClientRelationship() == null))
                    .forEachOrdered(entityAgent -> entityAgent.setClientRelationship(this));
        }
    }

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		if (member.getMemberPK().getClientRelationship() == null) {
			member.getMemberPK().setClientRelationship(this);
		}
		this.member = member;
	}

    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Instruction> instructions) {
        this.instructions = instructions;

        for (Instruction instruction : instructions)
            if (instruction.getClientRelationship() == null)
                instruction.setClientRelationship(this);
    }

	public Set<ErContributionTyp> getErConntributionTyps() {
		return erConntributionTyps;
	}

	public void setErConntributionTyps(Set<ErContributionTyp> erConntributionTyps) {
		this.erConntributionTyps = erConntributionTyps;
		if (erConntributionTyps != null) {
			erConntributionTyps.stream().filter(erConntributionTyp -> (erConntributionTyp.getClientRelationship() == null)).forEachOrdered(erConntributionTyp -> {
				erConntributionTyp.setClientRelationship(this);
            });
        }
	}

    public Set<MemberCustomContribution> getMemberCustomContributions() {
		return memberCustomContributions;
	}

	public void setMemberCustomContributions(Set<MemberCustomContribution> memberCustomContributions) {
		this.memberCustomContributions = memberCustomContributions;

        for (MemberCustomContribution mbrcstmcntrb : memberCustomContributions)
            if (mbrcstmcntrb.getClientRelationship() == null)
            	mbrcstmcntrb.setClientRelationship(this);
	}

    public Employer getEmployer() {
        return employer;
    }
    
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    
    public Long getEnttyCd() {
        return enttyCd;
    }

    public void setEnttyCd(Long enttyCd) {
        this.enttyCd = enttyCd;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
        if (this.brnchUuid == null && branch != null) {
        	this.brnchUuid = branch.getId();
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        if (this.clntUuid == null && client != null) {
        	this.clntUuid = client.getId();
        }
    }

    public String getClntTypId() {
        return clntTypId;
    }

    public void setClntTypId(String clntTypId) {
        this.clntTypId = clntTypId;
    }

    public Scheme getScheme() {
        return scheme;
    }
    
    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }
    
    public Date getEfctvDt() {
        return efctvDt;
    }

    public void setEfctvDt(Date efctvDt) {
        this.efctvDt = efctvDt;
    }
    
    public Set<PayrollGroup> getPayrollGroup() {
        return payrollGroup;
    }
    
    public void setPayrollGroup(Set<PayrollGroup> payrollGroups) {
        this.payrollGroup = payrollGroups;
    }
    
    public Set<ClientRelationship> getPrtys() {
        return prtys;
    }
    
    public void setPrtys(Set<ClientRelationship> prtys) {
        this.prtys = prtys;
    }
    
    public UUID getPartyUuid() {
		return partyUuid;
	}

	public void setPartyUuid(UUID partyUuid) {
		this.partyUuid = partyUuid;
	}

	public ClientRelationship getPrty() {
        return prty;
    }

    public void setPrty(ClientRelationship prty) {
        this.prty = prty;
    }
    
    public Date getChgDt() {
        return chgDt;
    }
    
    public void setChgDt(Date chgDt) {
        this.chgDt = chgDt;
    }

	public UUID getBrnchUuid() {
		return brnchUuid;
	}

	public void setBrnchUuid(UUID brnchUuid) {
		this.brnchUuid = brnchUuid;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public UUID getSchmUuid() {
		return schmUuid;
	}

	public void setSchmUuid(UUID schmUuid) {
		this.schmUuid = schmUuid;
	}

	public UUID getErUuid() {
		return erUuid;
	}

	public void setErUuid(UUID erUuid) {
		this.erUuid = erUuid;
	}

	public UUID getClntUuid() {
		return clntUuid;
	}

	public void setClntUuid(UUID clntUuid) {
		this.clntUuid = clntUuid;
	}

	public Set<InstTferInfo> getInstTferInfos() {
		return instTferInfos;
	}

	public void setInstTferInfos(Set<InstTferInfo> instTferInfos) {
		this.instTferInfos = instTferInfos;
	}
}
