package ru.geekbrains.handler.response;

import java.io.PrintWriter;

public class ResponseErrorHandler {

    public ResponseErrorHandler(PrintWriter output) {
        notFoundError(output);
    }

    private void notFoundError(PrintWriter output) {
        output.println("HTTP/1.1 404 NOT_FOUND");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        output.println("<h1>Файл не найден!</h1>");
        output.flush();
        System.out.println("Client disconnected!");
    }
}