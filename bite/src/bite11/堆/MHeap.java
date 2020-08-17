package bite11.堆;

import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/2/27 19:44
 * @Description:
 */
public class MHeap {
    public static void swap(int []array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void shiftDownBig(int [] array,int size,int parent){
        int child = parent*2+1;
        while (child<size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                ++child;
            }
            if (array[child] > array[parent]) {
                swap(array,parent,child);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }
    public static void shiftDownSmall(int [] array,int size,int parent){
        int child = parent*2+1;
        while (child<size) {
            if (child + 1 < size && array[child] > array[child + 1]) {
                ++child;
            }
            if (array[child] < array[parent]) {
                swap(array,parent,child);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }
    public static void createHeapBig(int []arr){
        for(int i = (arr.length-2)/2;i>=0;i--){
            shiftDownBig(arr,arr.length,i);
        }
    }
    public static void createHeapSmall(int []arr){
        for(int i = (arr.length-2)/2;i>=0;i--){
            shiftDownSmall(arr,arr.length,i);
        }
    }
    //向上调整
    public static void shiftUpSmall(int []arr,int size,int child){
        int parent = (child-1)/2;
        while (child>0){
            if(arr[child]<arr[parent]){
                swap(arr,child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,45,78,46,56};
        int []copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        createHeapBig(arr);
        System.out.println(Arrays.toString(arr));
        createHeapSmall(copy);
        System.out.println(Arrays.toString(copy));
    }
}
