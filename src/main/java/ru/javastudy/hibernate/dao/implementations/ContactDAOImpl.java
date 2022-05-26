package ru.javastudy.hibernate.dao.implementations;

import org.hibernate.Session;
import ru.javastudy.hibernate.dao.ContactEntity;
import ru.javastudy.hibernate.dao.interfaces.ContactDAO;

import java.util.List;

/**
 * Created by Nick on 06.09.2015.
 */
public class ContactDAOImpl implements ContactDAO {

    private Session session;

    public List<ContactEntity> findAll() {
        return session.createQuery("from ContactEntity c").list();
    }

    public List<ContactEntity> findAllWithDetail() {
        return null;
    }

    public ContactEntity findById(Long id) {
        return null;
    }

    public ContactEntity save(ContactEntity contact) {
        return null;
    }

    public void delete(ContactEntity contact) {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
