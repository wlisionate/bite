package bite12.排序;

import java.util.Arrays;
import java.util.Stack;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/3 19:25
 * @Description:
 */
public class Sort1 {
    //堆排序,重点
    //进行向上调整
    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void shiftUpBig(int [] arr,int parent,int size){
        int child = parent*2+1;
        while (child <size ){
            if(child+1 <size && arr[child+1]>arr[child]){
                ++child;
            }
            if(arr[child]>arr[parent]){
                swap(arr,child,parent);
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }
    //进行建堆操作
    public static void heapSort(int [] arr){
        //最后一个非叶子结点,建堆
        for(int i = arr.length-2/2;i>=0;i--){
            shiftUpBig(arr,i,arr.length);
        }
        for(int i = 1;i<=arr.length;i++) {
            int end = arr.length - i;
            swap(arr, 0, end);
            shiftUpBig(arr, 0, end);
        }
    }
    //冒泡排序
    public static void bubbleSort(int [] array){
        //len未排序的元素
       int len = array.length;
       while (len>0){
           boolean flag = true;
           //进行一次冒泡
           for(int i = 0;i<len-1;i++){
               if(array[i]>array[i+1])
               swap(array,i,i+1);
               flag = false;
           }
           if (flag){
               break;
           }
           --len;

       }

    }
    //快速排序
    //进行三数取中
    public static int getMid(int [] array,int left,int right){
        //从array[left],mid,right中取一个中间值
        int mid = (left+right)/2;
        if(array[mid] > array[left]){
            if(array[mid] < array[right])
                return mid;
            else {
                if(array[left] > array[right])
                    return left;
                else
                    return right;
            }
        }else {
            if(array[mid] > array[right])
                return mid;
            else {
                if(array[left] < array[right])
                    return left;
                else
                    return right;
            }
        }
    }
    //进行分组
    public static int partion1(int [] array,int left,int right){
        int key = array[left];
        int start = left;
        while (left<right){
            while (left<right && array[right]>=key){
                right--;
            }
            while (left<right && array[left]<= key){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,start);
        return left;
    }
    public static int partion2(int[] arr,int left,int right){
        int key = arr[left];//获取基准值
        //挖坑填坑
        while (left<right){
            while (left<right && arr[right]>=key)
                --right;
            arr[left] = arr[right];
            while (left<right && arr[left] <= key)
                ++left;
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
    public static int partion3(int [] array,int left,int right){
        int key = array[left];
        int prev = left;
        int cur = left+1;
        while (cur<=right){
            if(array[cur] < key && prev++ != cur)
                swap(array,cur,prev);
            cur++;
        }
        swap(array,prev,left);
        return prev;
    }
    //快速排序平均时间复杂度：o(nlog(n))，最坏时间复杂度：o(n*n)
    //最坏情况下，当数据完全有序的时候进行快排，最次从开始进行划分都是一颗单边二叉树
    //解决方法：利用取中法不仅能避免单边二叉树，而且树的划分也是最优的，性能得到了提高
    public static void quickSort(int [] array,int left,int right){
        if (left<right) {
            int mid = partion1(array, left, right);
            //int mid = partion2(array,left,right);
//            int mid = partion3(array,left,right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }
    /*
        快排的非递归写法
        1.选取基准值
        2.根据基准值进行分组
        3.给划分好的小组数据进行重复
     */
    public static void quickSortNoR(int[] arr){
        int left = 0;
        int right = arr.length-1;
        Stack<Integer> st = new Stack<>();
        if(left < right){
            st.push(left);
            st.push(right);
        }
        while (!st.isEmpty()){
            int right1 = st.pop();
            int left1 = st.pop();
            int mid = partion3(arr,left1,right1);
            if(mid-1 > left1){
                st.push(left1);
                st.push(mid-1);
            }
            if (mid+1 < right1){
                st.push(mid+1);
                st.push(right1);
            }
        }
    }
    //归并排序
    //1.先进行合并操作
    public static void mergeInternal(int[] arr,int left,int mid,int right,int[] temp){
        int begin1 = left,end1 = mid;
        int begin2 = mid + 1,end2 = right;
        int index = left;
        while (begin1<= end1&& begin2<= end2){
            //<: 不稳定
            //<=:稳定
            if (arr[begin1]<=arr[begin2]){
                temp[index++] = arr[begin1++];
            }else {
                temp[index++] = arr[begin2++];
            }
        }
        while (begin1<= end1)
            temp[index++] = arr[begin1++];
        while (begin2<=end2)
            temp[index++] = arr[begin2++];
        //进行拷贝
        for(int i = left;i<=right;i++){
            arr[i] = temp[i];
        }
    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left>= right)
            return;
        //进行分组
        int mid =( left+right)/2;
        //首先给[left,mid]和[mid+1,right]小组数据进行排序
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        mergeInternal(arr,left,mid,right,temp);
    }
    public static void merge(int[] arr){
        int [] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }
    //归并排序的非递归遍历
    public static void mergeNoR(int [] arr){
        int[] temp = new int[arr.length];
        //i表示每次归并的元素个数
        for(int i=1;i<arr.length;i*=2){
            //j:下一次归并的起始位置
            for(int j = 0;j<arr.length;j+=2*i) {
//                mergeInternal(arr,j,j+i-1,j+2*i-1,temp);//区间可能越界
                int left = j;
                int mid = j+i-1;
                //右半部分没有数据，不能进行归并
                if(mid >= arr.length-1)
                    continue;
                int right = j+2*i-1;
                //判断右边区间是否越界
                if(right >= arr.length)
                    right = arr.length-1;
                mergeInternal(arr,left,mid,right,temp);
            }
        }
    }
    public static void main(String[] args) {
        int [] array = {1,5,5,9,6,4};
//        heapSort(array);
//        bubbleSort(array);
//        quickSortNoR(array);
        merge(array);
        System.out.print(Arrays.toString(array));
    }
}
