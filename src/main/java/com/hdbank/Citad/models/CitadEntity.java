package com.hdbank.Citad.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citad")
public class CitadEntity extends BaseEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "branch")
    private String branch;
}
