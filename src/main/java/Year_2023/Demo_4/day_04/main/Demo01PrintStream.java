package Year_2023.Demo_4.day_04.main;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author liulihua
 * @date 2023/4/4 14:54
 * java.io.PrintStream;打印流
 *     PrintStream:为其他输出流添加了功能，是它们能够方便地打印各种数据值表示形式
 *     PrintStream特点：
 *          1.只负责数据的输出，不负责数据的读取
 *          2.与其他输出流不同，PrintStream 永远不会抛出 IOException
 *          3.有特有方法print,println
 *          void print(任意类型的值)
 *          void println(任意类型的值并换行)
 *  构造方法：
 *      PrintStream(File file):输出的目的地是一个文件
 *      PrintStream(OutputStream out):输出的目的地是一个字节输出流
 *      PrintStream(String fileName):输出的目的地是一个文件的路径
 *   PrintStream extends OutputStream
 *          public void close:关闭输出流并释放与此流相关联的任何系统资源。
 *          public void flush: 刷新此输出流并强制任何缓冲的输出字节被写出
 *          public void write(byte[] b): 将b.length字节从指定的字节数组写入此输出流。
 *          public void write(byte[] b,int off,int len): 从指定的字节数组写入len字节，从偏移量off开始输出到此输出流。
 *          public abstract void write(int b):将指定的字节输出流。
 *     注意：
 *      如果使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表 97 -> a
 *      如果使用自己特有的方法print/println方法写数据，写的数据原样输出 97 -> 97
 *
 *
 */
public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("xxxxxxx");
        //创建一个打印流PrintStream对象,构造方法中绑定要输出的目的地
        PrintStream ps = new PrintStream("E:\\home\\yj\\test\\test.txt");
        //如果使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表 97 -> a
        ps.write(97);
        //如果使用自己特有的方法print/println方法写数据，写的数据原样输出 97 -> 97
        ps.println(97);
        ps.println(97.0);
        ps.println("9xxx");
        ps.println(true);
        ps.close();
    }
}
