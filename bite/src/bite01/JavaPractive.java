package bite01;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/9 21:43
 * @Description:
 */
public class JavaPractive {
    public static void main(String[] args) {
        args = new String[10];
        args[0] = "12";
        args[1] = "1234";
        System.out.println(args[0]);
        System.out.println(args[1]);
        String action = "你好";
        String target = "世界";
        String message = "\""+action+target+"\"";//转义字符，如果给两边加“，则需要用\进行转义
        System.out.println(message);
        //String可以使用加号作为字符串的连接（concat），前提是第一个就是String类型
    }
}
