package bite15;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/4/10 21:53
 * @Description:
 */
public class Lazying {
    private static Lazying instance = null;
    public static Lazying getInstance(){
        if(instance == null){
            synchronized (Lazying.class){
                if(instance == null)
                    instance = new Lazying();
            }
        }
        return instance;
    }
    private Lazying(){

    }
}
