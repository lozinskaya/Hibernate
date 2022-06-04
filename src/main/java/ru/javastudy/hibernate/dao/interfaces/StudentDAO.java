package ru.javastudy.hibernate.dao.interfaces;

import ru.javastudy.hibernate.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {

    // Найти всех студентов.
    public List<StudentEntity> findAll();

    // Найти студента со всеми деталями по идентификатору.
    public StudentEntity findById(Long id);

    // Вставить или обновить студента.
    public StudentEntity save(StudentEntity person);

    // Удалить студента.
    public void delete(StudentEntity person);
}