package org.life.transfer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

/**
 * @author Aldrine John Carlos - 81258782
 *
 */

@Entity
@Table(name = "ADDR_SCHM")
public class AddressScheme extends BaseEntityUuid {

	@NotNull
	@JsonIgnore
	@JoinColumn(name = "CLNT_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Client client;

	@NotNull
	@JsonIgnore
	@JoinColumn(name = "ADDR_UUID",
				referencedColumnName = "id",
				nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Address address;

	@NotNull
	@JsonIgnore
	@JoinColumn(name = "SCHM_UUID", 
				referencedColumnName = "ID", 
				nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, 
			   optional = false)
	private Scheme scheme;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "ADDR_TYP_ID",
			nullable = false,
			length = 20)
	private String addrTypId;
	
	@Size(max = 20)
	@Column(name = "STTS_TYP_ID",
			length = 20)
	private String sttsTypId;
	
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
	
	@Column(name = "addr_uuid",
            insertable = false,
            updatable = false)
	private UUID addrUUID;
	
	@Column(name = "entty_uuid")
	private UUID enttyUUID;
	
	@Column(name = "schm_uuid",
            insertable = false,
            updatable = false)
	private UUID schmUUID;
	
	@Column(name = "clnt_uuid",
            insertable = false,
            updatable = false)
	private UUID clntUuid;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAddrTypId() {
		return addrTypId;
	}

	public void setAddrTypId(String addrTypId) {
		this.addrTypId = addrTypId;
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

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}
	
	public UUID getAddrUUID() {
		return addrUUID;
	}
	
	public void setAddrUUID(UUID addrUUID) {
		this.addrUUID = addrUUID;
	}
	
	public UUID getEnttyUUID() {
		return enttyUUID;
	}
	
	public void setEnttyUUID(UUID enttyUUID) {
		this.enttyUUID = enttyUUID;
	}
	
	public UUID getSchmUUID() {
		return schmUUID;
	}
	
	public void setSchmUUID(UUID schmUUID) {
		this.schmUUID = schmUUID;
	}
	
	public UUID getClntUuid() {
		return clntUuid;
	}
	
	public void setClntUuid(UUID clntUuid) {
		this.clntUuid = clntUuid;
	}
}
