package bite10.多线程;

import java.util.Scanner;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 11:48
 * @Description:
 */
public class Scene2 {
    public static int fib(int n){
        if(n<2){
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }
    private static class MyThread extends Thread{
        int n;
        MyThread(int n){
            this.n = n;
        }

        @Override
        public void run() {
            long result =  fib(n);
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入要计算的结果n：");
            int n = scanner.nextInt();
            MyThread thread = new MyThread(n);
            thread.start();
        }
    }
}
