package org.life.transfer.entity;
/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 30 Sep 2021
 */

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "schm_cntrb_typ")
public class SchemeCntrbTyp extends BaseEntityUuid{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "schm_uuid", referencedColumnName = "ID",nullable = false)
	private Scheme scheme;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cntrb_typ_id", referencedColumnName = "cntrb_typ_id", nullable = false)
	private ContributionTyp cntrbTyps;
	
	@Column(name = "tfer_out_lmt_cnt",
			columnDefinition = "NUMBER(3, 0)")
	private Integer tferOutLmtCnt;

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public ContributionTyp getCntrbTyps() {
		return cntrbTyps;
	}

	public void setCntrbTyps(ContributionTyp cntrbTyps) {
		this.cntrbTyps = cntrbTyps;
	}

	public Integer getTferOutLmtCnt() {
		return tferOutLmtCnt;
	}

	public void setTferOutLmtCnt(Integer tferOutLmtCnt) {
		this.tferOutLmtCnt = tferOutLmtCnt;
	}
	
}
