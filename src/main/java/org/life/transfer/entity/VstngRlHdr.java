package org.life.transfer.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 1 Jul 2021
 */
@Entity
@Table(name = "vstng_rl_hdr")
public class VstngRlHdr extends BaseEntityUuid{
	private static final long serialVersionUID = 532220414413996323L;

	@Column(name = "VSTNG_RL_NM")
	@Size(max = 255)
	private String vstngRlNm;
	
	@Column(name = "VSTNG_RL_FRML_DSCRPTN")
	@Size(max = 255)
	private String vstngRlFrmlDscrptn;
	
	@JsonIgnore
	@JoinColumn(name = "EXIT_MDL_UUID",
				referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ExitMdl exitMdl;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vstngRlHdr")
	private Set<VstngRlCtgryRltnshp> vstngRlCtgryRltnshps;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vstngRlHdr")
	private Set<VstngSclDfltSttng> vstngSclDfltSttngs;
	
	@Column(name = "VSTNG_GRP_TXT", 
			length = 10)
	@Size(max = 10)
	private String vstngGrpTxt;
	
	public VstngRlHdr() {
	}

	public String getVstngRlNm() {
		return vstngRlNm;
	}

	public void setVstngRlNm(String vstngRlNm) {
		this.vstngRlNm = vstngRlNm;
	}

	public String getVstngRlFrmlDscrptn() {
		return vstngRlFrmlDscrptn;
	}

	public void setVstngRlFrmlDscrptn(String vstngRlFrmlDscrptn) {
		this.vstngRlFrmlDscrptn = vstngRlFrmlDscrptn;
	}

	public ExitMdl getExitMdl() {
		return exitMdl;
	}

	public void setExitMdl(ExitMdl exitMdl) {
		this.exitMdl = exitMdl;
	}

	public String getVstngGrpTxt() {
		return vstngGrpTxt;
	}

	public void setVstngGrpTxt(String vstngGrpTxt) {
		this.vstngGrpTxt = vstngGrpTxt;
	}

	public Set<VstngRlCtgryRltnshp> getVstngRlCtgryRltnshps() {
		return vstngRlCtgryRltnshps;
	}

	public void setVstngRlCtgryRltnshps(Set<VstngRlCtgryRltnshp> vstngRlCtgryRltnshps) {
		this.vstngRlCtgryRltnshps = vstngRlCtgryRltnshps;
		for (VstngRlCtgryRltnshp vstngRlCtgryRltnshp : vstngRlCtgryRltnshps)
            if (vstngRlCtgryRltnshp.getVstngRlHdr()== null)
            	vstngRlCtgryRltnshp.setVstngRlHdr(this);
	}

	public Set<VstngSclDfltSttng> getVstngSclDfltSttngs() {
		return vstngSclDfltSttngs;
	}

	public void setVstngSclDfltSttngs(Set<VstngSclDfltSttng> vstngSclDfltSttngs) {
		this.vstngSclDfltSttngs = vstngSclDfltSttngs;
		for (VstngSclDfltSttng vstngSclDfltSttng : vstngSclDfltSttngs)
            if (vstngSclDfltSttng.getVstngRlHdr()== null)
            	vstngSclDfltSttng.setVstngRlHdr(this);
	}
	
	
}
