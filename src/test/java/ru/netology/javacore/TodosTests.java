package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TodosTests {

    protected List<String> tasks;

    @Test
    void addTask() {
        tasks = new ArrayList<>();
        String expected = "7";
        String[] taskMassive = {"1", "2", "3", "4", "5", "6", "7", "8"};
        for (String task : taskMassive) {
            tasks.add(task);
        }
        String result = tasks.get(6);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void addMaxTasks() {
        tasks = new ArrayList<>();
        int maxTasks = 2;
        boolean result = false;
        String[] taskString = {"1", "2", "3"};
        for (String task : taskString) {
            if (tasks.size() <= maxTasks - 1) {
                tasks.add(task);
            } else result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    void removeTask() {
        tasks = new ArrayList<>();
        String expected = "2";
        String[] taskMassive = {"1", "2"};
        for (String task : taskMassive) {
            tasks.add(task);
        }
        tasks.remove("1");
        String result = tasks.get(0);
        Assertions.assertEquals(expected, result);
    }
}
