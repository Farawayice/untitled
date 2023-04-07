package Year_2022.Month_12.Day_05.Demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liulihua
 * @date 2022/12/5 16:52
 * ObjectInputStream 对象的反序列化流
 * 作用：把文件中保存的对象，以流的方式读取出来使用
 * 构造方法：
 * ObjectInputStream(InputStream in)创建从指定InputStream 读取的ObjectStream.
 * 参数：
 *      InputStream in 字节输入流
 *  特有的成员方法
 *      Object readObject() 从ObjectInputStream读取对象
 *  使用步骤:
 *      1.创建ObjectInputStream 对象中的方法readObject（）读取保存对象的文件
 *      2.使用ObjectInputStream 对象中的方法readObject读取保存对象的文件
 *      3.释放资源
 *      4.使用读取出来的对象（打印）
 *   readObject 方法声明抛出了ClassNotFoundException（class 文件找不到异常）
 *   当不存在对象的class 文件时抛出了异常
 *   反序列化的前提：
 *   1.类必须实现Serializable接口
 *   2.必须存在类对应的class文件
 *
 */
public class Demo02ObjectInputStream {
    public static ConcurrentHashMap<String, String> specialData = new ConcurrentHashMap<>();
        public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\home\\yj\\test\\Person.txt"));
        Object obj = ois.readObject();
        ois.close();
        Person p = (Person)obj;
        System.out.println(obj);
        System.out.println(p.getName()+"   "+p.getAge());

    }

}
