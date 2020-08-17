package bite18;

import java.io.*;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/4/19 11:47
 * @Description:
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os,"UTF-8"));
        writer.println("我求你嫁给我");
        writer.flush();;

        //处理请求
        InputStream is = socket.getInputStream();
        Scanner scanner = new Scanner(is,"UTF-8");
        String s = scanner.next();
        System.out.println(s);
        socket.close();
    }
}
