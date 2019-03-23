package com.ttn.hibernateDemo.BidirectionalOneToManyDemo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class AuthorBOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Transient
    @Column(name = "last_name")
    private String lastName;

    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;

    @Embedded
    private AddressBOTM address;

    @ElementCollection
    private List<String> subjects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name="Author_id"), inverseJoinColumns = @JoinColumn(name="Book_id"))
    private List<BookBOTM> books = new ArrayList<>();

    public static class AuthorBuilder{
        private String firstName;
        private String lastName;
        private Integer age;
        private Date dob;
        private AddressBOTM address;
        private List<String> subjectsList;
        private List<BookBOTM> bookList;

        public AuthorBuilder(String firstName, String lastName, Integer age, Date dob) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.dob = dob;
        }


        public AuthorBuilder setAddress(AddressBOTM address) {
            this.address = address;
            return this;
        }

        public AuthorBuilder setBookList(List<BookBOTM> bookList) {
            this.bookList = bookList;
            return this;
        }

        public AuthorBuilder setSubjectsList(List<String> subjectsList) {
            this.subjectsList = subjectsList;
            return this;
        }

        public AuthorBOTM build(){
            return new AuthorBOTM(this);
        }
    }

    private AuthorBOTM(AuthorBuilder authorBuilder) {
        this.firstName = authorBuilder.firstName;
        this.lastName = authorBuilder.lastName;
        this.age = authorBuilder.age;
        this.dateOfBirth = authorBuilder.dob;
        this.address = authorBuilder.address;
        this.subjects = authorBuilder.subjectsList;
        this.books = authorBuilder.bookList;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AddressBOTM getAddress() {
        return address;
    }

    public void setAddress(AddressBOTM address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<BookBOTM> getBooks() {
        return books;
    }

    public void setBooks(List<BookBOTM> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorBOTM{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
