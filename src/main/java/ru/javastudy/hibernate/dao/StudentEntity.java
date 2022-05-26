package ru.javastudy.hibernate.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {
    private Long id;
    private String grup;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "group", nullable = false, insertable = true, updatable = true, length = 10)
//    public String getGroup() {
//        return group;
//    }
//
//    public void setGroup(String group) {
//        this.group = group;
//    }

    @Basic
    @Column(name = "grup", nullable = false, insertable = true, updatable = true, length = 40)
    public String getGrup() { return grup; }

    public void setGrup(String grup) { this.grup = grup; }

    /*
     * Many To One
     */

    private RecordBookEntity recordBook;
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "record_book_id")
    public RecordBookEntity getRecordBook() { return recordBook; }

    public void setRecordBook(RecordBookEntity recordBook) { this.recordBook = recordBook; }

    @ManyToOne
    @JoinColumn(name = "person_id")
    public PersonEntity getPerson() { return person; }

    public void setPerson(PersonEntity person) { this.person = person; }
}