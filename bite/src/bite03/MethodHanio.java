package bite03;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/12 18:07
 * @Description:
 */
public class MethodHanio {
    public static void main(String[] args) {
        Move(5,0,2);
    }
    public  static void Move(int n,int from,int to){
         if(n == 1){
             System.out.println("从 "+from+"到 "+to);
         }else {
             int other = 3 - from -to;
             Move(n-1,from,other);
             System.out.println("从 "+from+"到 "+to);
             Move(n-1,other,to);
         }
    }
}
