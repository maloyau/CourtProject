package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Version
    @Column(name = "version")
    private long version;
}
