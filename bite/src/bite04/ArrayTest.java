package bite04;

import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/7 11:29
 * @Description:
 */
public class ArrayTest {
    public static int[] copyOf(int []a,int newLength){
        int []b = new int[newLength];
        int i = 0;
        int j=0;
        for(i=0;i<newLength&&j<a.length;i++,j++){
            b[i] = a[i];
        }
        return b;
    }
    public static void main(String[] args) {
        int[]e = {1,2,3,4,5};
        int []f = {0,0,0,0,0};
        int []g = {9,8,7,6,5,4,3,2,1};
        //进行排序
        Arrays.sort(g);
        //判断两个数组是否相等
        System.out.println(Arrays.equals(e, f));
        //将指定的值分配给数组的指定区间,左闭右开区间
        Arrays.fill(e,0,2,23);
        //将数组进行拷贝到一个新的数组中，并且设置拷贝到长度
        f = Arrays.copyOf(e,5);
        System.out.println(Arrays.toString(f));
        //复制一个数组到新的数组
        f = Arrays.copyOfRange(e,0,3);
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(copyOf(e,3)));
        System.out.println(Arrays.toString(copyOf(e,5)));
        System.out.println(Arrays.toString(copyOf(e,7)));

    }
}
