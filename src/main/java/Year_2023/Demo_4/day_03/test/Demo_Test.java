package Year_2023.Demo_4.day_03.test;

import Year_2022.Month_12.Day_05.Demo01.Person;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.*;
import java.util.ArrayList;

/**
 * @author liulihua
 * @date 2023/4/3 16:35
 *
 * 练习：序列化集合
 *      当我们想在文件中保存多个对象的时候
 *      可以把多个对象存储到一个集合中
 *      对集合进行序列化和反序列化
 *  分析：
 *      1.定义一个存储Person对象的ArrayList集合
 *      2.在ArrayList集合中存储Person对象
 *      3.创建一个序列化流ObjectOutputStream对象
 *      4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
 *      5.创建一个反序列化ObjectInputStream对象
 *      6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
 *      7.把Object类型的集合转换为ArrayList类型
 *      8.遍历ArrayList集合
 *      9.释放资源
 *
 *
 */
public class Demo_Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义一个存储Person对象的ArrayList集合
        ArrayList<Person> list = new ArrayList<>();
        //2.在ArrayList集合中存储Person对象
        list.add(new Person("张三",23));
        list.add(new Person("李四",24));
        list.add(new Person("王五",25));
        list.add(new Person("xxx",26));
        //3.创建一个序列化流ObjectOutputStream对象
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("E:\\home\\yj\\test\\test.txt"));
        //4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
        outputStream.writeObject(list);
        //5.创建一个反序列化ObjectInputStream对象
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("E:\\home\\yj\\test\\test.txt"));
        //6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
        Object obj = inputStream.readObject();
        //7.把Object类型的集合转换为ArrayList类型
        ArrayList<Person> p =  (ArrayList<Person>) obj;
        //8.遍历ArrayList集合
        System.out.println(p.toString());
        for (Person person : p) {
            System.out.println(person.getName()+" "+person.getAge());
        }
        //9.释放资源
        inputStream.close();
        outputStream.close();
    }
}
