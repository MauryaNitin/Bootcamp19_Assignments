package com.ttn.hibernateDemo.oneToManyMappingWithoutExtraTableDemo;

import javax.persistence.*;

@Entity
public class BookOTMWET {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    AuthorOTMWET author;

    public BookOTMWET() { }

    public BookOTMWET(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorOTMWET getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOTMWET author) {
        this.author = author;
    }
}
