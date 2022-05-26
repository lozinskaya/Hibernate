package ru.javastudy.hibernate.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "record_book")
public class RecordBookEntity implements Serializable {
    private Long id;
    private int code;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, insertable = true, updatable = true, unique = true, length = 10)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RecordBookEntity{" +
                "id=" + id +
                ", code=" + code +
                '}';
    }
}