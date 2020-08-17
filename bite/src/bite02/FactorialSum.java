package bite02;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/11 12:02
 * @Description:
 */
public class FactorialSum {
    public static int sumWhile(int n){
        int i=1;
        int sum = 0;
        while (i <= n){
            int j=1;
            int temp = 1;
            while (j<=i){
                temp *= j;
                j++;
            }
            sum+=temp;
            i++;
        }
        return sum;
    }
    public static int sumFor(int n){
        int sum = 0;
        int i1 = 1;
        for(int i=1;i<=n;i++){
            int j1=1;
            int temp = 1;
            for(int j=j1;j<=i;j++){
                temp *= j;
            }
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumWhile(5));
        System.out.println(sumFor(5));
    }
}
