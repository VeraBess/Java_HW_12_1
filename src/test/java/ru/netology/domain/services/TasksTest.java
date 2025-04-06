package ru.netology.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    // МЕТОД MATСHES ДЛЯ SimpleTask

    @Test
    public void falseQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "сходить в магазин");

        boolean expected = false;
        boolean actual = simpleTask.matches("Ложный запрос");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void trueQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "сходить в магазин");

        boolean expected = true;
        boolean actual = simpleTask.matches("сходить в магазин");
        Assertions.assertEquals(expected, actual);
    }

    // МЕТОД MATСHES ДЛЯ Epic
    @Test
    public void trueQueryEpic() {
        String[] subtasks = {"яйца", "Хлеб", "Молоко"};
        Epic epic = new Epic(11, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void falseQueryEpic() {
        String[] subtasks = {"яйца", "Хлеб", "Молоко"};
        Epic epic = new Epic(11, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Ложный запрос");
        Assertions.assertEquals(expected, actual);
    }

    // МЕТОД MATCHES ДЛЯ Meeting
    @Test
    public void trueQueryMeetingTopic() {
        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        boolean expected = true;
        boolean actual = meeting.matches("Выпуск версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void trueQueryMeetingProject() {
        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        boolean expected = true;
        boolean actual = meeting.matches("Нетобанк");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void falseQueryMeeting() {
        Meeting meeting = new Meeting(111, "Выпуск версии приложения", "Нетобанк", "В среду утром");

        boolean expected = false;
        boolean actual = meeting.matches("Ложный запрос");
        Assertions.assertEquals(expected, actual);
    }
}
