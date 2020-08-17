package bite08;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 09:26
 * @Description:
 */
public class StringMethods {
    public static boolean idNumber(String s){
        for(char c:s.toCharArray()){
//            if(!Character.isDigit(c)){
//                return false;
//            }
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }
}
