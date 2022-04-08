package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntityUuid;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 30 Jun 2021
 */
@Entity
@Table(name = "exit_mdl")
public class ExitMdl extends BaseEntityUuid {
	private static final long serialVersionUID = 5666052148801267581L;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exitMdl")
	private Set<CntrbRlHdr> cntrbRlHdrs;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exitMdl")
	private Set<VstngRlHdr> vstngRlHdrs;
	
	@Column(name ="EXIT_MDL_NMBR", 
			columnDefinition = "NUMBER(5, 0)")
	private Short exitMdlNmbr;
	
	@Column(name ="EXIT_MDL_TXT",
			length = 50)
	@Size(max = 50)
	private String exitMdlTxt;
	
	@Column(name = "EXIT_MDL_PRGRM_TXT",
			length = 50)
	@Size(max = 50)
	private String exitMdlPrgmTxt;
	
	@Column(name = "LST_CHG_DT")
	private Date lstChgDt;

	public ExitMdl() {
	}

	public Short getExitMdlNmbr() {
		return exitMdlNmbr;
	}

	public void setExitMdlNmbr(Short exitMdlNmbr) {
		this.exitMdlNmbr = exitMdlNmbr;
	}

	public String getExitMdlTxt() {
		return exitMdlTxt;
	}

	public void setExitMdlTxt(String exitMdlTxt) {
		this.exitMdlTxt = exitMdlTxt;
	}

	public String getExitMdlPrgmTxt() {
		return exitMdlPrgmTxt;
	}

	public void setExitMdlPrgmTxt(String exitMdlPrgmTxt) {
		this.exitMdlPrgmTxt = exitMdlPrgmTxt;
	}

	public Date getLstChgDt() {
		return lstChgDt;
	}

	public void setLstChgDt(Date lstChgDt) {
		this.lstChgDt = lstChgDt;
	}

	public Set<VstngRlHdr> getVstngRlHdrs() {
		return vstngRlHdrs;
	}

	public void setVstngRlHdrs(Set<VstngRlHdr> vstngRlHdrs) {
		this.vstngRlHdrs = vstngRlHdrs;
		for (VstngRlHdr vstngRlHdr : vstngRlHdrs)
            if (vstngRlHdr.getExitMdl()== null)
            	vstngRlHdr.setExitMdl(this);
	}

	public Set<CntrbRlHdr> getCntrbRlHdrs() {
		return cntrbRlHdrs;
	}

	public void setCntrbRlHdrs(Set<CntrbRlHdr> cntrbRlHdrs) {
		this.cntrbRlHdrs = cntrbRlHdrs;
		for (CntrbRlHdr cntrbRlHdr : cntrbRlHdrs)
            if (cntrbRlHdr.getExitMdl()== null)
            	cntrbRlHdr.setExitMdl(this);
	}
	
	
}
