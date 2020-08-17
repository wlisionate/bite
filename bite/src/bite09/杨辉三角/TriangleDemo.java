package bite09.杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 09:17
 * @Description:
 */
public class TriangleDemo {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        //每一行第一个为1
        for(int i=0;i<numRows;i++){
            triangle.add(new ArrayList<>());
            triangle.get(i).add(1);
        }
        for(int i=1;i<numRows;i++){
            for(int j=1;j<i;j++){
                int ret = triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j);
                triangle.get(i).add(ret);
            }
            triangle.get(i).add(1);
        }
        return triangle;
    }
}
