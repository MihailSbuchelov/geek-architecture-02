package ru.geekbrains.handler.response;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResponseHandler {
    public static void response(String folder, String[] parts, PrintWriter output) {
        Path path = Paths.get(folder, parts[1]);
        if (!Files.exists(path)) {
            new ResponseErrorHandler(output);
        } else {
            new ResponseSuccessHandler(output, path);
        }
    }
}