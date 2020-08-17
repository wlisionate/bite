package bite07;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/12 10:25
 * @Description:
 */
public class Person extends Animal {
    private String said;
    public Person(){
        super();
    }
    public Person(int height,int weight,String said){
        super(height, weight);
        this.said = said;
    }
    //重载
    public void HH(int va){
        System.out.println(va);
    }
    @Override
    public void HH(){
        System.out.println("kkkk");
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.HH();
        person.HH(11);
    }
}
