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
    public void trueSearchEpic() {  //запрос есть в Epic

        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void trueSearchSimpletask() {  //запрос есть в simpletask

        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("магазин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void trueSearchMeeting() { //запрос есть в meeting
        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выпуск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void trueSearchSimpletaskEpic() { //запросесть в двух задачах

        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void trueSearchSimpletaskEpicMeeting() { //запрос есть в трех задачах

        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Хлебобанк", "В среду утром");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void falseSearch() { // запроса нет ни в одной задаче

        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);

        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.search("Ложный запрос");

        Assertions.assertArrayEquals(expected, actual);
    }
}
