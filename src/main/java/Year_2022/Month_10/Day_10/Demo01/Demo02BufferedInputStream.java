package Year_2022.Month_10.Day_10.Demo01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/10/10 15:12
 * java.io.BufferedInputStream extends InputStream
 * BufferedInputStream 字节缓冲输入流
 *  继承自父类的成员方法:
 *      int read()从输入流中读取数据的下一个字节。
 *      int read(byte[] b)从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
 *      void close()关闭此输入流并释放与该流关联的所有系统资源。
 *  构造方法：
 *      BufferedInputStream（InputStream in）创建一个BufferedInputStream 并保存其参数，即输入流in ，以便将来使用。
 *      BufferedInputStream（InputStream in ，int size）创建具有指定缓冲区大小的BufferedInputStream 并保存其参数，即输入流in,以便将来使用。
 *      参数：
 *          InputStream in:字节输入流
 *              我们可以传递FileInputStream,缓冲区会给FileInputStream增加一个缓冲区，提高FileInputStream的读取效率
 *          int size:指定缓冲流内部缓冲区的大小，不指定默认
 *      使用步骤：
 *          1.创建一个FileInputStream 对象，构造方法中绑定要读取的数据流
 *          2.创建一个BufferedInputStream对象，构造方法中传递FileInputStream对象,提高读取效率
 *          3.使用BufferedInputStream对象中的方法read,读取文件
 *
 */
public class Demo02BufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\home\\yj\\test\\file\\BufferedOutputStream.txt");
        BufferedInputStream bfs = new BufferedInputStream(fis);
   /*     int len=0;//
        while ((len=bfs.read())!=-1){
            System.out.println(len);
        }*/
        byte[] bytes = new byte[1024];//存储每次读取的数据
        int len = 0;//记录每次读取的有效字节个数
        while ((len = bfs.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }


        bfs.close();
    }
}
