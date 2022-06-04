package ru.javastudy.hibernate.entity.listeners;

import ru.javastudy.hibernate.entity.RecordBookEntity;

import javax.persistence.PreRemove;

public class RecordBookEntityListener {
    @PreRemove
    private void beforeRemove (RecordBookEntity recordBookEntity) {
        System.out.println("REMOVE " + recordBookEntity);
    }
}
