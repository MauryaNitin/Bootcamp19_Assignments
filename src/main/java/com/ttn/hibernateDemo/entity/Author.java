package com.ttn.hibernateDemo.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

/***
 * Ques 1: Create a class Author with instance variables firstName, lastName and age.
 */

@Entity
public class Author {

    @Id
    //    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ques 9: Generate Id for Author Using IDENTITY and TABLE strategy.
    private int id;
    @Column(name = "first_name")        // Ques 6: Rename all the fields using column annotation.
    private String firstName;
    @Transient                          // Ques 7: Mark lastName as @Transient.
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Temporal(TemporalType.DATE)        // Ques 8: Use @Temporal for date of birth of Author
    @Column(name = "dob")
    private Date dateOfBirth;           // Ques 3: Use hbm2ddl create to introduce Date of Birth for Author

    @Embedded
    private Address address;            // Ques 11: Create instance variable of Address class inside Author class and save it as embedded object.

    @ElementCollection
    private List<String> subjects = new ArrayList<>();      // Ques 12: Introduce a List of subjects for author.

    //    Ques 15: Implement One to One mapping between Author and Book.
    @JoinColumn(name = "book_id")
    @OneToOne
    Book book;

//    Unidirectional
//    @OneToMany
//    @JoinTable(joinColumns = @JoinColumn(name="Author_id"), inverseJoinColumns = @JoinColumn(name="Book_id"))
//    List<Book> books = new ArrayList<>();

//    BiDirectional
//    @OneToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "Author_id"), inverseJoinColumns = @JoinColumn(name = "Book_id"))


//    Ques 17: Implement Many to Many Mapping between AuthorUOTM and Book.
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            joinColumns = { @JoinColumn(name = "Author_id") },
//            inverseJoinColumns = { @JoinColumn(name = "Book_id") }
//    )
//    List<Book> books = new ArrayList<>();


    private Author(AuthorBuilder authorBuilder) {
        this.firstName = authorBuilder.firstName;
        this.lastName = authorBuilder.lastName;
        this.age = authorBuilder.age;
        this.dateOfBirth = authorBuilder.dob;
        this.address = authorBuilder.address;
        this.subjects = authorBuilder.subjectsList;
        this.book = authorBuilder.book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //    Q17
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
    public static class AuthorBuilder{
        private String firstName;
        private String lastName;
        private Integer age;
        private Date dob;
        private Address address;
        private Book book;
        private List<String> subjectsList;

        public AuthorBuilder(String firstName, String lastName, Integer age, Date dob) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.dob = dob;
        }


        public AuthorBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public AuthorBuilder setBook(Book book) {
            this.book = book;
            return this;
        }

        public AuthorBuilder setSubjectsList(List<String> subjectsList) {
            this.subjectsList = subjectsList;
            return this;
        }

        public Author build(){
            return new Author(this);
        }
    }
}
