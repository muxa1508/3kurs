package ru.netology.javacore.resources;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    protected List<String> tasks;
    protected int maxTasks = 7;

    public Todos() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        if (tasks.size() <= maxTasks - 1) {
            tasks.add(task);
            System.out.println("Задача " + task + " добавлена");
        } else System.out.println("Нельзя добавить задачу. Достигнуто максимальное количество.");
    }

    public void removeTask(String task) {
        tasks.remove(task);
        System.out.println("Задача " + task + " удалена");
    }

    public String getAllTasks() {
        List<String> outputTasks = new ArrayList<>();
        for (String task : tasks) {
            if (task != null) ;
            outputTasks.add(task);
        }
        return outputTasks.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.joining(" "));
    }
}
