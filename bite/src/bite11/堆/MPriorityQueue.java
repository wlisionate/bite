package bite11.堆;

import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/2/27 20:58
 * @Description:
 */
public class MPriorityQueue {
    private int [] arr = new int[10];
    private int size;

    public  void offer(int value){
        if(size == arr.length){
            arr = Arrays.copyOf(arr,arr.length*2);
        }
        arr[size++] = value;
        //向上调整
        MHeap.shiftUpSmall(arr,size,size-1);
    }
    public int poll(){
        if(size>0){
            int peek = arr[0];
            MHeap.swap(arr,0,size-1);
            --size;
            //向上调整
            MHeap.shiftDownSmall(arr,size,0);
            return peek;
        }
        return -1;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MPriorityQueue mPriorityQueue = new MPriorityQueue();
        mPriorityQueue.offer(1);
        mPriorityQueue.offer(12);
        mPriorityQueue.offer(5);
        mPriorityQueue.offer(56);
        while (!mPriorityQueue.isEmpty()){
            System.out.print(mPriorityQueue.poll()+" ");
        }
    }
}
