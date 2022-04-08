/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jaymelson Galang <jaymelsond.galang@pccw.com>
 */
@Entity
@Table(name = "CUSTOM_TYP")
public class CustomTyp extends BaseEntityUuid {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 20)
    @Column(name = "CSTM_TYP_ID",
            nullable = false,
            length = 20)
    private String cstmTypId;

    @NotNull
    @Size(max = 20)
    @Column(name = "CSTM_GRP_ID",
            nullable = false,
            length = 20)
    private String cstmGrpId;

    @Size(max = 50)
    @Column(name = "CSTM_GRP_TXT",
            length = 50)
    private String cstmGrpTxt;
    
    @Size(max = 500)
    @Column(name = "CSTM_TYP_DTL_TXT",
            length = 500)
    private String cstmTypDtlTxt;
    
    @Size(max = 20)
    @Column(name = "LNGG_TYP_ID",
            length = 20)
    private String lnggTypId;
    
    @Column(name = "SRT_CD", 
            columnDefinition = "Number(5,0)")
    private Integer srtCd;
    
    @Size(max = 20)
    @Column(name = "LST_TYP_CD",
            length = 20)
    private String lstTypCd;
    
    @Size(max = 500)
    @Column(name = "ADM_DSPLY_LBL_TXT",
            length = 500)
    private String admDsplyLblTxt;
    
    @Size(max = 500)
    @Column(name = "CLNT_DSPLY_LBL_TXT",
            length = 500)
    private String clntDsplyLblTxt;
    
   
    public CustomTyp() {

    }

    public String getCstmTypId() {
        return cstmTypId;
    }

    public void setCstmTypId(String cstmTypId) {
        this.cstmTypId = cstmTypId;
    }

    public String getCstmGrpId() {
        return cstmGrpId;
    }

    public void setCstmGrpId(String cstmGrpId) {
        this.cstmGrpId = cstmGrpId;
    }

    public String getCstmGrpTxt() {
        return cstmGrpTxt;
    }

    public void setCstmGrpTxt(String cstmGrpTxt) {
        this.cstmGrpTxt = cstmGrpTxt;
    }

    public String getCstmTypDtlTxt() {
        return cstmTypDtlTxt;
    }

    public void setCstmTypDtlTxt(String cstmTypDtlTxt) {
        this.cstmTypDtlTxt = cstmTypDtlTxt;
    }

    public String getLnggTypId() {
        return lnggTypId;
    }

    public void setLnggTypId(String lnggTypId) {
        this.lnggTypId = lnggTypId;
    }

	public Integer getSrtCd() {
		return srtCd;
	}

	public void setSrtCd(Integer srtCd) {
		this.srtCd = srtCd;
	}

	public String getLstTypCd() {
		return lstTypCd;
	}

	public void setLstTypCd(String lstTypCd) {
		this.lstTypCd = lstTypCd;
	}

	public String getAdmDsplyLblTxt() {
		return admDsplyLblTxt;
	}

	public void setAdmDsplyLblTxt(String admDsplyLblTxt) {
		this.admDsplyLblTxt = admDsplyLblTxt;
	}

	public String getClntDsplyLblTxt() {
		return clntDsplyLblTxt;
	}

	public void setClntDsplyLblTxt(String clntDsplyLblTxt) {
		this.clntDsplyLblTxt = clntDsplyLblTxt;
	}

}
