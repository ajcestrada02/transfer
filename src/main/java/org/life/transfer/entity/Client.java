/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.life.transfer.entity.BaseEntityUuid;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "CLIENT")
public class Client extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "client")
    private Set<Identification> identifications;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "client")
    private Set<Address> addresses;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, 
               mappedBy = "client")
    private Set<Company> companies;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "client")
    private Set<ClientBank> clientBanks;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
              mappedBy = "client")
    private Individual individual;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "client")
    private Set<ClntEmail> clntEmails;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "client")
    private Set<ClntPhone> clntPhones;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "client")
    private Set<Contact> contacts;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "client")
    private Set<ClientRelationship> clientRelationships;

    @NotEmpty
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SYS_CLNT_TYP_TXT",
            nullable = false,
            length = 50)
    private String sysClntTypTxt;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
              mappedBy = "client")
    private CrsHeader crsHeader;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
              mappedBy = "client")
    private Set<AddressScheme> addressSchemes;

    public Client() {
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
        if (individual != null) {
            individual.setClient(this);
        }
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
        if (contacts != null) {
            contacts.stream().filter(contact -> (contact.getClient() == null)).forEachOrdered(contact -> {
                contact.setClient(this);
            });
        }
    }

    public Set<ClientBank> getClientBanks() {
        return clientBanks;
    }

    public void setClientBanks(Set<ClientBank> clientBanks) {
        this.clientBanks = clientBanks;
        if (clientBanks != null) {
            clientBanks.stream().filter(clientBank -> (clientBank.getClient() == null)).forEachOrdered(clientBank -> {
                clientBank.setClient(this);
            });
        }
    }

    public Set<ClntPhone> getClntPhones() {
        return clntPhones;
    }

    public void setClntPhones(Set<ClntPhone> clntPhones) {
        this.clntPhones = clntPhones;
        if (clntPhones != null) {
            clntPhones.stream().filter(clntPhone -> (clntPhone.getClient() == null)).forEachOrdered(clntPhone -> {
                clntPhone.setClient(this);
            });
        }
    }

    public Set<Identification> getIdentifications() {
        return identifications;
    }

    public void setIdentifications(Set<Identification> identifications) {
        this.identifications = identifications;

        if (identifications != null) {
            identifications.stream().filter(identification -> (identification.getClntUuid() == null)).forEachOrdered(identification -> {
                identification.setClntUuid(this.getId());
            });
        }
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public String getSysClntTypTxt() {
        return sysClntTypTxt;
    }

    public void setSysClntTypTxt(String sysClntTypTxt) {
        this.sysClntTypTxt = sysClntTypTxt;
    }

    public Set<ClientRelationship> getClientRelationships() {
        return clientRelationships;
    }

    public void setClientRelationships(Set<ClientRelationship> clientRelationships) {
        this.clientRelationships = clientRelationships;
    }

	public CrsHeader getCrsHeader() {
		return crsHeader;
	}

	public void setCrsHeader(CrsHeader crsHeader) {
		this.crsHeader = crsHeader;
	}
    
    public Set<AddressScheme> getAddressSchemes() {
        return addressSchemes;
    }
    
    public void setAddressSchemes(Set<AddressScheme> addressSchemes) {
        this.addressSchemes = addressSchemes;
    }
    
    public Set<ClntEmail> getClntEmails() {
		return clntEmails;
	}

	public void setClntEmails(Set<ClntEmail> clntEmails) {
		this.clntEmails = clntEmails;
	}
    
    @Override
    public String toString() {
        return new StringJoiner(", ", Client.class.getSimpleName() + "[", "]")
                .add("identifications=" + identifications)
                .add("addresses=" + addresses)
                .add("companies=" + companies)
                .add("clientBanks=" + clientBanks)
                .add("individual=" + individual)
                .add("clntEmails=" + clntEmails)
                .add("clntPhones=" + clntPhones)
                .add("contacts=" + contacts)
                .add("clientRelationships=" + clientRelationships)
                .add("sysClntTypTxt='" + sysClntTypTxt + "'")
                .add("crsHeader=" + crsHeader)
                .add("addressSchemes=" + addressSchemes)
                .toString();
    }
}
