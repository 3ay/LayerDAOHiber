package com.netology.layerdaohiber.dao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
@Getter
public class PersonKeyId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
