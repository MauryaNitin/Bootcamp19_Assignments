package com.ttn.hibernateDemo;

import com.ttn.hibernateDemo.repository.HibernateUtil;
import com.ttn.hibernateDemo.service.AuthorService;

public class Application {

    private static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {

        // create author
        authorService.createAuthor();
        authorService.createAuthor();
        authorService.createAuthor();
        authorService.createAuthor();
        authorService.createAuthor();

        // get author by id
        System.out.println(" ---> " + authorService.getAuthor(1));

        // update author 2 firstName
        authorService.updateAuthor(2);

        // delete author 3
        authorService.deleteAuthor(3);

        // One to One Mapping Demo
        authorService.oneToOneMappingDemo();

        // Unidirectional One To Many Mapping Demo
        authorService.unidirectionalOneToManyMappingDemo();

        // Bidirectional One to Many Mapping Demo
        authorService.bidirectionalOneToManyMappingDemo();

        // One to Many Without Extra Table
        authorService.oneToManyWithoutExtraTableDemo();

        // Many to Many Mapping Demo
        authorService.manyToManyMappingDemo();

//        HibernateUtil.shutdown();
    }
}
