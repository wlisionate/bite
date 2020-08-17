package bite15.如何让一个线程中另一个线程停止;

public class B extends Thread {
    private Condition condition;

    B(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void run() {
        Thread thread = currentThread();
        while (condition.running) {
            System.out.println(thread.getId() + ": 挖煤");
        }
    }
}
