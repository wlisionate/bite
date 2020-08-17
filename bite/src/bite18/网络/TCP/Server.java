package bite18.网络.TCP;

import java.util.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static class ServiceMan extends Thread {
        private final Socket socket;

        ServiceMan(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 获取输入流
                InputStream is = socket.getInputStream();
                // 封装成 Scanner
                Scanner scanner = new Scanner(is, "UTF-8");
                // 使用 \r\n 进行分割的方式，读取一个请求

                // 等着第一个 Client 发送请求
                String request = scanner.nextLine();    // nextLine() 把 \r\n 已经去掉
                System.out.println("收到请求: " + request);

                // 业务处理
                String response = request;

                // 发送响应，也许要使用 \r\n 跟在后边，进行分割
                OutputStream os = socket.getOutputStream();
                // 封装成 PrintWriter
                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(os, "UTF-8")
                );
                // 发送响应
                writer.println(response);   // println 会帮我们在后边增加 \r\n
                writer.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 开一家店
        ServerSocket serverSocket = new ServerSocket(9898);
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        // 循环处理业务
        // 主线程只负责接待 —— 连接连接的过程
        while (true) {
            Socket socket = serverSocket.accept();  // 虽然有 4 个Client 连接，socket 代表的是第一个Client
            /*
            // 所有业务处理的过程，交给线程去处理
            new ServiceMan(socket).start();
             */

            // 各个线程之间，没有数据共享（主线程和工作线程之间共享 socket）
            // 所以天生是线程安全的
            threadPool.execute(new ServiceMan(socket));
        }
    }
}