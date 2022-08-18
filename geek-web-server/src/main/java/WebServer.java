import ru.geekbrains.utils.ConnectionUtils;

public class WebServer {
    private static String WWW = "D:\\Windows.old\\Users\\Miha_admin\\Desktop\\geekbrain-projects\\geek-architecture-02\\www";

    public static void main(String[] args) {
        ConnectionUtils.getConnect(WWW);
    }
}