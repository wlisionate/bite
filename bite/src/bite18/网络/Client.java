package bite18.网络;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (DatagramSocket socket = new DatagramSocket()) {
            while (true) {
                // 读取用户输入
                System.out.print("随便输入什么然后回车>");
                String input = scanner.nextLine();

                // 发送请求
                byte[] sendBuffer = input.getBytes("UTF-8");
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer, 0, sendBuffer.length,
                        InetAddress.getByName("49.233.172.121"),
                        9939
                );

                socket.send(sendPacket);

                // 接收响应
                byte[] receiveBuffer = new byte[8192];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, 0, receiveBuffer.length);
                socket.receive(receivePacket);

                // 真正接受到响应，进行字符集解码 
                String response = new String(receiveBuffer, 0, receivePacket.getLength(), "UTF-8");
                System.out.printf("From 服务端$ |%s|%n", response);
            }
        }
    }
}
