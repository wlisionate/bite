import java.util.*;

public class H {
    public int count(int[] A, int n) {
        // write code here
        if(A == null || n == 0)
            return 0;
        return mergesort(A,0,n-1);
    }
    public static int mergesort(int[]a,int l,int r){
        if(l == r)
            return 0;
        int mid = (l+r)/2;
        return mergesort(a,l,mid)+mergesort(a,mid+1,r)+merge(a,l,mid,r);
    }
    public static int merge(int []a,int left,int mid,int right){
        int [] temp = new int[right-left+1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverNum = 0;
        while(i<=mid && j<=right) {
            if (a[i] <= a[j])
                temp[index++] = a[i++];
            else {
                inverNum += (mid - i + 1);
                temp[index++] = a[j++];
            }
        }
            while(i<=mid)
                temp[index++] = a[i++];
            while(j<=right)
                temp[index++] = a[j++];
            for(int k = 0;k<temp.length;k++)
                a[left++] = temp[k];
        return inverNum;
    }
}