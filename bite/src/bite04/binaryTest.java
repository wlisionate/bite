package bite04;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *举例：区间长度[2,2] = 1，[2,2) = 0
 * 带等于号：left+1 = right（结束条件）
 * 不带等于号    left = right（结束条件）
 * @Auther: pangchenbo
 * @Date: 2020/1/7 09:52
 * @Description:二分查找
 */
public class binaryTest {
    /**
     * [left,right)搜索一次之后的区间为[left,mid)和[mid+1,right)
     * @param arr
     * @param value
     * @return
     */
    public static int binarySerach(int[] arr,int value){
        //[left,right)
        int left = 0;
        int right = arr.length;
        while (left<right){//表示现在的左闭右开区间还有数
            int mid = (left+right)/2;
            System.out.println("mid: "+mid);
            if(arr[mid] == value)
                return mid;
            if(arr[mid]<value) {
                left = mid + 1;
                System.out.println("left: "+left);
            }
            else {
                right = mid;
                System.out.println("right: "+right);
            }
        }
        return -1;
    }
    /**
     *搜索一次区间[left,mid-1]   [mid+1,right]
     * @param arr
     * @param value
     * @return
     */
    public static int binarySerach2(int[] arr,int value){
        //[left,right]
        int left = 0;
        int right = arr.length-1;//控制区间形式
        while (left<=right){//表示现在的左闭右闭区间还有数
            int mid = (left+right)/2;//int mid = left + (right - left) / 2;
            System.out.println("mid: "+mid);
            if(arr[mid] == value)
                return mid;
            if(arr[mid]<value) {
                left = mid + 1;
                System.out.println("left: "+left);
            }
            else {
                right = mid - 1;
                System.out.println("right: "+right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] array = {1,3,5,6};
        binarySerach(array,2);
    }
}
