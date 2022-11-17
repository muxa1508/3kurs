package ru.netology.javacore;

import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        clientStart();
    }


    protected static String HOST = "127.0.0.1";
    protected static int PORT = 8989;

    protected static void clientStart() {
        try (Socket clientSocket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            JsonObject newTask = new JsonObject();
            newTask.addProperty("type", "ADD");
            newTask.addProperty("task", "Название задачи");
//            System.out.println(newTask);
            out.println(newTask);
            String inputFromServer = in.readLine();
            System.out.println(inputFromServer);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

