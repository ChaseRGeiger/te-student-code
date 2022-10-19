package com.techelevator.contacts;

import com.techelevator.contacts.dao.JdbcPersonDao;
import com.techelevator.contacts.dao.Person;
import com.techelevator.contacts.dao.PersonDao;
import org.apache.commons.dbcp2.BasicDataSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {

    private static final Scanner in = new Scanner(System.in);

    public void run() {
        // Create DataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/contacts");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        PersonDao personDao = new JdbcPersonDao(dataSource);

        // Get a list of all persons and show them
        List<Person> personList = personDao.getAllPersons();

        System.out.println(personList);

        // Get one person by id and display it
        int idOfPersonToGet = getPersonIdFromUser();
        Person personFromDatabase = personDao.getPersonById(idOfPersonToGet);

        System.out.println(personFromDatabase);

        // Add a person
        Person personToAdd = new Person();
        personToAdd.setFirstName("Matt");
        personToAdd.setLastName("Eland");
        personToAdd.setLastUpdated(LocalDate.now());
        personToAdd.setDateAdded(LocalDate.now());

        Person personAdded = personDao.addPerson(personToAdd);

        // Update the person just added
        personAdded.setFirstName("MATT");
        personAdded.setLastName("ELAND");
        personDao.updatePerson(personAdded);

        // Delete a person by id
        personDao.deletePerson( personAdded.getPersonId() );
    }

    private int getPersonIdFromUser() {
        System.out.print("Person id >>>");
        return Integer.parseInt( in.nextLine() );
    }


    public static void main(String[] args) {
        new ContactsApp().run();
    }
}
