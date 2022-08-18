package ru.geekbrains.handler.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResponseSuccessHandler {
    public ResponseSuccessHandler(PrintWriter output, Path path) {
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        responseSuccess(path, output);
    }

    private void responseSuccess(Path path, PrintWriter output) {
        try {
            Files.newBufferedReader(path).transferTo(output);
            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}