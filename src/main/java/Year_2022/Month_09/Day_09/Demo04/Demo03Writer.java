package Year_2022.Month_09.Day_09.Demo04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 17:24
 *      字符输出流写数据的其它方法
 *  *      void write(char[] cbuf)写入字符数组
 *  *      abstract void write(charp[] cbuf,int off,int len):写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 *  *      void write(String str)写入字符串
 *  *      void write(String str,int off.int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 *  *
 */
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\home\\yj\\test\\f.txt");
        char [] chars = {'a','b','c','0'};
        fw.write(chars);
        fw.write('\r');
        fw.write('\n');
        fw.write("1234567890",2,5);
        fw.write(chars,1,2);
        fw.flush();
    }
}
