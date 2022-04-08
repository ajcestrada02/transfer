/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "CYCLE_DATE")
public class CycleDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(generator="UUID")
    private UUID id;

    @Embedded
    protected CycleDatePK cycleDatePK;
    
    @JoinColumn(name = "SCHM_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Scheme scheme;
        
    @Size(max = 100)
    @Column(name = "CYCLE_DT_NM", 
            length = 100)
    private String cycleDtNm;
    
    @NotNull
    @Column(name = "CYCLE_DT",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cycleDt;

    public CycleDate() {
    }

    public CycleDate(CycleDatePK cycleDatePK) {
        this.cycleDatePK = cycleDatePK;
    }

    public CycleDate(short cycleDtStpCd, UUID schmUuid) {
        this.cycleDatePK = new CycleDatePK(cycleDtStpCd, schmUuid);
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public CycleDatePK getCycleDatePK() {
        return cycleDatePK;
    }

    public void setCycleDatePK(CycleDatePK cycleDatePK) {
        this.cycleDatePK = cycleDatePK;
    }

    public String getCycleDtNm() {
        return cycleDtNm;
    }

    public void setCycleDtNm(String cycleDtNm) {
        this.cycleDtNm = cycleDtNm;
    }

    public Date getCycleDt() {
        return cycleDt;
    }

    public void setCycleDt(Date cycleDt) {
        this.cycleDt = cycleDt;
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
}
