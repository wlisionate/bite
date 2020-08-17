package bite15.如何让一个线程中另一个线程停止.使用Java通知的方式停止;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        b.interrupt();  // 主线程中通知 B 线程停止
    }
}
