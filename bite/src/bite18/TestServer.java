package bite18;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/4/19 11:47
 * @Description:
 */
public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true){
            //接收请求
            Socket sc = serverSocket.accept();
            InputStream is= sc.getInputStream();
            Scanner scanner = new Scanner(is,"UTF-8");
            String s = scanner.nextLine();
            System.out.println(s);
            //处理请求
            String response = s;
            OutputStream os = sc.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.println(response);
            writer.flush();
            sc.close();
        }
    }
}
