package org.life.transfer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

/**
 * 
 * @author arbe.padilla <ArbeJorgeA.Padilla@pccw.com>
 */
@Entity
@Table(name = "AGENT")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a")
@NamedEntityGraph(name = "getAgent")
public class Agent extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;
    
    @Size(max = 50)
    @Column(name = "trst_agnt_cd",
            length = 50)
    private String trstAgntCd;
    
    @Size(max = 50)
    @Column(name = "agnt_nm",
            length = 50)
    private String agntNm;
    
    @Size(max = 50)
    @Column(name = "reg_nmbr_txt",
            length = 50)
    private String regNmbrTxt;
    
    @Size(max = 20)
    @Column(name = "stts_typ_id",
            length = 20)
    private String sttsTypId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Set<EntityAgent> entityAgents;
    
    @NotNull
    @Column(name = "efctv_dt",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "chg_dt",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgDt;

    public String getTrstAgntCd() {
        return trstAgntCd;
    }

    public void setTrstAgntCd(String trstAgntCd) {
        this.trstAgntCd = trstAgntCd;
    }

    public String getAgntNm() {
        return agntNm;
    }

    public void setAgntNm(String agntNm) {
        this.agntNm = agntNm;
    }

    public String getRegNmbrTxt() {
        return regNmbrTxt;
    }

    public void setRegNmbrTxt(String regNmbrTxt) {
        this.regNmbrTxt = regNmbrTxt;
    }

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }

    public Set<EntityAgent> getEntityAgents() {
        return entityAgents;
    }

    public void setEntityAgents(Set<EntityAgent> entityAgents) {
        this.entityAgents = entityAgents;
        if (entityAgents != null) {
            entityAgents.stream()
                    .filter(entityAgent -> entityAgent.getAgent() == null)
                    .forEachOrdered(entityAgent -> entityAgent.setAgent(this));
        }
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
