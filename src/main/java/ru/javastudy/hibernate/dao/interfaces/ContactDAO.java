package ru.javastudy.hibernate.dao.interfaces;

import ru.javastudy.hibernate.dao.ContactEntity;

import java.util.List;

/**
 * Created by Nick on 06.09.2015.
 */
public interface ContactDAO {

    // Найти все контакты.
    public List<ContactEntity> findAll();

    // Найти все контакты с заданным телефоном и хобби.
    public List<ContactEntity> findAllWithDetail();

    // Найти контакт со всеми деталями по идентификатору.
    public ContactEntity findById(Long id);

    // Вставить или обновить контакт.
    public ContactEntity save(ContactEntity contact);

    // Удалить контакт.
    public void delete(ContactEntity contact);
}