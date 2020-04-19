package com.example.SpringBootGraphQL.service;

import com.example.SpringBootGraphQL.model.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class PersonService {
    private static int INDEXT_COUNT = 0;
    private final Collection<Person> people = new ConcurrentLinkedQueue<>();

    public PersonService() {
    }

    public Person createPerson(String firstName, String lastName)
    {
        Person person = new Person(++INDEXT_COUNT,firstName, lastName);
        people.add(person);
        return person;
    }

    public Collection<Person> getPeople()
    {
        return Collections.unmodifiableCollection(people);
    }

}
