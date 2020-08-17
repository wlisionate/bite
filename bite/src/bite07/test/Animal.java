package bite07.test;

import java.util.Map;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/12 16:11
 * @Description:
 */
public class Animal {
    public void move(){
        System.out.println("动物可以移动");
    }
}
class Dog extends Animal{
    public void move(){
        System.out.println("狗可以跑");
    }
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
class TestDog{
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        a.move();
        b.move();
        //b.bark();//普通方法执行跟随对象的类型

    }
}
