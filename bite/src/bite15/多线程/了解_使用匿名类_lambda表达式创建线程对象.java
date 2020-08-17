package bite15.多线程;

public class 了解_使用匿名类_lambda表达式创建线程对象 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 随便写什么
        });

        Thread t2 = new Thread(() -> {
            // 随便写什么
        });
        Thread t3 = new Thread(() -> {
            //随便写什么
        });
    }

    public static void main2(String[] args) {
        Thread t1 = new Thread(() -> {
            // 随便写什么
        });

        Thread t2 = new Thread(() -> {
            // 随便写什么
        });
    }
}
