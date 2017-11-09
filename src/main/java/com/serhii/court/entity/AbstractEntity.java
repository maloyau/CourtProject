package com.serhii.court.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AbstractEntity {
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;
    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modifiedDate;
    @Version
    @Column(name = "version")
    private long version;
}
