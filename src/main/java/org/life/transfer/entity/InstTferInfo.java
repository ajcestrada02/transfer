package org.life.transfer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author Amelito Estrada Jr. <Amelito.C.EstradaJr@pccw.com>
 *
 * 26 Oct 2021
 */

@Entity
@Table(name ="inst_tfer_info")
public class InstTferInfo extends BaseEntityUuid{
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INST_UUID", 
				referencedColumnName = "id")
	private Instruction instruction;
	
	@Column(name = "TFER_OPTN_ID",length = 20)
	private String tferOptnId;
	
    @ManyToOne(	fetch = FetchType.LAZY,
            	optional = false)
    @JoinColumn(name = "TFER_TO_ENTTY_UUID",
              	referencedColumnName = "ID",
              	nullable = false)
	private ClientRelationship clientRelationship;
	
    @ManyToOne( fetch = FetchType.LAZY,
    			optional = false)
    @JoinColumn(name = "TFER_TO_SCHM_UUID",
    			referencedColumnName = "ID",
    			nullable = false)
    private Scheme scheme;
    
    @Column(name = "SEP_CS_ID")
    private String sepCsId;
    
    @Column(name = "SEP_CS_DT")
    private Date sepCsDt;
    
    @Column(name = "CNTRB_PAID_TO_DT")
    private Date cntrbPaidToDt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt; 
    
    @NotNull
    @Column(name = "EFCTV_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;

	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	public String getTferOptnId() {
		return tferOptnId;
	}

	public void setTferOptnId(String tferOptnId) {
		this.tferOptnId = tferOptnId;
	}

	public ClientRelationship getClientRelationship() {
		return clientRelationship;
	}

	public void setClientRelationship(ClientRelationship clientRelationship) {
		this.clientRelationship = clientRelationship;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public String getSepCsId() {
		return sepCsId;
	}

	public void setSepCsId(String sepCsId) {
		this.sepCsId = sepCsId;
	}

	public Date getSepCsDt() {
		return sepCsDt;
	}

	public void setSepCsDt(Date sepCsDt) {
		this.sepCsDt = sepCsDt;
	}

	public Date getCntrbPaidToDt() {
		return cntrbPaidToDt;
	}

	public void setCntrbPaidToDt(Date cntrbPaidToDt) {
		this.cntrbPaidToDt = cntrbPaidToDt;
	}

	public Date getChgDt() {
		return chgDt;
	}

	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}

	public Date getEfctvDt() {
		return efctvDt;
	}

	public void setEfctvDt(Date efctvDt) {
		this.efctvDt = efctvDt;
	}
}
