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

@Entity
@Table(name = "ENTTY_AGNT")
public class EntityAgent extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "entty_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    private ClientRelationship clientRelationship;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "agnt_uuid",
                referencedColumnName = "id",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    private Agent agent;

    @Column(name = "entty_uuid",
            insertable = false,
            updatable = false)
    private UUID enttyUuid;

    @Size(max = 3)
    @Column(name = "PRCNTG_RT",
            length = 3)
    private String prcntgRt;

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
    
    @Column(name = "agnt_uuid",
            insertable = false,
            updatable = false)
    private UUID agntUuid;

    public EntityAgent() {
    }

    public UUID getEnttyUuid() {
        return enttyUuid;
    }

    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }

    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }

    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getPrcntgRt() {
        return prcntgRt;
    }

    public void setPrcntgRt(String prcntgRt) {
        this.prcntgRt = prcntgRt;
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
    
    public UUID getAgntUuid() {
        return agntUuid;
    }
    
    public void setAgntUuid(UUID agntUuid) {
        this.agntUuid = agntUuid;
    }
}
