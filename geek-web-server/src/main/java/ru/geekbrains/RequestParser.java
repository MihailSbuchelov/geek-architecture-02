package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public HttpRequest parse(Deque<String> rawRequest) {
        String firstLine = rawRequest.pollFirst();
        String[] parts = firstLine.split(" ");
        String method = parts[0];
        String localURI = parts[1];
        Map<String, String> headers = new HashMap<>();
        parseHeaders(rawRequest, headers);
        return new HttpRequest(method, localURI, headers, parseBody(method));
    }

    private void parseHeaders(Deque<String> rawRequest, Map<String, String> headers) {
        for (String s : rawRequest) {
            if (!s.equals("")) {
                headers.put(s.split(": ")[0], s.split(": ")[1]);
            }
        }
    }

    private String parseBody(String method) {
        if (method.equals("get") || method.equals("GET")) {
            return "";
        }
        //обработка body
        return "";
    }

}