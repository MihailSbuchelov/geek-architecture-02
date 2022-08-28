package ru.geekbrains;


import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class WebServer {

    public static void main(String[] args) {
        Properties prop = getProperties();
        int port = Integer.parseInt(prop.getProperty("port"));
        String path = prop.getProperty("WWW");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(new SocketService(socket), new FileService(path))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties getProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("D:\\Windows.old\\Users\\Miha_admin\\Desktop\\geekbrain-projects\\geek-architecture-02\\geek-web-server\\src\\main\\resources\\app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}