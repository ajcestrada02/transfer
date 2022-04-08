package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "TRUSTEE_HST")
public class TrusteeHst extends BaseEntityUuid {

    @JsonIgnore
    @JoinColumn(name = "TRST_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trustee trustee;

    @Size(max = 10)
    @Column(name = "ACTN_STTS_TXT", 
            length = 10)
    private String actnSttsTxt;

    @NotNull
    @Column(name = "TRST_CD",
            nullable = false,
            unique = true,
            columnDefinition = "NUMBER(15, 0)")
    private Long trstCd;

    @Size(max = 200)
    @Column(name = "TRST_NM", 
            length = 200, 
            nullable = false, 
            unique = true)
    private String trstNm;

    @Size(max = 200)
    @Column(name = "TRST_CHNS_NM", 
            length = 200)
    private String trstChnsNm;

    @Size(max = 200)
    @Column(name = "TRST_APPRVL_NMBR_TXT",
            length = 200,
            unique = true)
    private String trstApprvlNmbrTxt;

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

    public TrusteeHst() {
    }

    public Trustee getTrustee() {
        return trustee;
    }

    public void setTrustee(Trustee trustee) {
        this.trustee = trustee;
    }

    public String getActnSttsTxt() {
        return actnSttsTxt;
    }

    public void setActnSttsTxt(String actnSttsTxt) {
        this.actnSttsTxt = actnSttsTxt;
    }

    public Long getTrstCd() {
        return trstCd;
    }

    public void setTrstCd(Long trstCd) {
        this.trstCd = trstCd;
    }

    public String getTrstNm() {
        return trstNm;
    }

    public void setTrstNm(String trstNm) {
        this.trstNm = trstNm;
    }

    public String getTrstChnsNm() {
        return trstChnsNm;
    }

    public void setTrstChnsNm(String trstChnsNm) {
        this.trstChnsNm = trstChnsNm;
    }

    public String getTrstApprvlNmbrTxt() {
        return trstApprvlNmbrTxt;
    }

    public void setTrstApprvlNmbrTxt(String trstApprvlNmbrTxt) {
        this.trstApprvlNmbrTxt = trstApprvlNmbrTxt;
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
}
