package Year_2022.Month_09.Day_09.Demo02;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 15:31
 * 字节输入流一次读取多个字节的方法：
 *      int read(byte [] b) 从输入流中读取一定数量的字节，并将其存储在缓存区数组b中。
 *  明确两个方面：
 *      1、方法的参数byte[] 的作用
 *          数组：缓冲作用，存储读取到的多个字节
 *      2、方法的返回值int是什么
 *          每次读取的有效字节个数
 *  String （byte[] bytes ）:把字节数组转换为字符串
 *  String (byte[] bytes,int offset, int length) :把字节数组的一部分转换为字符串 offset:数组的开始索引 length :转换的字节个数
 *
 *
 */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        //创建一个FileInputStream对象，构造方法中绑定需要读取的数据源
        FileInputStream fis = new FileInputStream("E:\\home\\yj\\test\\a.txt");
        //使用FileInputStream对象中的方法read读取文件
        //int read(bytep[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
        byte[] data = new byte[1024];//存取读取到的多个字节
        int len = 0;
        while ((len = fis.read(data))!=-1){
            System.out.println(len);
            System.out.println(new String(data));
            System.out.println(new String(data,0,len));
        }
        //释放资源
        fis.close();
    }
}
