

import java.math.BigInteger;
import java.util.Arrays;

/*
 * public BigInteger add(BigInteger val):加
 * public BigInteger subtract(BigInteger val):减
 * public BigInteger multiply(BigInteger val):乘
 * public BigInteger divide(BigInteger val):除
 * public BigInteger[] divideAndRemainder(BingInteger val):返回商和余数的数组
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("999");
        BigInteger bi2 = new BigInteger("50");

        //public BigInteger add(BigInteger val):加
//        for(int i = 0;i<3;i++){
////            bi1.add()
////        }
        System.out.println("add:"+bi1.add(bi2));

        //public BigInteger subtract(BigInteger val):减
        System.out.println("subtract:"+bi1.subtract(bi2));

        //public BigInteger multiply(BigInteger val):乘
        System.out.println("multiply:"+bi1.multiply(bi2));

        //public BigInteger divide(BigInteger val):除
        System.out.println("divide:"+bi1.divide(bi2));

        //public BigInteger[] divideAndRemainder(BingInteger val):返回商和余数的数组
        BigInteger[] bis = bi1.divideAndRemainder(bi2);
        System.out.println("divideAndRemainder:"+Arrays.toString(bis));
        System.out.println("商:"+bis[0]);
        System.out.println("余数:"+bis[1]);
    }

}