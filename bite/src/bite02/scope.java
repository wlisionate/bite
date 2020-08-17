package bite02;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/11 09:30
 * @Description:
 */
public class scope {
    public static void main(String[] args) {
        //作用域：
        {
            int s = 123;
            System.out.println(s);
        }
        String s = "hello world";
        System.out.println(s);
        //final int x=10;
        //String与int之间的转换
        String s1 = "123456";
        int x  =  Integer.parseInt(s1);
        System.out.println(x);
        //int转String
        int a = 123;
        String s2 = ""+a;//方法一
        String s3 = String.valueOf(a);//方法二
        System.out.println(s2);
        System.out.println(s3);
    }
}
