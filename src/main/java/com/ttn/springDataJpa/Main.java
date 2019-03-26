package com.ttn.springDataJpa;

import com.ttn.springDataJpa.entity.Person;
import com.ttn.springDataJpa.service.PersonService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();

        // Ques 3: Perform all the methods inside CrudRepository for Person Class.

        Person person1 = new Person("nitin", "maurya", 22, 15000);
        personService.createPerson(person1);

        Person person2 = new Person("Prafull", "Bansal", 25, 15000);
        Person person3 = new Person("Raman", "Sharma", 32, 15000);
        Person person4 = new Person("Prashant", "Sharma", 25, 15000);
        Person person5 = new Person("Pranav", "Shukla", 25, 15000);
        Person person6 = new Person("Ankit", "Tripathi", 42, 15000);
        Person person7 = new Person("Keshav", "Sharma", 25, 15000);
        Person person8 = new Person("Peter", "Dinklage", 29, 15000);
        Person person9 = new Person("Mohit", "Singh", 20, 15000);
        Person person10 = new Person("Manish", "Singh", 25, 15000);

        List<Person> personList = Arrays.asList(
                person2,
                person3,
                person4,
                person5,
                person6,
                person7,
                person8,
                person9,
                person10);
        personService.createPerson(personList);

        System.out.println(personService.getPerson(5));
        System.out.println(personService.personExists(14));
        System.out.println("All persons: " + personService.getAllPersons());
        System.out.println(personService.getAllPersonsHavingIds(Arrays.asList(1,5,8,3)));
        System.out.println(personService.countPerson());

        System.out.println("All persons: " + personService.getAllPersons());
        personService.deletePersonById(9);
        System.out.println("All persons: " + personService.getAllPersons());
        personService.deletePerson(person4);
        System.out.println("All persons: " + personService.getAllPersons());
        personService.deletePersons(Arrays.asList(person2, person7, person5));
        System.out.println("All persons: " + personService.getAllPersons());
        personService.deleteAllPersons();
        System.out.println("All persons: " + personService.getAllPersons());

        personService.createPerson(personList);

        // Ques 5: Use the methods declared in Ques 4 to fetch the person.

        System.out.println(Arrays.toString(personService.getPersonByFirstName("Ankit")));

        System.out.println(Arrays.toString(personService.getPersonByLastName("Sharma")));

        System.out.println(personService.getPersonById(17));

        // Ques 6: Use @Query to fetch firstname of the Person whose age is 25.

        System.out.println(Arrays.toString(personService.getFirstNameOfPersonByAge(25)));

        // Ques 7: Use @Query to fetch firstname and lastname of the Person whose age is 25.
        personService.getFirstAndLastNameOfPersonByAge(25).forEach(p -> System.out.println(Arrays.toString(p)));

        // Ques 8: Get complete information of the Employee whose age is 25 using @Query.
        System.out.println(Arrays.toString(personService.getPersonByAge(25)));

        // Ques 9: Count Person where name is "Peter" using @Query.
        System.out.println(personService.countPersonByName("Peter"));

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

        System.out.println(personService.countPersonByAge(25));
        System.out.println(Arrays.toString(personService.findDistinctPersonsByLastName("Sharma")));
        System.out.println(Arrays.toString(personService.findPersonByFirstNameOrAge("Pranav", 25)));
        System.out.println(Arrays.toString(personService.findPersonByFirstNameAndSalary("Mohit", 15000)));
        System.out.println(Arrays.toString(personService.findPersonBetweenAge(20, 27)));
        System.out.println(Arrays.toString(personService.findPersonHavingSalaryLessThan(13000)));
        System.out.println(Arrays.toString(personService.findPersonHavingAgeGreaterThan(25)));
        System.out.println(Arrays.toString(personService.findPersonLikeFirstName("%ra%"))); //
        System.out.println(Arrays.toString(personService.findPersonNotHavingAge(25)));
        System.out.println(Arrays.toString(personService.findPersonByFirstNameIn(Arrays.asList("Prashant", "Vishal")))); //
        System.out.println(Arrays.toString(personService.findPersonByFirstNameIgnoredCase("ANKIT")));

        // Ques 11: Get the persons greater than age 25 and sort them in descending order according to id by method query.
        System.out.println(Arrays.toString(personService.getPersonsGreaterThanAgeInDescending(25)));

        // Ques 12: Do  the question above using the Sort class.
        System.out.println(Arrays.toString(personService.getPersonsByAgeGreaterThan(25)));

        // Ques 13: Apply Pagination on Person entities.
        System.out.println(personService.getPersonPage(2));
    }
}
