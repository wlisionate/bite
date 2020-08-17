package 校招真题.tengxun;

import java.util.Date;

public class Main {
    static boolean checkValue( int num )
    {
        int d1,d2,d3;
        int checkNum, nRemain, rem;

        checkNum = num % 10;
        nRemain = num /10;
        d3 = nRemain % 10;
        nRemain /= 10;
        d2 = nRemain % 10;
        nRemain /= 10;
        d1 = nRemain % 10;
        rem = (d1 + d2 + d3) % 7;
        return rem == checkNum;
    }
    public static void main(String[] args) {
        System.out.println(checkValue(8300));
    }
}
