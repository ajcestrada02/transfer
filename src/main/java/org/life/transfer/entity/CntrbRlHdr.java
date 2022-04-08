package org.life.transfer.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntityUuid;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 30 Jun 2021
 */

@Entity
@Table(name = "cntrb_rl_hdr")
public class CntrbRlHdr extends BaseEntityUuid{
	private static final long serialVersionUID = 4065024352599347392L;

	@Column(name = "CNTRB_RL_NM")
	@Size(max = 255)
	private String cntrbRlNm;
	
	@Column(name = "CNTRB_RL_FRML_DSCRPTN")
	@Size(max = 255)
	private String cntrbRlFrmlDesc;
	
	@Column(name = "CNTRB_RL_CTGRY",
			length = 50)
	@Size(max = 50)
	private String cntrbRlCtgry;
	
	@JsonIgnore
	@JoinColumn( name = "EXIT_MDL_UUID", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ExitMdl exitMdl;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cntrbRlHdr")
	private Set<CntrbRlCtgryRltnshp> cntrbRlCtgryRltnshps;
	
	@Column(name = "CNTRB_GRP",
			length = 10)
	@Size(max = 10)
	private String cntrbGrp;
	
	@Column(name = "exit_mdl_uuid",
			insertable = false,
			updatable = false)
	private UUID exitMdlUuid;

	public CntrbRlHdr() {
	}

	public String getCntrbRlNm() {
		return cntrbRlNm;
	}


	public void setCntrbRlNm(String cntrbRlNm) {
		this.cntrbRlNm = cntrbRlNm;
	}


	public String getCntrbRlFrmlDesc() {
		return cntrbRlFrmlDesc;
	}


	public void setCntrbRlFrmlDesc(String cntrbRlFrmlDesc) {
		this.cntrbRlFrmlDesc = cntrbRlFrmlDesc;
	}


	public String getCntrbRlCtgry() {
		return cntrbRlCtgry;
	}


	public void setCntrbRlCtgry(String cntrbRlCtgry) {
		this.cntrbRlCtgry = cntrbRlCtgry;
	}


	public String getCntrbGrp() {
		return cntrbGrp;
	}


	public void setCntrbGrp(String cntrbGrp) {
		this.cntrbGrp = cntrbGrp;
	}


	public ExitMdl getExitMdl() {
		return exitMdl;
	}


	public void setExitMdl(ExitMdl exitMdl) {
		this.exitMdl = exitMdl;
	}


	public Set<CntrbRlCtgryRltnshp> getCntrbRlCtgryRltnshps() {
		return cntrbRlCtgryRltnshps;
	}


	public void setCntrbRlCtgryRltnshps(Set<CntrbRlCtgryRltnshp> cntrbRlCtgryRltnshps) {
		this.cntrbRlCtgryRltnshps = cntrbRlCtgryRltnshps;
	}
	
	public UUID getExitMdlUuid() {
		return exitMdlUuid;
	}
	
	public void setExitMdlUuid(UUID exitMdlUuid) {
		this.exitMdlUuid = exitMdlUuid;
	}
}
