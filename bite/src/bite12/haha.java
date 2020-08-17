package bite12;

import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/2/29 08:55
 * @Description:
 */
public class haha {
    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //归并排序
    public static void mergeInternal(int [] arr,int left,int mid,int right,int [] temp){
        int begin1 = left,end1 = mid;
        int begin2 = mid+1,end2 = right;
        int index = left;
        while (begin1<=end1 && begin2<= end2){
            if(arr[begin1]<=arr[begin2])
                temp[index++] = arr[begin1++];
            else
                temp[index++] = arr[begin2++];
        }
        while (begin1<= end1)
            temp[index++] = arr[begin1++];
        while (begin2<= end2)
            temp[index++] = arr[begin2++];
        for(int i = left;i<=right;i++){
            arr[i] = temp[i];
        }
}
    public static void mergeSort(int [] arr,int left,int right,int [] temp){
        if(left>= right)
            return;
        int mid = (left+right)/2;
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        mergeInternal(arr,left,mid,right,temp);
    }
    public static void merge(int [] arr){
        int [] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }

    public static void main(String[] args) {
        int [] array = {1,5,7,4,3};
        merge(array);
        System.out.println(Arrays.toString(array));
    }
}
