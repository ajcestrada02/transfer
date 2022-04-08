package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 *
 * @author Ronald Carlo De Los Reyes <ronaldcarlob.delosreyes@pccw.com>
 */
@Entity
@Table(name = "ER_GRADE")
public class EmployerGrade extends BaseEntityUuid {

    private static final long serialVersionUID = -4749398749859940142L;
    
    /**
     *  {@link ClientRelationship} primary ID is 
     *  identical to Employer Primary ID, so we can use 
     *  {@link Employer} entity as Parent Entity
     */
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "er_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employer employer;

    @Size(max = 50)
    @Column(name = "ER_GRD_TXT", 
            length = 50)
    private String erGrdTxt;
    
    @Column(name = "SSPNS_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Short sspnsFlg;
    
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

    @Column(name = "DFLT_GRD_FLG", 
            columnDefinition = "NUMBER(3, 0)")
    private Long dfltGrdFlg;
    
    @Column(name = "er_uuid",
			insertable = false, 
			updatable = false)
    private UUID erUuid;

    public Employer getEmployer() {
        return employer;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Long getDfltGrdFlg() {
        return dfltGrdFlg;
    }

    public void setDfltGrdFlg(Long dfltGrdFlg) {
        this.dfltGrdFlg = dfltGrdFlg;
    }

    public String getErGrdTxt() {
        return erGrdTxt;
    }

    public void setErGrdTxt(String erGrdTxt) {
        this.erGrdTxt = erGrdTxt;
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

	public Short getSspnsFlg() {
		return sspnsFlg;
	}

	public void setSspnsFlg(Short sspnsFlg) {
		this.sspnsFlg = sspnsFlg;
	}
    
    public UUID getErUuid() {
        return erUuid;
    }
    
    public void setErUuid(UUID erUuid) {
        this.erUuid = erUuid;
    }
}
