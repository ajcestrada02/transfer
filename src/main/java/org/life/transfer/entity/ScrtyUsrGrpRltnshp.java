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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "SCRTY_USR_GRP_RLTNSHP")
public class ScrtyUsrGrpRltnshp extends BaseEntityUuid {

    @Column(name = "SCRTY_USR_UUID",
            insertable = false,
            updatable = false)
    private UUID scrtyUsrUuid;

    @Column(name = "SCRTY_GRP_UUID",
            insertable = false,
            updatable = false)
    private UUID scrtyGrpUuid;

    @JsonIgnore
    @JoinColumn(name = "SCRTY_GRP_UUID",
                referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ScrtyGrp scrtyGrp;

    @JsonIgnore
    @JoinColumn(name = "SCRTY_USR_UUID",
                referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ScrtyUsr scrtyUsr;

    @NotNull
    @Column(name = "CHG_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;

    @Column(name = "EFCTV_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;

    public ScrtyUsrGrpRltnshp() {
    }

    public UUID getScrtyUsrUuid() {
        return scrtyUsrUuid;
    }

    public void setScrtyUsrUuid(UUID scrtyUsrUuid) {
        this.scrtyUsrUuid = scrtyUsrUuid;
    }

    public UUID getScrtyGrpUuid() {
        return scrtyGrpUuid;
    }

    public void setScrtyGrpUuid(UUID scrtyGrpUuid) {
        this.scrtyGrpUuid = scrtyGrpUuid;
    }

    public ScrtyGrp getScrtyGrp() {
        return scrtyGrp;
    }

    public ScrtyUsr getSrctyUsr() {
        return scrtyUsr;
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
