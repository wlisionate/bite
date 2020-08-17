package bite02;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/12 16:04
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cls = Foo.class;
        Field[] fields = cls.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        System.out.println(fields[0].getGenericType());
        Type type = fields[0].getGenericType();
        int modifiers = fields[0].getModifiers();
        System.out.println(Modifier.isAbstract(modifiers));
    }
}
