package ru.javastudy.hibernate.dao.interfaces;

import ru.javastudy.hibernate.dao.ContactEntity;
import ru.javastudy.hibernate.dao.PersonEntity;

import java.util.List;

public interface PersonDAO {

    // Найти все персоны.
    public List<PersonEntity> findAll();

    // Найти персону со всеми деталями по идентификатору.
    public PersonEntity findById(Long id);

    // Вставить или обновить персону.
    public PersonEntity save(PersonEntity person);

    // Удалить персону.
    public void delete(PersonEntity person);
}