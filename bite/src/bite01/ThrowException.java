package bite01;

import exception.MyException;

import java.util.ArrayList;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/10 19:00
 * @Description:
 */
public class ThrowException {
    public static void main(String[] args) {
        try{
            new ArrayList().get(0);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MyException("这个错误我捕捉到了",e);
        }
    }
}
