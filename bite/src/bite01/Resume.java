package bite01;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/10 10:46
 * @Description:
 */
public class Resume {
    private String name;
    private String sex;
    private int age;
    Resume(){}
    Resume(String name,String sex,int age){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void  introduce( ){
        System.out.println("我是"+this.name+","+"是"+this.sex+","+"今年"+this.age+"岁");
    }

    public static void main(String[] args) {
        Resume resume = new Resume("李四","男生",19);
        resume.introduce();
    }
}
