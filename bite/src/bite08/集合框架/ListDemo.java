package bite08.集合框架;

import java.util.ArrayList;
import java.util.List;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 16:19
 * @Description:
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        list.add(1000);
        list.add(0,11);//头插操作
        list.set(0,1);
        for(int i:list){
            System.out.println(i);
        }
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);//进行全部的复制
        for(int i:list1){
            System.out.println(i);
        }
        list.remove(0);
        Integer i1 = 101;
        list.remove(i1);
        for(int i:list){
            System.out.println(i);
        }
        System.out.println(list.contains(1));
        list.add(10);
        list.add(10);
        System.out.println(list.indexOf(10));//返回第一个位置下标
        System.out.println(list.lastIndexOf(10));
        List<Integer> list2 = list.subList(0,2);
    }
}
