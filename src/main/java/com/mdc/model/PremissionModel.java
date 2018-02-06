package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permissions")
public class PremissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;

    @Column(nullable = false)
    private String name;
}
