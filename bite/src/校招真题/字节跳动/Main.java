package 校招真题.字节跳动;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int [] array = new int[n];
            for(int i = 0;i<n;i++){
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            int count = 0;
            for(int i = 1;i<array.length;i++){
                if(array[i]-array[i-1] > 10)
                    count++;
            }
            int temp = (n+count)%3;
            System.out.println(temp==0?count:count+3-temp);
        }
    }
}
