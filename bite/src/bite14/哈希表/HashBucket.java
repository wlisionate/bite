package bite14.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/18 15:54
 * @Description:
 */
public class HashBucket {
    private static class Node {
        int key;
        int value;
        Node next = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private Node[] array;
    private int size;
    private static final double LOAD_FACTORY = 0.7;

    public HashBucket() {
        array = new Node[10];
        size = 0;
    }

    //负载因子
    public double loadFactory() {
        return size * 1.0 / array.length;
    }

    public int put(int key, int value) {
        //检查容量
        if (loadFactory() >= LOAD_FACTORY)
            resize();
        //进行插入
        //1.计算哈希值
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                int oldV = cur.value;
                cur.value = value;
                return oldV;
            }
            cur = cur.next;
        }
        //进行插入
        cur = new Node(key, value);
        cur.next = array[index];
        array[index] = cur;
        ++size;
        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        //元素搬移，遍历旧表
        for (int i = 0; i < array.length; i++) {
            Node curHead = array[i];
            while (curHead != null) {
                Node next = curHead.next;
                int index = curHead.key % newArray.length;
                curHead.next = newArray[index];
                newArray[index] = curHead;
                curHead = next;
            }
        }
        array = newArray;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key != key)
                cur = cur.next;
            else
                return cur.value;
        }
        return -1;
    }

    public void printHashBuket() {
        for (int i = 0; i < array.length; ++i) {
            Node cur = array[i];
            while (cur != null) {
                System.out.print(cur.key + "-->" + cur.value + "\t");
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public int remove(int key) {
        //平均时间复杂度o（1）
        int index = key % array.length;
        Node prev = null;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                //如果删除的是头节点
                if (prev == null)
                    array[index] = cur.next;
                else
                    prev.next = cur.next;
                return cur.value;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        HashBucket hb = new HashBucket();
        hb.put(1, 1);
        hb.put(2, 2);
        hb.put(3, 3);
        hb.put(4, 4);
        hb.put(5, 5);
        hb.put(6, 6);
        hb.put(1, -1);
        hb.put(2, -2);
        hb.printHashBuket();
        System.out.println(hb.get(1));
        System.out.println(hb.get(6));
        System.out.println(hb.remove(5));
        hb.printHashBuket();
        System.out.println(hb.remove(3));
        hb.printHashBuket();
        System.out.println(hb.remove(100));
        hb.printHashBuket();
    }
}
