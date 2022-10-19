package com.techelevator.contacts.dao;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPersons();
    Person getPersonById(long personId);
    Person addPerson(Person personToAdd);
    void updatePerson(Person personToUpdate);
    void deletePerson(long personId);

}
