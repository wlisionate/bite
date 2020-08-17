package 校招真题.小红书;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int step;
    public static void DFS(int n,List<Integer> list,int curN,int preNum,List<Integer> list1){
        if(curN >= n){
            if(curN == n) {
                step++;
            }
            return;
        }
        for(int i = preNum;i<list.size();i++){
            list1.add(list.get(i));
            DFS(n,list,curN+list.get(i),i,list1);
            list1.remove(list1.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<s1[1].length();i++){
                if(s1[1].charAt(i)>='0' && s1[1].charAt(i)<='9')
                    list.add(s1[1].charAt(i)-'0');
            }
            List<Integer> list1 = new ArrayList<>();
            DFS(n,list,n,0,list1);
            System.out.println(step);
        }
    }
}
