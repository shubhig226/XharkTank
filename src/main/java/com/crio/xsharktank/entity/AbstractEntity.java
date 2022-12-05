package com.crio.xsharktank.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Data
public class AbstractEntity {
    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime addedOn;

    @JsonIgnore
    @UpdateTimestamp
    @Column private LocalDateTime updatedOn;

    @Version
    @JsonIgnore
    @Column private Integer version;
}
