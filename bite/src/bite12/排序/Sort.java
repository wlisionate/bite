package bite12.排序;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/2/29 09:25
 * @Description:
 */
public class Sort {
    //稳定
   public static void insertSort(int [] array){
       for(int i = 0;i<array.length-1;i++){
           int key = array[i+1];
           //排好序的最后一个位置
           int end = i;
           while (end>=0 && array[end]>key){
               array[end+1] = array[end];
               --end;
           }
           array[end+1] = key;
       }
   }
    public static void insertSort2(int [] array){
        for(int i = 1;i<array.length;i++){
            int key = array[i];
            int end = i-1;
            while (end>=0 && array[end]>key){
                array[end+1] = array[end];
                --end;
            }
            array[end+1] = key;
        }
    }
    public static void inertSort3(int [] array){
       int temp = 0;
       int index = 0;
       for(int i=1;i<array.length;i++){
           index = i;
           temp = array[i];
           for (int j=i-1;j>=0;j--){
               if (array[i]<array[j]){
                   array[j+1] = array[j];
                   index = j;
               }
               else {
                   break;
               }
           }
           array[index] = temp;
       }
    }
    //不稳定，因为分组，重点
    public static void shellSort(int [] array){
       int gap = array.length;
       while (gap>1){
           gap = gap/3+1;
           for(int i=0;i<array.length-gap;i++){
               int end = i;
               int key = array[end+gap];
               while (end>=0 && array[end]>key){
                   array[end+gap] = array[end];
                   end -= gap;
               }
               array[end+gap] = key;
           }
       }
    }
    public static void swap(int[] array,int i,int j){
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
    }
    //选择排序
    public static void selectInsert(int [] array){
       int temp = 0;
       for(int i = array.length-1;i>=0;i--){
           int max = i;
           int maxIdx = i;
           for(int j = i-1;j>=0;j--)
           if(array[j]>array[max]){
                max = j;
           }
           swap(array,maxIdx,max);
       }
    }
    //双边选择排序
    public static void selectInsert2(int [] array) {
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            int maxIdx = begin;
            int minIdx = begin;
            for (int i = begin; i <=end; i++) {
                if (array[i] < array[minIdx]) {
                    minIdx = i;
                }
                if (array[i] >= array[maxIdx]) {
                    maxIdx = i;
                }
            }
            swap(array, begin, minIdx);
            if (maxIdx == begin)
                maxIdx = minIdx;
            swap(array, end, maxIdx);
            ++begin;
            --end;
        }
    }
    //选择排序：可以稳定，也可以不稳定
    //
    public static void selectSort(int[] arr){
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end){

            int minIdx = begin;
            int maxIdx = begin;
            for(int i = begin; i <= end; ++i){
                //最小值选前面，两个最小值，从前往后更新呢
                if(arr[i] < arr[minIdx])
                    minIdx = i;
                //最大值选后面，两个最大值，从前往后更新
                if(arr[i] >= arr[maxIdx])
                    maxIdx = i;
            }
            swap(arr, begin, minIdx);
            //如果最大值在起始位置，则经过上面的交换之后，最大值被移动到minIdx指向的位置
            if(maxIdx == begin)
                maxIdx = minIdx;

            swap(arr, end, maxIdx);
            ++begin;
            --end;
        }
    }
    public static void main(String[] args) {
        int []array = {1,65,56,89,78};
        int []copy = array.clone();
        int []copy2 = array.clone();
        int []copy3 = array.clone();
        System.out.println(Arrays.toString(array));
//        insertSort(array);
//        System.out.println(Arrays.toString(array));
//        insertSort2(copy);
//        System.out.println(Arrays.toString(copy));
//        inertSort3(copy2);
//        System.out.println(Arrays.toString(copy2));
//        shellSort(copy3);
//        System.out.println(Arrays.toString(copy3));
        selectInsert(array);
        System.out.println(Arrays.toString(array));
        selectSort(copy);
        System.out.println(Arrays.toString(copy));
        selectInsert2(copy2);
        System.out.println(Arrays.toString(copy2));
    }
}
