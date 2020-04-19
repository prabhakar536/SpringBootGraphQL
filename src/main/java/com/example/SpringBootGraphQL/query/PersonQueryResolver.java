package com.example.SpringBootGraphQL.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.SpringBootGraphQL.model.Person;
import com.example.SpringBootGraphQL.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonQueryResolver implements GraphQLQueryResolver {
    private PersonService personService;

    public PersonQueryResolver(PersonService personService) {
        this.personService = personService;
    }

    public Collection<Person> people()
    {
        return personService.getPeople();
    }
}
