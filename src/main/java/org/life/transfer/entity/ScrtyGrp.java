package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SCRTY_GRP")
public class ScrtyGrp extends BaseEntityUuid {

    @Size(max = 20)
    @Column(name = "grp_id", 
            length = 20)
    private String usrId;

    @Size(max = 50)
    @Column(name = "grp_nm", 
            length = 50)
    private String usrNm;

    @Column(name = "prtl_id")
    private String prtlId;

    public ScrtyGrp() {
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrNm() {
        return usrNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    public String getPrtlId() {
        return prtlId;
    }

    public void setPrtlId(String prtlId) {
        this.prtlId = prtlId;
    }
}
