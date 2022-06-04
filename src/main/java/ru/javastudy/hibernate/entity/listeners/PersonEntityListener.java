package ru.javastudy.hibernate.entity.listeners;

import ru.javastudy.hibernate.entity.PersonEntity;

import javax.persistence.PreRemove;

public class PersonEntityListener {
    @PreRemove
    private void beforeRemove (PersonEntity personEntity) {
        System.out.println("REMOVE " + personEntity);
    }
}
