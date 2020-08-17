package bite02;

import java.util.Scanner;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/11 11:42
 * @Description: switch中可以用的类型：整数，枚举，字符，字符串
 */
public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            switch (s){
                case "haha0":
                    System.out.println(0);
                    break;
                case "haha1":
                    System.out.println(1);
                    break;
                case "haha2":
                    System.out.println(2);
                case "haha3":
                    System.out.println(3);
                    break;
                default:
                    System.out.println("无知的人类");
            }
        scanner.close();
        }
    }
}
