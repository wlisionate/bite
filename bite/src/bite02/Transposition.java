package bite02;

import java.util.Scanner;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/11 10:56
 * @Description:
 */
public class Transposition {
    public static void main(String[] args) {
        //首先得到第2-4位的值
        int n = 137;
        int i = n >> 2;
        System.out.println(i & 0b111);
        //得到除了2-4位的其他位
        int mask = ~(0x7<<2);
        System.out.println(n & mask);
        System.out.println(-3 % 10);
        //判断闰年
        //能被400整除的是闰年，能被4整除不能被100整除
        Scanner a = new Scanner(System.in);
        int a1 = a.nextInt();
        boolean isLeapYear = ((a1 % 400) == 0) || ((a1 %4 == 0) && (a1 % 100) !=0);
        if(isLeapYear){
            System.out.println("yes");
        }else {
            System.out.println("NO");
        }
        int x = 20;
        if(x == 10);{
            System.out.println("cetv");
        }
    }
}
