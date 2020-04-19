package com.example.SpringBootGraphQL.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.SpringBootGraphQL.model.Person;
import com.example.SpringBootGraphQL.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonMutationResolver implements GraphQLMutationResolver {
    private PersonService personService;

    public CreatePersonMutationResolver(PersonService personService) {
        this.personService = personService;
    }
    public Person createPerson(String firstName, String lastName)
    {
        return personService.createPerson(firstName,lastName);
    }
}
