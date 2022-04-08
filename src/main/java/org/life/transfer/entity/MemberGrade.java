package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.FetchType;

/**
*
* @author Ronald Carlo De Los Reyes <ronaldcarlob.delosreyes@pccw.com>
*/
@Entity
@Table(name = "MEMBER_GRADE")
public class MemberGrade extends BaseEntityUuid {

	private static final long serialVersionUID = 7796385166911673290L;
	
	@NotNull
	@JsonIgnore
    @JoinColumn(name = "MBR_UUID",
				referencedColumnName = "ID",
				nullable = false)
    @ManyToOne(optional = false,
			   fetch = FetchType.LAZY)
    private ClientRelationship clientRelationship;
	
	@NotNull
	@JsonIgnore
    @JoinColumn(name = "er_grd_uuid",
				referencedColumnName = "id",
				nullable = false)
    @ManyToOne(optional = false,
			   fetch = FetchType.LAZY)
	private EmployerGrade employerGrade;
	
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
	
	@Column(name = "mbr_uuid",
			insertable = false, 
			updatable = false)
	private UUID mbrUuid;
	
	@Column(name = "er_grd_uuid",
			insertable = false,
			updatable = false)
	private UUID erGrdUuid;
	
	public EmployerGrade getEmployerGrade() {
		return employerGrade;
	}

	public void setEmployerGrade(EmployerGrade employerGrade) {
		this.employerGrade = employerGrade;
	}
	public ClientRelationship getClientRelationship() {
		return clientRelationship;
	}

	public void setClientRelationship(ClientRelationship clientRelationship) {
		this.clientRelationship = clientRelationship;
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
	
	public UUID getMbrUuid() {
		return mbrUuid;
	}
	
	public void setMbrUuid(UUID mbrUuid) {
		this.mbrUuid = mbrUuid;
	}
	
	public UUID getErGrdUuid() {
		return erGrdUuid;
	}
	
	public void setErGrdUuid(UUID erGrdUuid) {
		this.erGrdUuid = erGrdUuid;
	}
}
