package bite03;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/12 16:46
 * @Description:
 * 方法名称＋参数列表  唯一确定一个方法
 */
public class MethodTest01 {
    public static void main(String[] args) {
        System.out.println(cursion(6));
        System.out.println(cursion1(5));
    }
    public static int cursion(int m){
        if(m == 1){
            return 1;
        }else {
            return m*cursion(m-1);
        }
    }
    public static int cursion1(int n){
        if( n == 1 || n == 0){
            return 1;
        }else {
            return cursion1(n-1)+cursion1(n-2);
        }
    }
}
