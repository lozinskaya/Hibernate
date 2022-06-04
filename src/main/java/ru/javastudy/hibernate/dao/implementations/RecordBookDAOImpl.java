package ru.javastudy.hibernate.dao.implementations;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.RecordBookEntity;
import ru.javastudy.hibernate.dao.interfaces.RecordBookDAO;

import java.util.List;

public class RecordBookDAOImpl implements RecordBookDAO {

    private Session session;

    public List<RecordBookEntity> findAll() {
        return session.createQuery("from RecordBookEntity c").list();
    }

    public RecordBookEntity findById(Long id) {
        return (RecordBookEntity) session.createQuery("from RecordBookEntity where id = :id").
                setParameter("id", id).uniqueResult();
    }

    public RecordBookEntity save(RecordBookEntity contact) {
        return null;
    }

    public void delete(RecordBookEntity contact) {}

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
