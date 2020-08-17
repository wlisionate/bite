package bite02;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/11 10:15
 * @Description:
 */
public class Ex {
    public static void main(String[] args) {
        int a = 3;
        int b = 0;
       // System.out.println(a/b);//抛出算术异常的错误
        double x = 3.0;
        double y = 0.0;
        System.out.println(x/y);//java在这里处理为极限操作
        //&& 和 ||的短路特性
        System.out.println(10>20 && 10/0==0);
        System.out.println(10<20 || 10/0 == 0);
        //上面的代码能正常运行的原因：1.基于 && 和 || 操作的短路特性，在&&中，如果左侧的计算值是false
        //则整体的计算值就是false，在||中，如果左侧的计算值是true，则整体的计算值就是true
        System.out.println(10>20 & 10/0==0);
        System.out.println(10<20 | 10/0 == 0);
        //上面的代码就不具有短路性，则&和|不具有短路性

    }
}
