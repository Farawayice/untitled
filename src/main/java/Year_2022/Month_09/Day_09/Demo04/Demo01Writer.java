package Year_2022.Month_09.Day_09.Demo04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 16:57
 * java.io.Writer :字符输出流，是所有字符输出流的最顶层的父类，是一个抽象类
 *  共性的成员方法：
 *      void write(int c)写人单个字符
 *      void write(char[] cbuf)写入字符数组
 *      abstract void write(charp[] cbuf,int off,int len):写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 *      void write(String str)写入字符串
 *      void write(String str,int off.int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 *      void flush()刷新该流的缓存
 *      void close()关闭此流，但要先刷新它
 *  子类：
 *      OutputStreamWriter
 *      java.io.FileWriter extends OutputStreamWriter extends Writer
 *      作用：把内存中字符数据写入到文件中
 *      构造方法：
 *          FileWriter(File file) 根据给定的File对象构造一个FileWriter对象
 *          FileWriter(String name) 根据给定的文件名构造一个FileWriter对象
 *
 *       构造方法的作用：
 */
public class Demo01Writer {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileWriter fw = new FileWriter("E:\\home\\yj\\test\\c.txt");
        fw.write(97);
        //刷新
//        fw.flush();
        //关闭缓存，释放资源
        fw.close();
    }
}
