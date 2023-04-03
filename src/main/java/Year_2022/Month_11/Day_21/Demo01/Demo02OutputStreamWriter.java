package Year_2022.Month_11.Day_21.Demo01;

import java.io.*;

/**
 * @author liulihua
 * @date 2022/11/21 17:00
 * OutputStreamWriter 是字符流通向字节流的桥梁，可使用指定的charset将要写入流中的字符编码成字节。（编码）
 * void write(int c)写入单个字符。
 * void write(char[] cbuf)写入单个字符
 * abstract void write(char[] cbuf,int off,int len)写入数组的某一部分，off数组的开始索引，len写的字符个数
 * void write(String str)写入字符串
 * void write(String str,int off,int len)写入字符串的一部分，off字符串的开始索引,len写的字符个数.
 * void flush()刷新该流的缓冲
 * void close() 关闭此流,但要先刷新它
 * 构造方法:
 *      OutputStreamWriter(OutputStream out) 创建使用默认字符编码的OutputStreamWriter;
 *      OutputStreamWriter(OutputStream out,String charsetName)创建使用指定字符集的OutputStreamWriter
 *      参数:
 *          OutputStream out 字节输出流,可以用来写转换之后的字节到文件中
 *          String charsetName :编码表名称,不区分大小写,可以是utf-8/UTF-8/gbk/GBK....不指定默认使用UTF-8
 *      使用步骤:
 *          1.创建OutputStreamWriter对象构造方法中传递字节输出流和指定的编码表名称
 *          2.使用OutputStreamWriter对象中的方法write,把字符转换为字节存储到缓冲区中(编码)
 *          3.使用OutputStreamWriter对象中的方法flush,把缓冲刷新到文件中
 *          4.资源释放 close();
 */
public class Demo02OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        write_utf_8();
        write_gbk();
    }

    /**
     *
     *
     *
     * */
    private static void write_gbk() throws IOException {
        //创建
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\home\\yj\\test\\gbk.txt"),"utf-8");
//        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\home\\yj\\test\\gbk.txt"));
        //使用
        out.write("你好");
        out.flush();
        out.close();
    }

    /**
     * 使用转换流OutputStreamWriter写UTF-8格式的文件
     * */
    private static void write_utf_8() throws IOException {
        //创建
//        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\home\\yj\\test\\utf_8.txt"),"utf-8");
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\home\\yj\\test\\utf_8.txt"));
        //使用
        out.write("你好");
        out.flush();
        out.close();
    }
}
