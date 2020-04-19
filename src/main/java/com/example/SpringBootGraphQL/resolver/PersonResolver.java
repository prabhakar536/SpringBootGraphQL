package com.example.SpringBootGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.SpringBootGraphQL.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonResolver implements GraphQLResolver<Person> {
    public String fullName(Person person)
    {
        return person.getFirstName()+" "+person.getLastName();
    }
}
