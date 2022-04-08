package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ER_GRD_CNTRB_TYP_RLTNSHP")
public class ErGrdCntrbTypRltnshp extends BaseEntityUuid {

    @JsonIgnore
    @JoinColumn(name = "ER_GRD_UUID",
                referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmployerGrade employerGrade;

    @JsonIgnore
    @JoinColumn(name = "CNTRB_RL_HDR_UUID", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CntrbRlHdr cntrbRlHdr;

    @JsonIgnore
    @JoinColumn(name = "VSTNG_RL_HDR_UUID", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private VstngRlHdr vstngRlHdr;
    
    @Column(name = "ER_GRD_UUID",
            insertable = false,
            updatable = false)
	private UUID erGradeUuid; 
	
	@Column(name = "cntrb_rl_hdr_uuid",
            insertable = false,
            updatable = false)
	private UUID cntrbRlHdrUuid;
	
	@Column(name = "vstng_rl_hdr_uuid",
            insertable = false,
            updatable = false)
	private UUID vstngRlHdrUuid;

    @Size(max = 20)
    @Column(name = "CNTRB_TYP_ID",
            length = 20)
    private String cntrbTypId;
    
    @Column(name = "sspnsn_flg",
            columnDefinition = "NUMBER(3, 0)")
    private Long sspnsFlg;
    
    @Size(max = 20)
    @Column(name = "VC_INCM_DFN_ID",
            length = 20)
    private String vcIncmDfnId;
    
    @Size(max = 20)
    @Column(name = "VC_SRVC_DFN_ID",
            length = 20)
    private String vcSrvcDfnId;
    
    @Size(max = 20)
    @Column(name = "VC_JOIN_DT_ID",
            length = 20)
    private String vcJoinDtId;
    
    @Size(max = 4)
    @Column(name = "X_VC_JOIN_DT_NMBR",
            columnDefinition = "Number(4)")
    private Long xVcJoinDtNmbr;
    
    @Column(name = "VC_JOIN_SPCFY_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vcJoinSpcfyDt;
    
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

    public ErGrdCntrbTypRltnshp() {
    }

    public EmployerGrade getEmployerGrade() {
        return employerGrade;
    }

    public void setEmployerGrade(EmployerGrade employerGrade) {
        this.employerGrade = employerGrade;
    }

    public CntrbRlHdr getCntrbRlHdr() {
        return cntrbRlHdr;
    }

    public void setCntrbRlHdr(CntrbRlHdr cntrbRlHdr) {
        this.cntrbRlHdr = cntrbRlHdr;
    }

    public VstngRlHdr getVstngRlHdr() {
        return vstngRlHdr;
    }

    public void setVstngRlHdr(VstngRlHdr vstngRlHdr) {
        this.vstngRlHdr = vstngRlHdr;
    }

    public String getCntrbTypId() {
        return cntrbTypId;
    }

    public void setCntrbTypId(String cntrbTypId) {
        this.cntrbTypId = cntrbTypId;
    }

    public Long getSspnsFlg() {
        return sspnsFlg;
    }

    public void setSspnsFlg(Long sspnsFlg) {
        this.sspnsFlg = sspnsFlg;
    }

    public String getVcIncmDfnId() {
        return vcIncmDfnId;
    }

    public void setVcIncmDfnId(String vcIncmDfnId) {
        this.vcIncmDfnId = vcIncmDfnId;
    }

    public String getVcSrvcDfnId() {
        return vcSrvcDfnId;
    }

    public void setVcSrvcDfnId(String vcSrvcDfnId) {
        this.vcSrvcDfnId = vcSrvcDfnId;
    }

    public String getVcJoinDtId() {
        return vcJoinDtId;
    }

    public void setVcJoinDtId(String vcJoinDtId) {
        this.vcJoinDtId = vcJoinDtId;
    }

    public Long getxVcJoinDtNmbr() {
        return xVcJoinDtNmbr;
    }

    public void setxVcJoinDtNmbr(Long xVcJoinDtNmbr) {
        this.xVcJoinDtNmbr = xVcJoinDtNmbr;
    }

    public Date getVcJoinSpcfyDt() {
        return vcJoinSpcfyDt;
    }

    public void setVcJoinSpcfyDt(Date vcJoinSpcfyDt) {
        this.vcJoinSpcfyDt = vcJoinSpcfyDt;
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

	public UUID getErGradeUuid() {
		return erGradeUuid;
	}

	public void setErGradeUuid(UUID erGradeUuid) {
		this.erGradeUuid = erGradeUuid;
	}
    
    public UUID getCntrbRlHdrUuid() {
        return cntrbRlHdrUuid;
    }
    
    public void setCntrbRlHdrUuid(UUID cntrbRlHdrUuid) {
        this.cntrbRlHdrUuid = cntrbRlHdrUuid;
    }
    
    public UUID getVstngRlHdrUuid() {
        return vstngRlHdrUuid;
    }
    
    public void setVstngRlHdrUuid(UUID vstngRlHdrUuid) {
        this.vstngRlHdrUuid = vstngRlHdrUuid;
    }
}
