package bite18.网络.HTTP;

import java.io.*;
import java.net.*;
import java.util.*;

public class SendRequestDemo {
    public static void main(String[] args) throws IOException {
        /*
        String request = ""
            + "POST http://job.cn/login.do HTTP/1.1\r\n"            // 请求行
            + "Host: job.cn\r\n"                                    // 请求头的第一组 key-value
            + "Content-Length: 36\r\n"                              // 请求头的第二组 key-value
            + "Content-Type: application/x-www-form-urlencoded\r\n" // 请求头的第三组 key-value
            + "\r\n"                                                // 空格下面就属于请求体
            + "username=hgtz2222&password=22222222";                // 请求体
        */

        // 建立 TCP 连接
        Socket socket = new Socket("www.baidu.com", 80);
        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
        // 发送 HTTP 请求
        
        // 请求是 GET 方法，没有请求体
        String request = "GET / HTTP/1.0\r\n"
            + "Host: www.baidu.com\r\n"
            + "\r\n";
        writer.print(request);
        writer.flush();

        // 接收百度发回的 HTTP 响应
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[8192];
        int len = is.read(buffer);
        String response = new String(buffer, 0, len, "UTF-8");

        // 打印响应
        System.out.println(response);

        socket.close();
    }
}