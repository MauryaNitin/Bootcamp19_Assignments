package com.ttn.hibernateDemo.BidirectionalOneToManyDemo;

import javax.persistence.*;

@Entity
public class BookBOTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    AuthorBOTM author;

    public BookBOTM() { }

    public BookBOTM(String name) {
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

    public AuthorBOTM getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBOTM author) {
        this.author = author;
    }
}
