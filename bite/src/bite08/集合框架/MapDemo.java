package bite08.集合框架;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 14:57
 * put 方法既可以进行修改，也可以进行插入操作。
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("作者","鲁迅");
        map.put("标题","狂人日记");
        map.put("发表时间","1989");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        map.put("发表时间","1982");
        map.put("页数","300");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        map.remove("发表时间");
        System.out.println(map.size());
        System.out.println();
    }
}
