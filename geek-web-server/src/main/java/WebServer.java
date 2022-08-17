import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static String WWW = "D:\\Windows.old\\Users\\Miha_admin\\Desktop\\geekbrain-projects\\geek-architecture-02\\www";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(socket, WWW)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}