package Year_2022.Month_12.Day_05.Demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author liulihua
 * @date 2022/12/5 16:10
 * java.io.ObjectOutputStream extends OutputStream
 * 作用：把对象以流的方式写入到文件中保存
 * 构造方法：
 *      ObjectOutputStream(OutputStream out)创建写入指定OutputStream的objectOutputStream.
 *      参数；
 *          OutputStream out :字节输出流
 *  特有的成员方法：
 *      writeObject(Object obj);将指定的对象写入ObjectOutputStream.
 *  使用步骤:
 *      1.创建ObjectOutputStream对象，构造方法中传递字节输出流
 *      2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
 *      3，释放资源
 *
 */
public class Demo01ObjectOutputStream {

    public static void main(String[] args) throws IOException {
        //1.创建ObjectOutputStream对象，构造方法中传递字节输出流
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("E:\\home\\yj\\test\\Person.txt"));
        //2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        oos.writeObject(new Person("远辰",23));
        oos.close();
    }
}
