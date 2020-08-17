package bite03;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/12 17:27
 * @Description:
 */
public class MethodTest02 {
    static int num;
    public static int printNumber(int n){
        if(n < 10){
            num += n;
        }else {
             printNumber(n/10);
             int m = n%10;
            num += m;
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(printNumber(1111));
    }
}
