package com.ttn.hibernateDemo.ManyToManyDemo;

import javax.persistence.*;
import java.util.*;

@Entity
public class BookMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "books")
    List<AuthorMTM> authorList = new ArrayList<>();

    public BookMTM() {

    }

    public BookMTM(String name) {
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

    public List<AuthorMTM> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorMTM> authorList) {
        this.authorList = authorList;
    }
}
