package bite14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/26 09:32
 * @Description:
 */
public class Test {
}
//class Pair<U,V>{
//    public U first;
//    public V second;
//    public Pair(U first,V second){
//        this.first = first;
//        this.second = second;
//    }
//}
//class Bucket{
//    private List<Pair<Integer,Integer>> bucket;
//    public Bucket(){
//        this.bucket = new LinkedList<>();
//    }
//    public Integer get(Integer key){
//        for(Pair<Integer,Integer> pair:bucket){
//            if(pair.first.equals(key) )
//                return pair.second;
//        }
//        return -1;
//    }
//    public void update(Integer key,Integer value){
//        boolean found = false;
//        for(Pair<Integer,Integer> pair:bucket){
//            if(pair.first.equals(key)) {
//                pair.second = value;
//                found = true;
//            }
//        }
//        if(!found)
//            this.bucket.add(new Pair<Integer,Integer>(key,value));
//    }
//    public void remove(Integer key){
//        for(Pair<Integer,Integer> pair:this.bucket){
//            if(pair.first.equals(key)){
//                bucket.remove(pair);
//                break;
//            }
//        }
//    }
//}
//class MyHashMap{
//    private int ket_space;
//    private List<Bucket> hash_table;
//
//    public MyHashMap(){
//        this.ket_space = 2096;
//        this.hash_table = new ArrayList<>();
//        for(int i = 0;i<ket_space;i++)
//            this.hash_table.add(new Bucket());
//    }
//    public void put(int key,int value){
//        int hash_key = key%ket_space;
//        this.hash_table.get(hash_key).update(key,value);
//    }
//    public int get(int key){
//        int hash_key = key%ket_space;
//        return this.hash_table.get(hash_key).get(key);
//    }
//    public void remove(int key){
//        int hash_key = key%ket_space;
//        this.hash_table.get(hash_key).remove(key);
//    }
//}
class MyHashSet {
    private Bucket[] buckets;
    private int key_space;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.key_space = 1024;
        buckets = new Bucket[key_space];
        for(int i = 0;i<key_space;i++)
            buckets[i] = new Bucket();
    }

    public void add(int key) {
        int index = key%key_space;
        buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = key%key_space;
        buckets[index].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%key_space;
        return buckets[index].exist(key);
    }
}
class Bucket{
    private LinkedList<Integer> mybucket;
    public Bucket(){
        mybucket = new LinkedList<>();
    }
    public void insert(int key){
        int index = mybucket.indexOf(key);
        if(index == -1)
            mybucket.addFirst(key);
    }
    public void delete(Integer key){
        mybucket.remove(key);
    }
    public boolean exist(Integer key){
        int index = mybucket.indexOf(key);
        return index!=-1;
    }
}