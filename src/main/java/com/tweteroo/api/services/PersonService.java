package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.PersonDTO;
import com.tweteroo.api.model.Person;
import com.tweteroo.api.repositories.PersonRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void save(PersonDTO req) {
        repository.save(new Person(req));
    }
}
