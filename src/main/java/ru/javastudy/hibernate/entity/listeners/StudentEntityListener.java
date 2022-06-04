package ru.javastudy.hibernate.entity.listeners;

import ru.javastudy.hibernate.entity.StudentEntity;

import javax.persistence.PreRemove;

public class StudentEntityListener {
    @PreRemove
    private void beforeRemove (StudentEntity studentEntity) {
        System.out.println("REMOVE " + studentEntity);
    }
}
