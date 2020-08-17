package bite02;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/11 19:08
 * 标准输入    System.in   键盘
 * 标准输出    System.out   显示器
 * 标准错误输出  System.err   显示器
 * @Description: 单独使用break只是跳出内层循环，使用标识符就可以标识跳出任意层的循环
 */
public class Known {
    public static void main(String[] args) {
        i_am_here:
          for(int i=0;i<10;i++){
              for(int j=0;j<10;j++){
                  if(i==3 && j==4) {
                      break i_am_here;
                  }
              }
          }
    }
}
