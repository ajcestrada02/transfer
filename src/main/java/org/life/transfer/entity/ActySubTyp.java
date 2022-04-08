package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "acty_sub_typ")
public class ActySubTyp {
    
    @Id
    @Column(name = "id",
            nullable = false)
    private UUID id;
    
    @NaturalId
    @Column(name = "acty_typ_id",
            insertable = false, 
            updatable = false,
            length = 20)
    private String actyTypId;
    
    @NaturalId
    @NotNull
    @Column(name = "acty_sub_id",
            nullable = false,
            unique = true)
    private String actySubId;
    
    @Column(name = "schm_uuid",
            insertable = false,
            updatable = false)
    private UUID schmUuid;
    
    @Size(max = 100)
    @Column(name = "sub_typ_nm",
            length = 100)
    private String subTypNm;
    
    @Column(name = "sort_seq_nmbr",
            columnDefinition = "NUMBER(5, 0)")
    private Short sortSeqNmbr;
    
    @Size(max = 20)
    @Column(name = "stts_typ_id",
            length = 20)
    private String sttsTypId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schm_uuid",
                referencedColumnName = "id")
    private Scheme scheme;
    
    @ManyToOne(fetch = FetchType.LAZY,
              optional = false)
    @JoinColumn(name = "acty_typ_id",
                referencedColumnName = "acty_typ_id",
                nullable = false)
    private ActivityTyp activityTyp;
    
    public ActySubTyp() {
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getActyTypId() {
        return actyTypId;
    }
    
    public void setActyTypId(String actyTypId) {
        this.actyTypId = actyTypId;
    }
    
    public String getActySubId() {
        return actySubId;
    }
    
    public void setActySubId(String actySubId) {
        this.actySubId = actySubId;
    }
    
    public UUID getSchmUuid() {
        return schmUuid;
    }
    
    public void setSchmUuid(UUID schmUuid) {
        this.schmUuid = schmUuid;
    }
    
    public String getSubTypNm() {
        return subTypNm;
    }
    
    public void setSubTypNm(String subTypNm) {
        this.subTypNm = subTypNm;
    }
    
    public Short getSortSeqNmbr() {
        return sortSeqNmbr;
    }
    
    public void setSortSeqNmbr(Short sortSeqNmbr) {
        this.sortSeqNmbr = sortSeqNmbr;
    }
    
    public String getSttsTypId() {
        return sttsTypId;
    }
    
    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
    }
    
    public Scheme getScheme() {
        return scheme;
    }
    
    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }
    
    public ActivityTyp getActivityTyp() {
        return activityTyp;
    }
    
    public void setActivityTyp(ActivityTyp activityTyp) {
        this.activityTyp = activityTyp;
    }
    
}
