package com.ttn.hibernateDemo.service;

import com.ttn.hibernateDemo.BidirectionalOneToManyDemo.AddressBOTM;
import com.ttn.hibernateDemo.BidirectionalOneToManyDemo.AuthorBOTM;
import com.ttn.hibernateDemo.BidirectionalOneToManyDemo.BookBOTM;
import com.ttn.hibernateDemo.ManyToManyDemo.AddressMTM;
import com.ttn.hibernateDemo.ManyToManyDemo.AuthorMTM;
import com.ttn.hibernateDemo.ManyToManyDemo.BookMTM;
import com.ttn.hibernateDemo.UnidirectionalOneToManyDemo.entity.AddressUOTM;
import com.ttn.hibernateDemo.UnidirectionalOneToManyDemo.entity.AuthorUOTM;
import com.ttn.hibernateDemo.UnidirectionalOneToManyDemo.entity.BookUOTM;
import com.ttn.hibernateDemo.entity.Address;
import com.ttn.hibernateDemo.entity.Author;
import com.ttn.hibernateDemo.entity.Book;
import com.ttn.hibernateDemo.repository.AuthorRepository;
import com.ttn.hibernateDemo.repository.HibernateUtil;
import org.hibernate.Session;

import java.util.*;


public class AuthorService {
    private static AuthorRepository authorRepository = new AuthorRepository();

    //  Ques 15: Implement One to One mapping between Author and Book.

    public void oneToOneMappingDemo() {
        Address address = new Address("street-1", "Spain", "Madrid");
        String[] subjects = {"Sub 1", "Sub 2", "Sub 3"};  // Ques 13: Persist 3 subjects for each author
        Author author = new Author.AuthorBuilder(
                "George R R",
                "Martin",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList(subjects)).build();


        address = new Address("street-2", "France", "Paris");
        Author author1 = new Author.AuthorBuilder(
                "JK",
                "Rowling",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList("Sub 4", "Sub 5", "Sub 6")).build();
        ;


        address = new Address("street-3", "England", "london");
        Author author2 = new Author.AuthorBuilder(
                "William",
                "Shakespeare",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList("Sub 7", "Sub 8", "Sub 9")).build();

        Book book1 = new Book("Book 10");
        author.setBook(book1);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(book1);
        session.getTransaction().commit();

        authorRepository.create(author);
        authorRepository.create(author1);
        authorRepository.create(author2);
    }

    //    Ques 16: Implement One to Many Mapping between Author and Book(Unidirectional, BiDirectional and without additional table ) and  implement cascade save.

    public void unidirectionalOneToManyMappingDemo() {

        AddressUOTM address = new AddressUOTM("street-4", "Germany", "Berlin");
        AuthorUOTM author1 = new AuthorUOTM.AuthorBuilder(
                "Joshua",
                "Bloch",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList("Sub 13")).build();

        BookUOTM book1 = new BookUOTM("Book 1");
        BookUOTM book2 = new BookUOTM("Book-2");
        BookUOTM book3 = new BookUOTM("Book-3");
        author1.setBooks(Arrays.asList(book1, book2, book3));

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.getTransaction().commit();

        authorRepository.create(author1);
    }

    public void bidirectionalOneToManyMappingDemo() {
        AddressBOTM address = new AddressBOTM("street-5", "Canada", "Vancouver");
        String[] subjects = {"Sub 50", "Sub 20"};
        AuthorBOTM author = new AuthorBOTM.AuthorBuilder(
                "Charles",
                "Darwin",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList("Sub 31", "Sub 32")).build();

        BookBOTM book1 = new BookBOTM("Book-7");
        book1.setAuthor(author);
        BookBOTM book2 = new BookBOTM("Book-8");
        book2.setAuthor(author);

        author.setBooks(Arrays.asList(book1, book2));

        authorRepository.create(author);
    }


//    Ques 17: Implement Many to Many Mapping between Author and Book.
    public void manyToManyMappingDemo() {
        AddressMTM address = new AddressMTM("street-3", "England", "london");
        AuthorMTM author1 = new AuthorMTM.AuthorBuilder(
                "Chetan",
                "Bhagat",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList("Sub 7", "Sub 8", "Sub 9")).build();


        address = new AddressMTM("street-3", "England", "liverpool");
        AuthorMTM author2 = new AuthorMTM.AuthorBuilder(
                "Andy",
                "Robertson",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).setAddress(address).setSubjectsList(Arrays.asList("Sub 22", "Sub 23", "Sub 24")).build();

        BookMTM book1 = new BookMTM("Book-11");
        BookMTM book2 = new BookMTM("Book-12");
        BookMTM book3 = new BookMTM("Book-13");

        List<AuthorMTM> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        List<BookMTM> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        author1.setBooks(books);
        author2.setBooks(books);

        book1.setAuthorList(authors);
        book2.setAuthorList(authors);
        book3.setAuthorList(authors);

        authorRepository.create(author1);
        authorRepository.create(author2);
    }

//    Ques 2: Perform CRUD operation for Author class
    public void createAuthor() {
        Author author = new Author.AuthorBuilder(
                "Agatha",
                "Christie",
                new Random().nextInt(50) + 18,
                Calendar.getInstance().getTime()
        ).build();
        Address address = new Address("street-4", "USA", "New York");
        author.setAddress(address);
        String[] subjects = {"Sub 11", "Sub 12", "Sub 13"};  // Ques 13: Persist 3 subjects for each author
        author.setSubjects(Arrays.asList(subjects));
        authorRepository.create(author);
    }

    public Author getAuthor(int id) {
        return authorRepository.get(id);
    }

    public void updateAuthor(int id) {
        Author author = authorRepository.get(id);
        author.setFirstName("Updated Author Name");
        authorRepository.update(author);
    }

    public void deleteAuthor(int id) {
        Author author = authorRepository.get(id);
        authorRepository.delete(author);
    }
}
