package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.UUID;
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

@Entity
@Table(name = "CLNT_EMAIL")
public class ClntEmail extends BaseEntityUuid  {
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CNTCT_UUID",
                referencedColumnName = "ID",
                nullable = false,
                updatable = false,
                insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contact contact;
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CLNT_UUID",
                referencedColumnName = "ID",
                nullable = false,
                updatable = false,
                insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    
    @JsonIgnore
    @JoinColumn(name = "SCHEME_UUID",
                referencedColumnName = "ID",
                updatable = false,
                insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Scheme scheme;
    
    @JsonIgnore
    @JoinColumn(name = "ENTTY_UUID",
                referencedColumnName = "ID",
                updatable = false,
                insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientRelationship clientRelationship;
    
    @Column(name = "CNTCT_UUID")
    private UUID cntctUuid;
    
    @Column(name = "CLNT_UUID")
    private UUID clientUuid;
    
    @Column(name = "SCHEME_UUID")
    private UUID schemeUuid;
    
    @Column(name = "ENTTY_UUID")
    private UUID entityUuid;
    
    @Column(name = "EML_ADDR_TXT",
            length = 100)
    @Size(max = 100)
    private String emlAddrTxt;
    
    @Column(name = "STTS_TYP_ID",
            length = 20)
    @Size(max = 20)
    private String sttsTypId;
    
    @NotNull
    @Column(name = "EFCTV_DT", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date efctvDt;
    
    @NotNull
    @Column(name = "CHG_DT", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date chgDt;
    
    public ClntEmail() {}

    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
        if(contact != null) {
            this.cntctUuid = contact.getId();
        }
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
        if(client != null) {
            this.clientUuid = client.getId();
        }
    }
    
    public Scheme getScheme() {
        return scheme;
    }
    
    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
        if(scheme != null) {
            this.schemeUuid = scheme.getId();
        }
    }
    
    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }
    
    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
        if(clientRelationship != null) {
            this.entityUuid = clientRelationship.getId();
        }
    }
    
    public UUID getCntctUuid() {
        return cntctUuid;
    }

    public void setCntctUuid(UUID cntctUuid) {
        this.cntctUuid = cntctUuid;
    }

    public UUID getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(UUID clientUuid) {
        this.clientUuid = clientUuid;
    }

    public UUID getSchemeUuid() {
        return schemeUuid;
    }

    public void setSchemeUuid(UUID schemeUuid) {
        this.schemeUuid = schemeUuid;
    }

    public UUID getEntityUuid() {
        return entityUuid;
    }

    public void setEntityUuid(UUID entityUuid) {
        this.entityUuid = entityUuid;
    }
    
    public String getEmlAddrTxt() {
        return emlAddrTxt;
    }

    public void setEmlAddrTxt(String emlAddrTxt) {
        this.emlAddrTxt = emlAddrTxt;
    }

    public String getSttsTypId() {
        return sttsTypId;
    }

    public void setSttsTypId(String sttsTypId) {
        this.sttsTypId = sttsTypId;
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

    @Override
    public String toString() {
        return "ClientEmail{" + "client=" + (client == null ? "" : client) + ", scheme=" + (scheme == null ? "" : scheme) + ", clientRelationship=" + (clientRelationship == null ? "" : clientRelationship) + ", emlAddrTxt=" + emlAddrTxt + ", sttsTypId=" + sttsTypId + ", efctvDt=" + efctvDt + ", chgDt=" + chgDt + '}';
    }
    
    
}
