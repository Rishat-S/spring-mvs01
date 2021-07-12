package ru.lsz.dao;

import org.springframework.stereotype.Component;
import ru.lsz.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDAO {
    private static int id;
    private List<Person> people;

    {
        people = new ArrayList<>(Arrays.asList(
                new Person(++id, "Nick"),
                new Person(++id, "Rusik"),
                new Person(++id, "Olga"),
                new Person(++id, "Mariya")
        ));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

}
