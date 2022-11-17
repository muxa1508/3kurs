package ru.netology.javacore.resources;

public class InputTask {

    protected Type type;
    protected String task;

    public InputTask(Type type, String task) {
        this.type = type;
        this.task = task;
    }

    public Type getType() {
        return type;
    }

    public String getTask() {
        return task;
    }
}
