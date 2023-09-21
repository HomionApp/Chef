package com.homion.chef.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "homeNo", nullable = false)
    private String homeNo;

    @Column(name = "society", nullable = false)
    private String society;

    @Column(name = "landmark", nullable = false)
    private String landmark;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "pincode", nullable = false)
    private String pincode;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;

}
