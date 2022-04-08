package org.life.transfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.life.transfer.entity.BaseEntity;

/**
 *
 * @author Kate Gwen Gispert <kategwen.m.gispert@pccw.com>
 */
@Entity
@Table(name = "CORRESPONDENCE")
@NamedQueries({
        @NamedQuery(name = "Correspondence.findAll", query = "SELECT c FROM Correspondence c") })
@NamedEntityGraph(name = "getCorrespondence")
public class Correspondence extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "CLNT_UUID")
    private UUID clntUuid;

    @Column(name = "ENTTY_UUID")
    private UUID enttyUuid;

    @Column(name = "INST_UUID")
    private UUID instUuid;

    @Column(name = "CRRSP_REF_NO_TXT")
    private String crrspRefNoTxt;

    @Column(name = "REGEN_FLG")
    private Short regenFlag;

    @Column(name = "CRRSP_TYP_UUID")
    private UUID crrspTypUuid;

    @Column(name = "ISS_DT")
    private Date issDt;

    @Column(name = "CMM_TYP_ID")
    private String cmmTypId;

    public Correspondence() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClntUuid() {
        return clntUuid;
    }

    public void setClntUuid(UUID clntUuid) {
        this.clntUuid = clntUuid;
    }

    public UUID getEnttyUuid() {
        return enttyUuid;
    }

    public void setEnttyUuid(UUID enttyUuid) {
        this.enttyUuid = enttyUuid;
    }

    public UUID getInstUuid() {
        return instUuid;
    }

    public void setInstUuid(UUID instUuid) {
        this.instUuid = instUuid;
    }

    public String getCrrspRefNoTxt() {
        return crrspRefNoTxt;
    }

    public void setCrrspRefNoTxt(String crrspRefNoTxt) {
        this.crrspRefNoTxt = crrspRefNoTxt;
    }

    public Short getRegenFlag() {
        return regenFlag;
    }

    public void setRegenFlag(Short regenFlag) {
        this.regenFlag = regenFlag;
    }

    public UUID getCrrspTypUuid() {
        return crrspTypUuid;
    }

    public void setCrrspTypUuid(UUID crrspTypUuid) {
        this.crrspTypUuid = crrspTypUuid;
    }

    public Date getIssDt() {
        return issDt;
    }

    public void setIssDt(Date issDt) {
        this.issDt = issDt;
    }

    public String getCmmTypId() {
        return cmmTypId;
    }

    public void setCmmTypId(String cmmTypId) {
        this.cmmTypId = cmmTypId;
    }
}
