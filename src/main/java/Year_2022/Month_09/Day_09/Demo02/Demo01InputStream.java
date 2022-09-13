package Year_2022.Month_09.Day_09.Demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 15:03
 * java.io.inputStream；字节输入流
 * 此抽象方法是表示字节输入流的所有方法的超类
 * 定义了所有的子类公用的方法：
 *      int read() 从输入流中读取数据的下一个字节
 *      int read(bytep[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
 *      void close() 关闭此输入流并释放与该流关联的所有系统资源
 * java.io.FileInputStream extends InputStream
 * FileInputStream :文件字节输入流
 * 作用：把硬盘文件中的数据读取到内存中使用
 *
 *      构造方法：
 *       FileInputStream(String name ):
 *       FileInputStream(File file):
 *       参数：读取文件的数据圆
 *          String name :文件的路径
 *          File file : 文件
 *        构造方法的作用：
 *          1、会创建一个FileInputStream对像
 *          2、会把FileInputStream对象指向构造方法中要读取的文件
 *
 *  读取数据的原理（硬盘--->内存）
 *      java程序-->JVM-->OS-->os读取数据的方法-->读取文件
 *  字节输入流的使用步骤（重点）：
 *      1、创建FileInputStream对象，构造方法中绑定要读取的数据源
 *      2、使用FileInputStream对象中的方法read,读取文件
 *      3、释放资源
 *
 *      循环的布尔表达式： (len = fileInputStream.read())!= -1
 *          1、file.read()；读取一个字节
 *          2、len = file.read() 赋值给 len
 *          3、len!= -1 :判断赋值的字节是否为-1
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        //  1、创建FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream  fileInputStream = new FileInputStream("E:\\home\\yj\\test\\a.txt");
        //  2、使用FileInputStream对象中的方法read,读取文件
        int len = 0;
        while ((len=fileInputStream.read())!=-1) {
            System.out.print((char) len);
        }
        //  3、释放资源
        fileInputStream.close();
    }
}
