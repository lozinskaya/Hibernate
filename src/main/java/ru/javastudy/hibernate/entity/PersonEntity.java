package ru.javastudy.hibernate.entity;

import ru.javastudy.hibernate.entity.listeners.PersonEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(PersonEntityListener.class)
@Table(name = "person")
public class PersonEntity implements Serializable{
    private Long id;
    private int passportSeria;
    private int passportNumber;
    private String lastName;
    private String firstName;
    private String middleName;

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
    @Column(name = "passportSeria", nullable = false, insertable = true, updatable = true, unique = true, length = 4)
    public int getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(int passportSeria) {
        this.passportSeria = passportSeria;
    }

    @Basic
    @Column(name = "passportNumber", nullable = false, insertable = true, updatable = true, unique = true, length = 6)
    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "lastName", nullable = false, insertable = true, updatable = true, length = 40)
    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @Basic
    @Column(name = "firstName", nullable = false, insertable = true, updatable = true, length = 60)
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Basic
    @Column(name = "middleName", nullable = false, insertable = true, updatable = true, length = 40)
    public String getMiddleName() { return middleName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", passportNumber=" + passportNumber +
                ", passportSeria=" + passportSeria +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

}