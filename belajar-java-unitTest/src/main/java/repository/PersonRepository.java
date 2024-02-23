package repository;

import data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);
}
