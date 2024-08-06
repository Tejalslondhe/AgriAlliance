package com.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.Crop;
import com.app.enums.Skill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "workers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Worker extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workerId;

    private Integer noOfGroupMembers;

    @Enumerated(EnumType.STRING)
    private Skill skills;

    @Enumerated(EnumType.STRING)
    private Crop crop;

    @OneToMany(mappedBy = "worker")
    private List<Instrument> instruments;

   
}
