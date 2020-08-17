package 搜索;

import java.util.Map;
import java.util.Scanner;

public class zidianxu {
    public static void dfs(int index,int n,int[] box,int []book){
        if(index>n){
            for(int i = 1;i<=n;i++){
                System.out.print(box[i]);
            }
            System.out.println();
            return;
        }
        for(int i = 1;i<=n;i++){
            if(book[i] == 0) {
                box[index] = i;
                book[i] = 1;
                dfs(index+1,n,box,book);
                book[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] books = new int[n+1];
        int[] boxs = new int[n+1];
        dfs(1,n,boxs,books);
    }
}
