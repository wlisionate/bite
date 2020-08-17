package bite08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 09:41
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        List<String> sArray = new ArrayList<>();
        //程序切割
        String domain = "www.baidu.com";
        String[] s = domain.split(".");
        //切割失败的原因：.是一个特殊字符，他会进行全部的切割。
        System.out.println(Arrays.toString(s));
        String []s1 = domain.split("\\.");
        System.out.println(Arrays.toString(s1));
        //进行拼接
        String[] subdomain = {"www","baidu","com"};
        String s2 = String.join(".",subdomain);
        System.out.println(s2);
    }
}
