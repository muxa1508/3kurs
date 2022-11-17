package ru.netology.javacore.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    protected int port;
    protected Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream());) {
                    String input = in.readLine();
                    System.out.println(input);
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    InputTask inputTask = gson.fromJson(input, InputTask.class);
                    switch (inputTask.getType()) {
                        case ADD:
                            todos.addTask(inputTask.getTask());
                            break;
                        case REMOVE:
                            todos.removeTask(inputTask.getTask());
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }

        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
