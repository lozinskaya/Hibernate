package ru.javastudy.hibernate.dao.implementations;

import org.hibernate.Session;
import ru.javastudy.hibernate.dao.StudentEntity;
import ru.javastudy.hibernate.dao.interfaces.StudentDAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Session session;

    public List<StudentEntity> findAll() {
        return session.createQuery("from StudentEntity c").list();
    }

    public StudentEntity findById(Long id) {
        return (StudentEntity) session.createQuery("from StudentEntity where id = :id").
                setParameter("id", id).uniqueResult();
    }

    public List findСontainsA() {
        return session.createQuery(
                "select s " +
                           "from StudentEntity s " +
                           "where s.person.lastName like :par " +
                                "or s.person.firstName like :par " +
                                "or s.person.middleName like :par " +
                                "order by s.person.id").
                setParameter("par", "%а%").list();
    }

    public List<StudentEntity> findСontainsAUsingCriteria() {
//        Criteria criteria = session.createCriteria(StudentEntity.class);
//        criteria.createAlias("person", "person");
//        criteria.add(Restrictions.like("person.firstName","%а%"));
//        criteria.add(Restrictions.or(
//                Restrictions.like("person.lastName","%а%"))
//        );
//        criteria.add(Restrictions.or(
//                Restrictions.like("person.middleName","%а%"))
//        );
//
//        return criteria.list();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteria = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteria.from(StudentEntity.class);
        criteria.select(root);
        criteria.where(cb.or(
                cb.like(root.get("person").<String>get("lastName"),"%а%"),
                cb.like(root.get("person").<String>get("firstName"),"%а%"),
                cb.like(root.get("person").<String>get("middleName"),"%а%")
        ));
        criteria.orderBy(cb.asc(root.get("person").get("id")));

        return session.createQuery(criteria).getResultList();
    }

    public List<StudentEntity> findNullRecordBookCriteria() {
        // C помощью createCriteria
//        Criteria criteria = session.createCriteria(StudentEntity.class);
//        criteria.add(Restrictions.isNull("recordBook"));
//
//        return criteria.list();

        // С помощью getCriteriaBuilder
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteria = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteria.from(StudentEntity.class);
        criteria.select(root);
        criteria.where(cb.isNull(root.get("recordBook")));

        return session.createQuery(criteria).getResultList();
    }

    public List<StudentEntity> findNullRecordBook() {
        return session.createQuery(
                "select s " +
                        "from StudentEntity s " +
                        "where s.recordBook is null").list();
    }

    public StudentEntity save(StudentEntity contact) {
        return null;
    }

    public void delete(StudentEntity contact) {}

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
