package bite08.集合框架;

import java.util.*;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 14:45
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("1");
        list.add("2");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.remove("1");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.remove("3");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Collection<String> list1 = new LinkedList<>();
        Collection<String> list2 = new HashSet<>();
        Collection<String> list3 = new Vector<>();
        Collection<String> list4 = new PriorityQueue<>();
        Collection<String> list5 = new TreeSet<>();
        Collection<String> list6 = new Stack<>();
    }
}
