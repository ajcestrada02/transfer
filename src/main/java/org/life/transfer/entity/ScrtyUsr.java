package org.life.transfer.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.life.transfer.entity.BaseEntityUuid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SCRTY_USR")
public class ScrtyUsr extends BaseEntityUuid {

    @Size(max = 20)
    @Column(name = "usr_id", 
            length = 20)
    private String usrId;

    @Size(max = 50)
    @Column(name = "usr_nm", 
            length = 50)
    private String usrNm;

    public ScrtyUsr() {
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
}
