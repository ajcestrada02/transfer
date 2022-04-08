package org.life.transfer.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author antonysnow
 */
@MappedSuperclass
public class BaseEntityUuid extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator="UUID")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
