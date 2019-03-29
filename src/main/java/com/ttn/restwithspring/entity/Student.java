package com.ttn.restwithspring.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Ques 6: Ignore ID field in the Response.
@Entity
@JsonIgnoreProperties(value = {"id"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Student name cannot be empty!")
    @Size(min = 2, message = "Length of name should be greater than 2!")
    private String name;
    @NotNull(message = "Major cannot be empty!")
    private String major;
    @Digits(message = "Age should be Numeric of 2 digits!", integer = 2, fraction = 0)
    @Min(value = 18, message = "Age should not be less than 18!")
    private Integer age;

    public Student(Integer id, String name, String major, Integer age) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.age = age;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                '}';
    }
}
