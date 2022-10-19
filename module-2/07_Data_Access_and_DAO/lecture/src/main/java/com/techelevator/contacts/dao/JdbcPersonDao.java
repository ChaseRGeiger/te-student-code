package com.techelevator.contacts.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/*
    Determine query in pgAdmin - determine input
    and how many results you can expect(none, 0-many rows,
    or a single result)

    CALL jdbcTemplate
        IF 0-many results use queryForRowSet()
        IF single column and row result use queryForObject
        IF no results use update()

    If you called update() you are done
    If you called queryForObject() then result will be in the object and you are done
    If you called queryForRowSet() then a SqlRowSet was returned, then go to next step

    On the SqlRowSet call next(), if true map the row to the data object, if false you are done
    repeat until next() is false

    SELECT - always queryForRowSet()
    UPDATE/DELETE - always update()
    INSERT with RETURNING - use queryForObject()
    INSERT without RETURNING - use update()
 */

public class JdbcPersonDao implements PersonDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
        Select all rows from a table
     */
    @Override
    public List<Person> getAllPersons() {
        List<Person> allPersons = new ArrayList<Person>();
        String sql = "SELECT person_id, first_name, last_name, last_updated, date_added FROM person";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Person personMappedFromResultRow = mapRowToPerson(results);
            allPersons.add(personMappedFromResultRow);
        }
        return allPersons;
    }

    /*
        Select from table with where clause that has parameters
        if only one row is returned can use if(results.next())
        if multiple rows can be returned must use while loop instead

     */

    @Override
    public Person getPersonById(long personId) {
        Person person = null;
        String sql = "SELECT person_id, first_name, last_name, last_updated, date_added FROM person " +
                "WHERE person_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
        if(results.next()){
            person = mapRowToPerson(results);
        }
        return person;
    }

    /*
        INSERT when you need the generated id back
     */

    @Override
    public Person addPerson(Person personToAdd) {
        String sql = "INSERT INTO person (person_id, first_name, last_name, last_updated, date_added) " +
                "VALUES(DEFAULT, ?, ?, ?, ?) RETURNING person_id";

        Long personId = jdbcTemplate.queryForObject(sql, Long.class, personToAdd.getFirstName(),
                personToAdd.getLastName(), personToAdd.getLastUpdated(), personToAdd.getDateAdded());

        personToAdd.setPersonId(personId);

        return personToAdd;

    }

    @Override
    public void updatePerson(Person personToUpdate) {
        String sql = "UPDATE person " +
                "SET first_name = ?, last_name = ?, last_updated = current_timestamp " +
                "WHERE person_id = ?";
        jdbcTemplate.update(sql, personToUpdate.getFirstName(), personToUpdate.getLastName(), personToUpdate.getPersonId());


    }

    @Override
    public void deletePerson(long personId) {
        String sql = "DELETE FROM person WHERE person_id = ?";

        jdbcTemplate.update(sql, personId);
    }

    private Person mapRowToPerson(SqlRowSet row){

        Person person = new Person();

        person.setPersonId(row.getLong("person_id"));
        person.setFirstName((row.getString("first_name")));
        person.setLastName((row.getString("last_name")));
        if(row.getDate("last_updated") != null) {
            person.setLastUpdated(row.getDate("last_updated").toLocalDate());
        }
        if(row.getDate("date_added") != null) {
            person.setDateAdded(row.getDate("date_added").toLocalDate());
        }

        return person;

    }
}
