package ru.geekbrains.utils;

import ru.geekbrains.handler.request.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionUtils {
    public static void getConnect(String folder) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
                new Thread(new RequestHandler(socket, folder)).start();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}