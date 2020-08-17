package bite15.单例模式;

/**
 * 懒汉模式：延时加载方式
 * 需要的时候，才进行初始化（如果不是一开始就需要，就没有一开始就分配资源）
 * 缺点：会使情况变得非常复杂（出现 BUG 的几率变大）
 * 是线程安全的么?  1) 是不是只会有一个对象 2） 对象是否完整无误
 */
public class Lazying {
    private volatile static Lazying instance = null;

    /* 版本 2
    public static synchronized Lazying getInstance() {
        if (instance == null) {
            instance = new Lazying();
        }

        return instance;
    }
    */

    // 版本 3 中间过程
    /*
    public static Lazying getInstance() {
        //synchronized (Lazying.class) {      // 有没有线程安全问题？ 性能有提升么？  YES/NO
            if (instance == null) {
                synchronized (Lazying.class) {  // 有没有线程安全问题？ 性能有提升么？   NO
                    instance = new Lazying();
                }
            }
        //}

        return instance;
    }
    */

    // 版本3
    // 要点1：二次判断（抢锁需要消耗时间，又可能出现创建多个对象的情况）。A线程进来刚要加锁的时候别切走了，然后B线程进来执行，进行对象的申请，然后A进来正常的进行对象的申请。
    // 要点2：instance = new Lazying() 可能会被重排序，引起问题  volatile
    public static Lazying getInstance() {
        if (instance == null) {
            synchronized (Lazying.class) {
                if (instance == null) {     // 经过二次判断，可以解决问题
                    instance = new Lazying();
                }
            }
        }

        return instance;
    }

    private Lazying() {
    }
}
