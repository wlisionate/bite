package bite18.网络.TCP;

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 9898);

        Scanner console = new Scanner(System.in);
        System.out.print("请输入请求> ");
        String request = console.nextLine();

        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(
            new OutputStreamWriter(os, "UTF-8")
        );
        writer.println(request);
        writer.flush();

        InputStream is = socket.getInputStream();
        Scanner scanner = new Scanner(is, "UTF-8");

        String response = scanner.nextLine();   // 对象没有响应，就一直等
        System.out.println(response);

        socket.close();
    }
}