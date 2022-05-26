package ru.javastudy.hibernate.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {
    private Long id;
    private String ac_group;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ac_group", nullable = false, insertable = true, updatable = true, length = 40)
    public String getAc_group() { return ac_group; }

    public void setAc_group(String ac_group) { this.ac_group = ac_group; }

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

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", person=" + this.getPerson() +
                ", recordBook=" + this.getRecordBook() +
                ", ac_group='" + ac_group + '\'' +
                '}';
    }
}