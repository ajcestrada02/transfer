package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;

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
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Arbe Padilla <ArbeJorgeA.Padilla@pccw.com>
 */
@Entity
@Table(name = "CMPNY_RLTD_PRSN")
public class CmpnyRltdPrsn extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CLNT_UUID",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Client client;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CMPNY_UUID",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY)
    private Company company;

    @NotNull
    @Size(max = 20)
    @Column(name = "CMPNY_PRSN_TYP_ID",
            nullable = false,
            length = 20)
    private String cmpnyPrsnTypId;

    @JsonIgnore
    @JoinColumn(name = "SCHM_UUID", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Scheme scheme;
    
    @Size(max = 200)
    @Column(name = "JB_PSTN_TXT", 
            length = 200)
    private String jbPstnTxt;

    @Column(name = "KY_RL_CD", 
            columnDefinition = "NUMBER(5, 0)")
    private Long kyRlCd;

    @Column(name = "OWNRSHP_PRCNTG_CNT", 
            columnDefinition = "NUMBER(10, 2)")
    private BigDecimal ownrshpPrcntgCnt;

    @NotNull
    @Column(name = "EFCTV_DT", 
            nullable = false)
    private Date efctvDt;
    
    @NotNull
    @UpdateTimestamp
    @Column(name = "CHG_DT", 
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;

    @Size(max = 20)
    @Column(name = "STTS_TYP_ID", 
            length = 20)
    private String sttsTypId;
    
    @Column(name = "clnt_uuid",
			insertable = false, 
			updatable = false)
    private UUID clntUuid;
    
    @Column(name = "cmpny_uuid",
			insertable = false, 
			updatable = false)
    private UUID cmpnyUiid;
    
    @Column(name = "schm_uuid",
			insertable = false, 
			updatable = false)
    private UUID schmUuid;
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCmpnyPrsnTypId() {
        return cmpnyPrsnTypId;
    }

    public void setCmpnyPrsnTypId(String cmpnyPrsnTypId) {
        this.cmpnyPrsnTypId = cmpnyPrsnTypId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getJbPstnTxt() {
        return jbPstnTxt;
    }

    public void setJbPstnTxt(String jbPstnTxt) {
        this.jbPstnTxt = jbPstnTxt;
    }

    public Long getKyRlCd() {
        return kyRlCd;
    }

    public void setKyRlCd(Long kyRlCd) {
        this.kyRlCd = kyRlCd;
    }

    public BigDecimal getOwnrshpPrcntgCnt() {
        return ownrshpPrcntgCnt;
    }

    public void setOwnrshpPrcntgCnt(BigDecimal ownrshpPrcntgCnt) {
        this.ownrshpPrcntgCnt = ownrshpPrcntgCnt;
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

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }
    
    public String getSttsTypId() {
        return sttsTypId;
    }
    
    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }
    
    public UUID getClntUuid() {
        return clntUuid;
    }
    
    public void setClntUuid(UUID clntUuid) {
        this.clntUuid = clntUuid;
    }
    
    public UUID getCmpnyUiid() {
        return cmpnyUiid;
    }
    
    public void setCmpnyUiid(UUID cmpnyUiid) {
        this.cmpnyUiid = cmpnyUiid;
    }
    
    public UUID getSchmUuid() {
        return schmUuid;
    }
    
    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }
}
