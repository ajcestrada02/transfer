package org.life.transfer.entity;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author antonysnow
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Version
    @Column(name = "UPDATE_DATE")
    @Generated(GenerationTime.ALWAYS)
    private Instant version;
    
    @Column(name = "ARCHV_FLG")
    private Boolean archvFlg;
    

    public Instant getVersion() {
        return version;
    }

    public void setVersion(Instant version) {
        this.version = version;
    }

    public static int writeRecordFlag (int origValue, RecordFlagIndex index, boolean value) {
        return origValue - (((origValue & index.position) == index.position) ? index.position : 0) + (value ? index.position : 0);
    }
    
    public static boolean readRecordFlag (int origValue, RecordFlagIndex index) {
        return (origValue & index.position) == index.position;
    }

    public static enum RecordFlagIndex {
        INDEX_1(1)
        , INDEX_2(2)
        , INDEX_3(4)
        , INDEX_4(8)
        , INDEX_5(16)
        , INDEX_6(32)
        , INDEX_7(64)
        , INDEX_8(128)
        ;
        
        protected int position;
        
        private RecordFlagIndex(int position) {
            this.position = position;
        }
        
    }
    
}
