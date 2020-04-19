package com.example.SpringBootGraphQL.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloQueryResolver implements GraphQLQueryResolver {

    public String hello()
    {
        return "Hello, GraphQL......";
    }

    public String say(String str)
    {
        return String.format("Hello %s!", Optional.ofNullable(str).orElse("GraphQL....!"));
    }
}
