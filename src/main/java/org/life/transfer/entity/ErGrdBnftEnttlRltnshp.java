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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ER_GRD_BNFT_ENTTL_RLTNSHP")
public class ErGrdBnftEnttlRltnshp extends BaseEntityUuid {
    @JsonIgnore
    @JoinColumn(name = "ER_GRD_CNTRB_TYP_RLTNSHP_UUID", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ErGrdCntrbTypRltnshp erGrdCntrbTypRltnshp;
    
    @Size(max = 20)
    @Column(name = "BNFT_ENTTLMNT_ID",
            length = 20)
    private String bnftEnttlmntId;

    @Size(max = 10)
    @Column(name = "X_BNFT_ENTTLMNT_TXT",
            length = 10)
    private String xBnftEnttlmntTxt;
    
    @NotNull
    @Column(name = "efctv_dt",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;
    
    @Column(name = "er_grd_cntrb_typ_rltnshp_uuid",
            insertable = false,
            updatable = false)
    private UUID erGrdCntrbTypRltnshpUuid;

    public ErGrdBnftEnttlRltnshp() {
    }

    public ErGrdCntrbTypRltnshp getErGrdCntrbTypRltnshp() {
        return erGrdCntrbTypRltnshp;
    }

    public void setErGrdCntrbTypRltnshp(ErGrdCntrbTypRltnshp erGrdCntrbTypRltnshp) {
        this.erGrdCntrbTypRltnshp = erGrdCntrbTypRltnshp;
    }

    public String getBnftEnttlmntId() {
        return bnftEnttlmntId;
    }

    public void setBnftEnttlmntId(String bnftEnttlmntId) {
        this.bnftEnttlmntId = bnftEnttlmntId;
    }

    public String getxBnftEnttlmntTxt() {
        return xBnftEnttlmntTxt;
    }

    public void setxBnftEnttlmntTxt(String xBnftEnttlmntTxt) {
        this.xBnftEnttlmntTxt = xBnftEnttlmntTxt;
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
    
    public UUID getErGrdCntrbTypRltnshpUuid() {
        return erGrdCntrbTypRltnshpUuid;
    }
    
    public void setErGrdCntrbTypRltnshpUuid(UUID erGrdCntrbTypRltnshpUuid) {
        this.erGrdCntrbTypRltnshpUuid = erGrdCntrbTypRltnshpUuid;
    }
}
