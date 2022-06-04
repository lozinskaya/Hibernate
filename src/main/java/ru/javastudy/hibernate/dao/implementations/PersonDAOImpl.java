package ru.javastudy.hibernate.dao.implementations;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.PersonEntity;
import ru.javastudy.hibernate.dao.interfaces.PersonDAO;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private Session session;

    public List<PersonEntity> findAll() {
        return session.createQuery("from PersonEntity c").list();
    }

    public PersonEntity findById(Long id) {
        return session.get(PersonEntity.class, id);
//        return (PersonEntity) session.createQuery("from PersonEntity where id = :id").
//                setParameter("id", id).uniqueResult();
    }

    public PersonEntity save(PersonEntity contact) {
        return null;
    }

    public void delete(PersonEntity contact) {}

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
