package Year_2022.Month_09.Day_09.Demo03;


import java.io.FileReader;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 16:30
 *
 *  java.io.Reader : 字符输入流的最顶层父类，定义了一些共性的成员方法，是一个抽象类
 *  共性的成员方法：
 *      int read(): 读取单个字符
 *      int read(char[] cbuf): 读取多个字符
 *      void close():关闭流
 *  java.io.FileReader extends InputStreamReader extends Reader
 *  FileReader：文件字符输入流
 *  作用：把硬盘文件中的数据以字符的方式读取到内存中
 *  构造方法：
 *      FileReader(String filename)
 *      FileReader(File file)
 *      参数：读取文件的数据源
 *          string fileName:文件的路径
 *          File file:一个文件
 *      FileReader构造方法的作用：
 *          创建一个对象FileReader,绑定读取文件的数据源或者绑定读取的文件
 *      FileReader的使用步骤：
 *      1、创建FileReader,构造方法中绑定要读取的数据源
 *      2、使用FileReader对象中的方法read读取文件
 *      3、释放资源
 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        long r = System.currentTimeMillis();
        FileReader frd = new FileReader("E:\\home\\yj\\test\\c.txt");
        int len = 0;
        char [] chars = new char[1024];
        while ((len = frd.read(chars))!=-1){
//            for (int i = 0; i < len; i++) {
//                System.out.print(chars[i]);
//            }
            System.out.println(new String(chars,0,len));
        }
        frd.close();
        long e = System.currentTimeMillis();
        System.out.println("程序运行时间："+(e-r)+"毫秒");
    }
}
