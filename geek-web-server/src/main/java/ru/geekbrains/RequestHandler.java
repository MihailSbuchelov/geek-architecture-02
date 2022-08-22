package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    public RequestHandler(SocketService socketService, FileService fileService) {
        this.socketService = socketService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = new RequestParser().parse(rawRequest);
        HttpResponse httpResponse = new HttpResponse();

        if (!fileService.exists(httpRequest.getPath())) {
            httpResponse.setStatusCode(404);
            socketService.writeResponse(new ResponseSerializer().serialize(httpResponse));
        } else {
            httpResponse.setStatusCode(200);
            httpResponse.setBody(fileService.readFile(httpRequest.getPath()));
            socketService.writeResponse(new ResponseSerializer().serialize(httpResponse));
        }

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
