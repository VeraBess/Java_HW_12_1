package ru.netology.domain.services;

import java.util.Objects;

//РОДИТЕЛЬ
public class Task {
    protected int id;
    protected String query;

    public Task(String query) {
        this.query = query;
    }

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getQuery() {
        return query;
    }

    /**
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя
     *
     * @param query Поисковый запрос
     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
     */
    public boolean matches(String query) {
        return false;
    }

    // Ниже находятся вспомогательные методы для корректной работы equals
    // Переопределять их в наследниках не нужно

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
