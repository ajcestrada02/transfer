package org.life.transfer.entity;

import java.util.Date;

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
@Table(name = "CLNT_BANK")
public class ClientBank extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonIgnore
    @JoinColumn(name = "CLNT_UUID",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, 
               optional = false)
    private Client client;

    @JsonIgnore
    @JoinColumn(name = "ENTTY_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientRelationship clientRelationship;

    @JsonIgnore
    @JoinColumn(name = "INST_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Instruction instruction;

    @JsonIgnore
    @JoinColumn(name = "PYRLL_GRP_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PayrollGroup payrollGroup;

    @JsonIgnore
    @JoinColumn(name = "BNK_UUID",
                referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;
    
    @Size(max = 20)
    @Column(name = "PYMNT_TYP_ID",
            length = 20)
    private String pymntTypId;
    
    @Size(max = 150)
    @Column(name = "ACCNT_HLDR_NM",
            length = 150)
    private String accntHldrNm;
    
    @Size(max = 5)
    @Column(name = "CRRNCY_TYP_CD",
            length = 5)
    private Integer crrncyTypCd;
    
    @Size(max = 20)
    @Column(name = "BNK_ACCNT_NMBR",
            columnDefinition = "NUMBER(20, 0)")
    private Long bnkAccntNmbr;
    
    @Size(max = 3)
    @Column(name = "PRMY_FLG",
            columnDefinition = "NUMBER(3, 0)")
    private Integer prmyFlg;
    
    @Size(max = 20)
    @Column(name = "ID_TYP_ID",
            length = 20)
    private String idTypId;
    
    @Size(max = 50)
    @Column(name = "id_no_txt",
            length = 50)
    private String idNoTxt;
    
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientRelationship getClientRelationship() {
        return clientRelationship;
    }

    public void setClientRelationship(ClientRelationship clientRelationship) {
        this.clientRelationship = clientRelationship;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public PayrollGroup getPayrollGroup() {
        return payrollGroup;
    }

    public void setPayrollGroup(PayrollGroup payrollGroup) {
        this.payrollGroup = payrollGroup;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getPymntTypId() {
        return pymntTypId;
    }

    public void setPymntTypId(String pymntTypId) {
        this.pymntTypId = pymntTypId;
    }

    public String getAccntHldrNm() {
        return accntHldrNm;
    }

    public void setAccntHldrNm(String accntHldrNm) {
        this.accntHldrNm = accntHldrNm;
    }

    public Integer getCrrncyTypCd() {
        return crrncyTypCd;
    }

    public void setCrrncyTypCd(Integer crrncyTypCd) {
        this.crrncyTypCd = crrncyTypCd;
    }

    public Long getBnkAccntNmbr() {
        return bnkAccntNmbr;
    }

    public void setBnkAccntNmbr(Long bnkAccntNmbr) {
        this.bnkAccntNmbr = bnkAccntNmbr;
    }

    public Integer getPrmyFlg() {
        return prmyFlg;
    }

    public void setPrmyFlg(Integer prmyFlg) {
        this.prmyFlg = prmyFlg;
    }

    public String getIdTypId() {
        return idTypId;
    }

    public void setIdTypId(String idTypId) {
        this.idTypId = idTypId;
    }

    public String getIdNoTxt() {
        return idNoTxt;
    }

    public void setIdNoTxt(String idNoTxt) {
        this.idNoTxt = idNoTxt;
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
