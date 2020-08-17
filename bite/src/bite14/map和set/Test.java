package bite14.map和set;

import java.util.*;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/13 19:34
 * @Description:
 */
public class Test {
    public static void testMap(){
        Map<String,String> mp = new TreeMap<>();
        //
        mp.put("周荣","2011");
        mp.put("周荣","2012");
        mp.put("庞陈勃","2013");
        System.out.println(mp.get("周荣"));
        Set<String> en = mp.keySet();
        for(String s:en){
            System.out.print(s+" ");
        }
    }
    public static void testSet(){
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        Iterator<Integer> integers =  set.iterator();
        while (integers.hasNext()){
            System.out.print(integers.next()+" ");
        }
    }

    public static void main(String[] args) {
        testMap();
        System.out.println();
        testSet();
    }
}
