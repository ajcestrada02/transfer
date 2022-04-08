package org.life.transfer.entity;

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

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 30 Jun 2021
 */

@Entity
@Table(name = "category_typ")
@DynamicInsert
@DynamicUpdate
public class CategoryTyp extends BaseEntityUuid {
	private static final long serialVersionUID = -413934320346303544L;
	
	@Column(name = "CTGRY_TYP_NM",
			length = 50)
	@Size(max = 50)
	private String ctgryTypNm;
	
	@Column(name = "CTGRY_ABB_NM",
			length = 10)
	@Size(max = 10)
	private String ctgryAbbNm;
	
	@Column(name = "USED_BY_PYRLL_GRP", 
			columnDefinition = "NUMBER(3, 0)")
	private Short usedByPrllGrp;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "categoryTyp")
	private Set<CntrbRlCtgryRltnshp> cntrbRlCtgryRltnshps;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryTyp")
	private Set<VstngRlCtgryRltnshp> vstngRlCtgryRltnshps;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryTyp")
	private Set<VstngSclDfltSttng> vstngSclDfltSttngs;
	
	public CategoryTyp() {
	}

	public String getCtgryTypNm() {
		return ctgryTypNm;
	}

	public void setCtgryTypNm(String ctgryTypNm) {
		this.ctgryTypNm = ctgryTypNm;
	}

	public String getCtgryAbbNm() {
		return ctgryAbbNm;
	}

	public void setCtgryAbbNm(String ctgryAbbNm) {
		this.ctgryAbbNm = ctgryAbbNm;
	}

	public Short getUsedByPrllGrp() {
		return usedByPrllGrp;
	}

	public void setUsedByPrllGrp(Short usedByPrllGrp) {
		this.usedByPrllGrp = usedByPrllGrp;
	}

	public Set<CntrbRlCtgryRltnshp> getCntrbRlCtgryRltnshps() {
		return cntrbRlCtgryRltnshps;
	}

	public void setCntrbRlCtgryRltnshps(Set<CntrbRlCtgryRltnshp> cntrbRlCtgryRltnshps) {
		this.cntrbRlCtgryRltnshps = cntrbRlCtgryRltnshps;
		for (CntrbRlCtgryRltnshp cntrbRlCtgryRltnshp : cntrbRlCtgryRltnshps)
            if (cntrbRlCtgryRltnshp.getCategoryTyp()== null)
            	cntrbRlCtgryRltnshp.setCategoryTyp(this);
	}

	public Set<VstngRlCtgryRltnshp> getVstngRlCtgryRltnshps() {
		return vstngRlCtgryRltnshps;
	}

	public void setVstngRlCtgryRltnshps(Set<VstngRlCtgryRltnshp> vstngRlCtgryRltnshps) {
		this.vstngRlCtgryRltnshps = vstngRlCtgryRltnshps;
		for (VstngRlCtgryRltnshp vstngRlCtgryRltnshp : vstngRlCtgryRltnshps)
            if (vstngRlCtgryRltnshp.getCategoryTyp()== null)
            	vstngRlCtgryRltnshp.setCategoryTyp(this);
	}

	public Set<VstngSclDfltSttng> getVstngSclDfltSttngs() {
		return vstngSclDfltSttngs;
	}

	public void setVstngSclDfltSttngs(Set<VstngSclDfltSttng> vstngSclDfltSttngs) {
		this.vstngSclDfltSttngs = vstngSclDfltSttngs;
		for (VstngSclDfltSttng vstngSclDfltSttng : vstngSclDfltSttngs)
            if (vstngSclDfltSttng.getCategoryTyp()== null)
            	vstngSclDfltSttng.setCategoryTyp(this);
	}

}
