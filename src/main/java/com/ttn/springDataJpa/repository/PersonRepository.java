package com.ttn.springDataJpa.repository;

import com.ttn.springDataJpa.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Ques 2: Implement CrudRepository for it.
 */

public interface PersonRepository extends CrudRepository<Person,Integer> {

    // Ques 4: For class Person find person declare methods in repository to find person by firstname, lastname and Id.
    Person[] findByFirstName(String firstName);

    Person[] findByLastName(String lastName);

    Person findById(Integer id);

//    @Query("SELECT name from Person where id=:id")
////    String findById(@Param("id") Integer id);
////
////    @Query("SELECT id,name from Person where id=:id")
////    List<Object[]> findById(@Param("id") Integer id);
////
//    @Query("SELECT e from Person e where id=:id")
//    Person findById(@Param("id") Integer id);

//    Person findByNameIs(@Param("name") String name);
//
//    List<Person> findAllBySalary(int salary);
//
//    List<Person> findByNameOrderByIdDesc(String name);
//


    // Ques 6: Use @Query to fetch firstname of the Person whose age is 25.
    @Query("select firstName from Person where age  = :age")
    String[] getFirstNameOfPersonByAge(@Param("age") int age);

    // Ques 7: Use @Query to fetch firstname and lastname of the Person whose age is 25.
    @Query("select firstName, lastName from Person where age = :age")
    List<Object[]> getFirstNameAndLastNameOfPersonByAge(@Param("age") int age);

    // Ques 8: Get complete information of the Employee whose age is 25 using @Query.
    @Query("select p from Person p where age = :age")
    Person[] getPersonByAge(@Param("age") Integer age);

    // Ques 9: Count Person where name is "Peter" using @Query.
    @Query("select count(*) from Person where firstName = :firstName")
    Integer countByName(@Param("firstName") String firstName);

    /**
     * Ques 10: Implement following methods for Person repository:
     *          count
     *          distinct
     *          or
     *          and
     *          between
     *          LessThan
     *          GreaterThan
     *          Like
     *          Not
     *          In
     *          IgnoreCase
     */

    Integer countPersonByAge(Integer age);

    Person[] findDistinctByLastName(String lastName);

    Person[] findByFirstNameOrAge(String firstName, Integer age);

    Person[] findByFirstNameAndSalary(String firstName, Integer salary);

    Person[] findByAgeBetween(int min, int max);

    Person[] findBySalaryLessThan(int salary);

    Person[] findByAgeGreaterThan(int age);

    Person[] findByFirstNameLike(String name);

    Person[] findByAgeNot(int age);

    Person[] findByFirstNameIn(List<String> firstNames);

    Person[] findByFirstNameIgnoreCase(String name);

    // Ques 11: Get the persons greater than age 25 and sort them in descending order according to id by method query.
    Person[] findByAgeGreaterThanOrderByIdDesc(int age);

    // Ques 12: Do  the question above using the Sort class.
    Person[] findAllByAgeGreaterThan(Sort sort, int age);

    // Ques 13: Apply Pagination on Person entities.
    Page<Person> findAll(Pageable pageable);
}