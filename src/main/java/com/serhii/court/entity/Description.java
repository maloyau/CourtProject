package com.serhii.court.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "descriptions")
public class Description extends AbstractEntity{
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "text", nullable = false, columnDefinition = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "cause_id", referencedColumnName = "id", nullable = false)
    private Cause cause;
}
