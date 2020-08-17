package bite08.装箱和拆箱;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 15:57
 * @Description:
 */
public class WrapClassDemo {
    public static void main(String[] args) {
        Integer obj = Integer.valueOf(10);//手动装箱
        int i = obj.intValue();//手动拆箱

        Integer obj2 = 20;//自动装箱
        int i2 = obj2;//自动拆箱

        Integer obj3 = (Integer)30;//自动装箱
        int i3 = (int)obj3;//自动拆箱
    }

}
