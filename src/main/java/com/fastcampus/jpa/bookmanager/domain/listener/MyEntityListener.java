package com.fastcampus.jpa.bookmanager.domain.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {
    @PrePersist
    public void prePersist(Object obj){
        if(obj instanceof Auditable){
            ((Auditable) obj).setCreateAt(LocalDateTime.now());
            ((Auditable) obj).setUpdateAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object obj){
        if(obj instanceof Auditable){
            ((Auditable) obj).setUpdateAt(LocalDateTime.now());
        }
    }
}
