package bite15.单例模式;

/**
 * 饿汉模式
 * 这个类只允许生成一个对象
 * 是线程安全的么？ YES
 */
public class Starving {
    // 在最开始就初始化好了（饿的不行了，着急吃）
    // 大家使用的都是这个对象
    // 这句是属于静态属性初始化
    // 是发生在类加载时期（初始化），是线程安全（JVM 内部保证只有一个线程执行）
    private static Starving instance = new Starving();

    // 其他类如果需要 Starving 类的对象
    // 统统调用 getInstance() 这个静态方法获取
    // 保证不会有新的对象产生
    public static Starving getInstance() {
        return instance;
    }

    // 更优一点
    // 把构造方法声明为 private，保证别人无法调用构造方法
    private Starving() {
    }
}
