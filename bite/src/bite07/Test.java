package bite07;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/12 11:38
 * @Description:
 */
class B{
    public int Func(){
        System.out.print("B");
        return 0;
    }
}
class D extends B{
    @Override
    public int Func() {
        System.out.print("D");
        return 0;
    }
}
public class Test {
    public static void main(String[] args) {
        B a = new B();
        B b = new D();
        a.Func();
        b.Func();
    }

}
