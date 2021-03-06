package ru.javastudy.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.javastudy.hibernate.dao.*;
import ru.javastudy.hibernate.dao.implementations.ContactDAOImpl;
import ru.javastudy.hibernate.dao.implementations.PersonDAOImpl;
import ru.javastudy.hibernate.dao.implementations.RecordBookDAOImpl;
import ru.javastudy.hibernate.dao.interfaces.PersonDAO;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nick on 05.09.2015.
 */
public class AppMain {

    @PersistenceUnit
    static EntityManager emf;

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        // Задание 1: начало
        String[] firstNames = {"Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"};
        String[] middleName = {"Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич", "Сергеевич", "Викторович", "Михайлович", "Артемович", "Андреевич"};
        String[] lastNames = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"};

        // Генерация 10 персон
        System.out.println("Generation persons: start");
        for (int i = 0; i < 10; i++) {
            PersonEntity personEntity = new PersonEntity();

            personEntity.setFirstName(firstNames[(int) (Math.random()*10)]);
            personEntity.setLastName(lastNames[(int) (Math.random()*10)]);
            personEntity.setMiddleName(middleName[(int) (Math.random()*10)]);
            // Генерация чисел [1000,9999]
            personEntity.setPassportNumber(1000 + (int) ( Math.random() * 8999 ));
            // Генерация чисел [100000,999999]
            personEntity.setPassportSeria(100000 + (int) ( Math.random() * 899999 ));
            session.save(personEntity);
        }
        System.out.println("Generation persons: completed");

        // Генерация n зачетных книжек
        int n = 1 + (int) (Math.random()*10);
        System.out.println("Generation recordBooks: start");
        for (int i = 0; i < n; i++) {
            RecordBookEntity recordBookEntity = new RecordBookEntity();

            recordBookEntity.setCode(100000000 + (int) ( Math.random() * 899999999 ));
            session.save(recordBookEntity);
        }
        System.out.println("Generation recordBooks: completed");

        // Генерация 10 студентов
        System.out.println("Generation students: start");
        //Счётчик количества зачётных книжек
        int numberRecordBook = 1;

        //Получение списка пользователей
        PersonDAOImpl personDAO = new PersonDAOImpl();
        personDAO.setSession(session);
        List<PersonEntity> persons = personDAO.findAll();
        //Перемешиваем список персон
        Collections.shuffle(persons);

        //Получение списка зачётных книжек
        RecordBookDAOImpl recordBookDAO = new RecordBookDAOImpl();
        recordBookDAO.setSession(session);
        List<RecordBookEntity> recordBooks = recordBookDAO.findAll();
        //Перемешиваем список зачётных книжек
        Collections.shuffle(recordBooks);

        for (int i = 0; i < 10; i++) {
            StudentEntity studentEntity = new StudentEntity();

            String group = "РИМ-"+(100000 + (int) ( Math.random() * 899999 ));
            studentEntity.setGrup(group);

            studentEntity.setPerson(persons.get(i));

            //Проверка, что зачётные книжки ещё есть (счётчик меньше либо равен количеству книжек)
            if (numberRecordBook <= n) {
                studentEntity.setRecordBook(recordBooks.get(i));

                numberRecordBook++;
            }

            session.save(studentEntity);
        }
        System.out.println("Generation students: completed");

        session.getTransaction().commit();

        // Задание 1: конец

//        ContactEntity contactEntity = new ContactEntity();
//
//        contactEntity.setBirthDate(new java.util.Date());
//        contactEntity.setFirstName("Ivan");
//        contactEntity.setLastName("Petrov");
//        session.save(contactEntity);
//
//        ContactTelDetailEntity contactTelDetail = new ContactTelDetailEntity();
//
//        contactTelDetail.setTelNumber("84884848");
//        contactTelDetail.setTelType("home");
//        contactEntity.addContactTelDetail(contactTelDetail);
//        session.save(contactTelDetail);

//        Query query = session.createQuery("from ContactEntity where firstName = :paramName");
//        query.setParameter("paramName", "Nick");
//        List list = query.list();

//        ContactDAOImpl contactDAO = new ContactDAOImpl();
//        contactDAO.setSession(session);

        Transaction tx = session.beginTransaction();

//        List<ContactEntity> contacts = contactDAO.findAll();
//        for (ContactEntity contact : contacts) {
//            System.out.println(contact);
//        }
//
//        listContactsWithDetail(contacts);

        tx.commit();
        session.close();

    }

    private static void listContactsWithDetail(List<ContactEntity> contacts) {
        System.out.println("Contact with detail info");
        for (ContactEntity contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetailEntity detailedContact : contact.getContactTelDetails()) {
                    System.out.println(detailedContact);
                }
            }
        }
    }

}
