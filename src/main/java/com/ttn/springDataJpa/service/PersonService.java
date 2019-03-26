package com.ttn.springDataJpa.service;

import com.ttn.springDataJpa.config.PersistenceContext;
import com.ttn.springDataJpa.entity.Person;
import com.ttn.springDataJpa.repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PersonService {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
    PersonRepository personRepository = context.getBean(PersonRepository.class);



//    public void getPersonNameById(int id){
//        System.out.println(personRepository.findById(id));
//    }
//
//    public void getPersonIdAndNameById(int id){
//        System.out.println(personRepository.findById(id));
//    }
//
//
//    public void countPersonsByName(String name){
//        System.out.println(personRepository.countByName(name));
//    }
//
//    public void getPersonByName(String name){
//        System.out.println(personRepository.findByNameIs("nitin"));
//    }
//
//    public void getPersonsBySalary(int salary){
//        System.out.println(personRepository.findAllBySalary(salary));
//    }
//
//    public void getPersonListByNameInDescending(String name){
//        System.out.println(personRepository.findByNameOrderByIdDesc(name));
//    }



    // Ques 3: Perform all the methods inside CrudRepository for Person Class.

    public void createPerson(Person person){
        personRepository.save(person);
    }

    public void createPerson(List<Person> persons){
        personRepository.save(persons);
    }

    public Person getPerson(int id){
        return personRepository.findOne(id);
    }

    public boolean personExists(int id){
        return personRepository.exists(id);
    }

    public List<Person> getAllPersons(){
        return (List<Person>)personRepository.findAll();
    }

    public List<Person> getAllPersonsHavingIds(List<Integer> ids){
        return (List<Person>)personRepository.findAll(ids);
    }

    public long countPerson(){
        return personRepository.count();
    }

    public void deletePersonById(int id){
        personRepository.delete(id);
    }

    public  void deletePerson(Person person){
        personRepository.delete(person);
    }

    public void deletePersons(List<Person> personList){
        personRepository.delete(personList);
    }

    public void deleteAllPersons(){
        personRepository.deleteAll();
    }

    // Ques 5: Use the methods declared in Ques 4 to fetch the person.
    public Person[] getPersonByFirstName(String firstName){
        return personRepository.findByFirstName(firstName);
    }

    public Person[] getPersonByLastName(String lastName){
        return personRepository.findByLastName(lastName);
    }

    public Person getPersonById(Integer id){
        return personRepository.findById(id);
    }

    // Ques 6: Use @Query to fetch firstname of the Person whose age is 25.
    public String[] getFirstNameOfPersonByAge(Integer age){
        return personRepository.getFirstNameOfPersonByAge(age);
    }

    // Ques 7: Use @Query to fetch firstname and lastname of the Person whose age is 25.
    public List<Object[]> getFirstAndLastNameOfPersonByAge(Integer age){
        return personRepository.getFirstNameAndLastNameOfPersonByAge(age);
    }

    // Ques 8: Get complete information of the Employee whose age is 25 using @Query.
    public Person[] getPersonByAge(Integer age){
        return personRepository.getPersonByAge(age);
    }

    // Ques 9: Count Person where name is "Peter" using @Query.
    public Integer countPersonByName(String name){
        return personRepository.countByName(name);
    }

    // Ques 11: Get the persons greater than age 25 and sort them in descending order according to id by method query.
    public Person[] getPersonsGreaterThanAgeInDescending(int age){
        return personRepository.findByAgeGreaterThanOrderByIdDesc(age);
    }

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

    public Integer countPersonByAge(int age){
        return personRepository.countPersonByAge(age);
    }

    public Person[] findDistinctPersonsByLastName(String lastName){
        return personRepository.findDistinctByLastName(lastName);
    }

    public Person[] findPersonByFirstNameOrAge(String firstName, int age){
        return personRepository.findByFirstNameOrAge(firstName, age);
    }

    public Person[] findPersonByFirstNameAndSalary(String firstName, Integer salary){
        return personRepository.findByFirstNameAndSalary(firstName, salary);
    }

    public Person[] findPersonBetweenAge(int min, int max){
        return personRepository.findByAgeBetween(min, max);
    }

    public Person[] findPersonHavingSalaryLessThan(int salary){
        return personRepository.findBySalaryLessThan(salary);
    }

    public Person[] findPersonHavingAgeGreaterThan(int age){
        return personRepository.findByAgeGreaterThan(age);
    }

    public Person[] findPersonLikeFirstName(String firstName){
        return personRepository.findByFirstNameLike(firstName);
    }

    public Person[] findPersonNotHavingAge(int age){
        return personRepository.findByAgeNot(age);
    }

    public Person[] findPersonByFirstNameIn(List<String> firstNames){
        return personRepository.findByFirstNameIn(firstNames);
    }

    public Person[] findPersonByFirstNameIgnoredCase(String firstName){
        return personRepository.findByFirstNameIgnoreCase(firstName);
    }

    // Ques 12: Do  the question above using the Sort class.
    public Person[] getPersonsByAgeGreaterThan(int age){
        return personRepository.findAllByAgeGreaterThan(new Sort(Sort.Direction.DESC, "id"), age);
    }

    // Ques 13: Apply Pagination on Person entities.
    public List<Person> getPersonPage(int page){
        System.out.println("\nPage: " + page);
        Page<Person> personPage =  personRepository.findAll(new PageRequest(page,3));
        return personPage.getContent();
    }
}
