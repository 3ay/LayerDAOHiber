package com.netology.layerdaohiber.dao;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@ToString
public class PersonDAO {
    @EmbeddedId
    private PersonKeyId id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

}
