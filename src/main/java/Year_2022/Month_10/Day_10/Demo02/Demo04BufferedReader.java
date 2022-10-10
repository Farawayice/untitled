package Year_2022.Month_10.Day_10.Demo02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/10/10 16:40
 * java.io.BufferedReader extends Reader
 * BufferedReader:字符缓冲输入流
 *  继承自父类的共性成员方法：
 *      int read() 读取单个字符并返回
 *      int read(char[] char)一次读取多个字符，将字符读入数组
 *      void close()关闭该流并释放阈值关联的所有资源
 *  构造方法：
 *      BufferedReader(Reader in)创建一个使用默认大小输入缓冲区的缓冲字符输入流。
 *      BufferedReader(Reader in, int size)创建一个使用指定大小输入缓冲区的缓冲字符输入流
 *      参数：
 *          Reader in:字符输入流
 *              我们可以传递FileReader,缓冲流会给FileReader增加一个缓冲区，提高FileReader的读取效率
 *  特有的成员方法：
 *      String readLine()读取一个文本行。
 *
 *      返回值：
 *         包含该行内容的字符串，不包含任何行终止符，如果已经到达流末尾，则返回null
 *      使用步骤：
 *          1，创建字符缓冲输入流对象，构造方法中传递字符输入流
 *          2，使用字符缓冲输入流对象中的方法read/readLine读取文本
 *          3，释放资源
 */
public class Demo04BufferedReader {
    public static void main(String[] args) throws IOException {
        //1，创建字符缓冲输入流对象，构造方法中传递字符输入流
        BufferedReader br = new BufferedReader(new FileReader("E:\\home\\yj\\test\\file\\BufferedWriter.txt"));
        //2，使用字符缓冲输入流对象中的方法read/readLine读取文本
        String s;
        while ((s =br.readLine())!=null){
            System.out.println(s);
        }
        //3，释放资源
        br.close();
    }
}
