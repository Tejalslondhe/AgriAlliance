package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.enums.Crop;
import com.app.enums.Role;
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
public class Worker extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workerId;
    
    private Integer noOfGroupMembers;

    @Enumerated(EnumType.STRING)
    private Skill skills;

    @Enumerated(EnumType.STRING)
    private Crop crop;

//<<<<<<< HEAD
//=======
//    
//>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199
    @Enumerated(EnumType.STRING)
    private Role role = Role.WORKER;

   
}
