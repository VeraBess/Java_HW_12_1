package ru.netology.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void trueSearch() {

        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.findAll();

        String[] expected = epic.subtasks;    // { "Молоко", "Яйца", "Хлеб" };
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }


    
   /* @Test
    public void falseSearch() {

        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        String[] expected = {};
        Task[] actual = todos.search("Ложный запрос");

        Assertions.assertArrayEquals(expected, actual);
    }*/
}
