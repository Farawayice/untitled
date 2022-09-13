package Year_2022.Month_09.Day_09.Demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 14:48
 * 追加写，续写
 * FileOutputStream(String name ,boolean append) 创建一个向具有指定name的文件中写入数据的输出文件流
 * FileOutputStream(File file ,boolean append) 创建一个向指定file对象表示的文件中写入数据的文件输出流
 *      参数：
 *      String name,File file :写入数据的目的地
 *      boolean append :追加写开关
 *      true : 创建对象不会覆盖原文件，继续在文件的末尾追加写数据
 *      false: 创建一个新文件，覆盖原文件
 *  写换行：写换行符号
 *  windows:\r\n
 *  linux:\n
 *  mac :\r
 */
public class Demo03OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\home\\yj\\test\\c.txt",true);
        for (int i = 0; i < 10; i++) {
            fileOutputStream.write("测试".getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }
}
