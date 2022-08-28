package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

public class ResponseSerializer {

    public String serialize(HttpResponse response) {
        StringBuilder stringBuilder = new StringBuilder();
        if (response.getStatusCode() == 404) {
            stringBuilder
                    .append("HTTP/1.1 ")
                    .append(response.getStatusCode())
                    .append(" NOT_FOUND")
                    .append("\n")
                    .append("Content-Type: ")
                    .append("text/html; charset=utf-8")
                    .append("\n\n")
                    .append("<h1>Файл не найден!</h1>");
        }
        if (response.getStatusCode() == 200) {
            stringBuilder
                    .append("HTTP/1.1 ")
                    .append(response.getStatusCode())
                    .append(" OK")
                    .append("\n")
                    .append("Content-Type: ")
                    .append("text/html; charset=utf-8")
                    .append("\n\n")
                    .append(response.getBody());
        }
        return stringBuilder.toString();
    }
}
