package bite07.interfaceTest1;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/12 15:03
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        IKUN ikun = new IKUN();
        CXK cxk = new CXK();
        A a = cxk;
        B b = cxk;
        C c = cxk;
        star star = cxk;
        a = ikun;
        b = ikun;
        c= ikun;
        star = ikun;
    }
}
