package org.life.transfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 4 Aug 2021
 */
@Entity
@Table(name = "cee_member")
public class CeeMember extends BaseEntityUuid{
	private static final long serialVersionUID = 1L;

	
	@JsonIgnore
    @JoinColumn(name="ind_uuid",
				referencedColumnName="id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Individual individual;	
	
	@JsonIgnore
    @JoinColumn(name="schm_uuid",
     			referencedColumnName="id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Scheme scheme;
	
	@Column(name = "acknwldg_tc_pics_flg", 
			columnDefinition = "NUMBER(3, 0)")
	private Short acknwldgTcPicsFlg;
	
	@Column(name = "e_ntfctn_rgltry_flg", 
			columnDefinition = "NUMBER(3, 0)")
	private Short eNtfctnRgltryFlg;
	
	@Column(name = "e_ntfctn_non_rgltry_flg", 
			columnDefinition = "NUMBER(3, 0)")
	private Short eNtfctnNonRgltryFlg;
	
	@Size(max = 20)
	@Column(name = "ntr_typ_id_1",
			length = 20)
	private String ntrTypId1;
	
	@Size(max = 20)
	@Column(name = "ntr_typ_id_2",
			length = 20)
	private String ntrTypId2;
	
	@Column(name = "ind_uuid",
			insertable = false,
			updatable = false)
	private UUID indUuid;
	
	@Column(name = "schm_uuid",
			insertable = false,
			updatable = false)
	private UUID schmUuid;

	public CeeMember() {
		super();
	}

	public CeeMember(Individual individual, Scheme scheme,
			Short acknwldgTcPicsFlg, Short eNtfctnRgltryFlg, Short eNtfctnNonRgltryFlg) {
		super();
		this.individual = individual;
		this.scheme = scheme;
		this.acknwldgTcPicsFlg = acknwldgTcPicsFlg;
		this.eNtfctnRgltryFlg = eNtfctnRgltryFlg;
		this.eNtfctnNonRgltryFlg = eNtfctnNonRgltryFlg;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public Short getAcknwldgTcPicsFlg() {
		return acknwldgTcPicsFlg;
	}

	public void setAcknwldgTcPicsFlg(Short acknwldgTcPicsFlg) {
		this.acknwldgTcPicsFlg = acknwldgTcPicsFlg;
	}

	public Short geteNtfctnRgltryFlg() {
		return eNtfctnRgltryFlg;
	}

	public void seteNtfctnRgltryFlg(Short eNtfctnRgltryFlg) {
		this.eNtfctnRgltryFlg = eNtfctnRgltryFlg;
	}

	public Short geteNtfctnNonRgltryFlg() {
		return eNtfctnNonRgltryFlg;
	}

	public void seteNtfctnNonRgltryFlg(Short eNtfctnNonRgltryFlg) {
		this.eNtfctnNonRgltryFlg = eNtfctnNonRgltryFlg;
	}
	
	public String getNtrTypId1() {
		return ntrTypId1;
	}
	
	public void setNtrTypId1(String ntrTypId1) {
		this.ntrTypId1 = ntrTypId1;
	}
	
	public String getNtrTypId2() {
		return ntrTypId2;
	}
	
	public void setNtrTypId2(String ntrTypId2) {
		this.ntrTypId2 = ntrTypId2;
	}
	
	public UUID getIndUuid() {
		return indUuid;
	}
	
	public void setIndUuid(UUID indUuid) {
		this.indUuid = indUuid;
	}
	
	public UUID getSchmUuid() {
		return schmUuid;
	}
	
	public void setSchmUuid(UUID schmUuid) {
		this.schmUuid = schmUuid;
	}
}
