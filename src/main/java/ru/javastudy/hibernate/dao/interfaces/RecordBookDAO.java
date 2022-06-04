package ru.javastudy.hibernate.dao.interfaces;

import ru.javastudy.hibernate.entity.RecordBookEntity;

import java.util.List;

public interface RecordBookDAO {

    // Найти все зачетные книжки.
    public List<RecordBookEntity> findAll();

    // Найти зачетную книжку со всеми деталями по идентификатору.
    public RecordBookEntity findById(Long id);

    // Вставить или обновить зачетную книжку.
    public RecordBookEntity save(RecordBookEntity person);

    // Удалить зачетную кникжу.
    public void delete(RecordBookEntity person);
}