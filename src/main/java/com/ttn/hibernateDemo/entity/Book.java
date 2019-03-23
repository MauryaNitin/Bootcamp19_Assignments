package com.ttn.hibernateDemo.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Ques 14: Create an Entity book with an instance variable name.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    @ManyToOne
//    AuthorUOTM author;
//
//    @ManyToMany(mappedBy = "books")
//    List<AuthorUOTM> authorList = new ArrayList<>();

    public Book(){

    }

    public Book(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public AuthorUOTM getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(AuthorUOTM author) {
//        this.author = author;
//    }
}
