package ru.javastudy.hibernate.dao.implementations;

import net.sf.ehcache.hibernate.HibernateUtil;
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

    public List<StudentEntity> findСontainsA() {
        return session.createQuery(
                "select s " +
                           "from StudentEntity s " +
                           "inner join s.person " +
                           "where s.person.lastName like ?1 " +
                                "or s.person.firstName like ?1 " +
                                "or s.person.middleName like ?1 ").
                setParameter("1", "%а%").list();
    }

//    public List<StudentEntity> findСontainsAUsingCriteria() {
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<StudentEntity> criteria = cb.createQuery(StudentEntity.class);
//        Root<StudentEntity> root = criteria.from(StudentEntity.class);
//        criteria.select(root);
//
//        return session.createQuery(criteria).list();
//    }

    public List<StudentEntity> findNullRecordBook() {
        return session.createQuery(
                        "select s " +
                                "from StudentEntity s " +
                                "inner join s.recordBook " +
                                "where s.recordBook is not null").list();
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
