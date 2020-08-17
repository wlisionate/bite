package bite13.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/12 20:48
 * @Description:
 */
public class MyCompare {
    public static void swap(Person[] person,int i,int j){
        Person temp = person[i];
        person[i] = person[j];
        person[j] = temp;
    }
    //在方法中使用方式一：调用compareTo方法
    public static void bubbleSort(Person[] person){
        int end = person.length;
        while (end>0){
            boolean flag = true;
            for(int i = 1;i<end;i++){
                if(person[i].compareTo(person[i-1])>0){
                    swap(person,i,i-1);
                    flag = false;
                }
            }
            end--;
            if (flag)
                break;
        }
    }
    //在方法中使用方式二：
    public static void bubbleSort(Person[] person,Comparator<Person> comparator){
        int end = person.length;
        while (end>0){
            boolean flag = true;
            for(int i = 1;i<end;i++){
                if(comparator.compare(person[i-1],person[i])>0){
                    swap(person,i,i-1);
                    flag = false;
                }
            }
            end--;
            if (flag)
                break;
        }
    }

    public static void main(String[] args) {
    }
}
/*
自定义类型需要比较
    1.需要实现Comparable接口中的compareTo方法---》自然排序的实现方法
    2.实现比较器Comparator接口中的compare方法---》非自然排序的实现方法
 */
//方法一：实现Comparable接口中的compareTo方法
class Person implements Comparable<Person>{
    public String name;
    public String gender;
    public int age;
    public String ID;

    Person(String name, String gender, int age, String id){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ID = id;
    }
    @Override
    public String toString(){
        return name + "--" + gender + "--" + age + "--" + ID;
    }
    @Override
    public int compareTo(Person o) {
        return ID.compareTo(o.ID);
    }
//方法二：实现比较器中接口Comparator的Compare方法
static class PersonAgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        int ret = o1.age - o2.age;
        if(ret < 0)
            return -1;
        else if (ret > 0)
            return 1;
        else
            return 0;
    }
}
static class PersonIDComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.compareTo(o2);
    }
}
    public static void main(String[] args) {
        Person[] personArr = {new Person("王继文", "男", 19, "123456"),
                new Person("赵军杰", "男", 18, "19"),
                new Person("赵俊杰", "男", 29, "103456"),} ;
        Arrays.sort(personArr);
        System.out.println(Arrays.toString(personArr));
        Arrays.sort(personArr, new PersonAgeComparator());
        System.out.println(Arrays.toString(personArr));
        Arrays.sort(personArr,new PersonIDComparator());
        System.out.println(Arrays.toString(personArr));
    }
}