package Year_2022.Month_12.Day_05.Demo01;

import java.io.Serializable;

/**
 * @author liulihua
 * @date 2022/12/5 16:31
 * 序列化和反序列化的时候，会抛出 NotSerializableException 没有序列化异常
 * 类通过实现java.io.Serializable 接口以启用气序列化功能，未实现此接口的类将无法使其任何状态序列化或反序列化。
 * Serializable 接口也叫标记型接口
 *      要进行序列化和反序列化的类必须实现Serializable接口，就会给类添加一个标记
 *      当我们进行序列化和反序列化的时候，就会在检测类上是否有这个标记
 *          有：就可以序列化和反序列化
 *          没有：就会爆出NotSerializableException异常
 *    static  关键字：静态关键字
 *          静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
 *          被static 修饰的成员变量不能被序列化的，序列化的都是对象
 *    transient 关键字 ：瞬态关键字
 *          被transient修饰的成员变量，不能被序列化
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
//    private static int age;
//    private transient int age;
    public  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
