import java.util.*;
public class AntiOrder {
    public int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortRecursion(A, 0, n - 1);
    }
    public static int mergeSortRecursion(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return mergeSortRecursion(arr, l, mid) + mergeSortRecursion(arr, mid + 1, r) +
                merge(arr, l, mid, r);
    }
    public static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;// 新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        return inverseNum;
    }
}
