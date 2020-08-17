package bite01;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/9 20:31
 * @Description:
 */
public class zijie {
    public static void main(String[] args) {
        Short s = Short.MAX_VALUE;
        Short s1 = Short.MAX_VALUE;

        Long l = Long.MAX_VALUE;
        Long l1 = Long.MIN_VALUE;
        System.out.println(s+"  "+s1+"  "+l+"  "+"l1");
        int bInt = 10;//十进制
        System.out.println(bInt);
        bInt = 0B101;//二进制
        System.out.println(bInt);
        bInt = 011;//八进制
        System.out.println(bInt);
        bInt = 0x3F;//十六进制
        System.out.println(bInt);
        int aInt = Math.toIntExact(10L);
        System.out.println(aInt);
        //类型转换特例
        //针对字面量，byte和short，范围内允许，超出范围不允许
        byte aByte;
        short aShort;
        aByte = 1;
        aByte = 1;
        //类型提升 1+10L自动转化为最高的类型Long
        //Java中char是两个字节的原因：因为char的编码遵循unicode编码，但是Unicode编码是四个字节的编码，所以
        //它分为常用和不常用两部分，常用的是2个字节编码，不常用的是四个字节编码。
        char aChar;
        aChar = '中';
        System.out.println(aChar);
        aChar = '\n';
        System.out.println(aChar);
        aChar = '\t';    //换行
        System.out.println(aChar);
        aChar = '\r';    //回到行首
        System.out.println(aChar);

    }
}
