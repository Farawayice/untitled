package Year_2022.Month_11.Day_21.Demo01;

import java.io.*;

/**
 * @author liulihua
 * @date 2022/11/21 17:20
 * InputStreamReader:是字节流通向字符流的桥梁:它使用指定的charset读取字节并将其解码为字符.(解码把看不懂的变成能看懂的)
 *
 *      int read() 读取单个字符并返回
 *      int read(char[] cbuf)一次读取多个字符,将字符读入数组.
 *      void close()关闭该流并释放与之关联的所有资源
 *      构造方法
 *      InputStreamReader(InputStream in)使用默认字符集
 *      InputStreamReader(InputStream in ,String charsetName)创建使用指定字符集InputStreamReader
 *      参数:
 *          InputStream in 字节输入流
 *          String charsetName 字符集名称
 *      使用方法
 *      1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称
 *      2.使用InputStreamReader对象中的方read读取文件
 *      3.释放资源
 *      注意事项:
 *          构造方法中指定的编码表名称和文件的编码相同,否则会发生乱码
 */
public class Demo03InputStreamReader{
    public static void main(String[] args) throws IOException {
//        reader_utf_8();
        reader_gbk();
    }

    private static void reader_gbk() throws IOException {
        //1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称
        InputStreamReader in  = new InputStreamReader(new FileInputStream("E:\\home\\yj\\test\\GBK文本.txt"),"gbk");
        //2.使用InputStreamReader对象中的方read读取文件
        int len = 0;
        while ((len = in.read())!=-1){
            System.out.println((char) len);
        }
        //3.释放资源
        in.close();

    }

    private static void reader_utf_8() throws IOException {
        //1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称
//        InputStreamReader in  = new InputStreamReader(new FileInputStream("E:\\home\\yj\\test\\utf_8.txt"),"UTF-8");
        //默认使用utf-8
        InputStreamReader in  = new InputStreamReader(new FileInputStream("E:\\home\\yj\\test\\utf_8.txt"));
        //2.使用InputStreamReader对象中的方read读取文件
        int len = 0;
        while ((len = in.read())!=-1){
            System.out.println((char) len);
        }
        //3.释放资源
        in.close();
    }
}
