package bite06;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/11 15:33
 * @Description:
 */
public class A {
    void methodA(){}
    static void methodB(){}
    void methodC(){
        methodA();
        this.methodA();
        methodB();
        this.methodB();
        A.methodB();
//        A.methodA();//普通方法不能用类调用
    }
}
