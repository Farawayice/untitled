package Year_2022.Month_11.Day_21.Demo01;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/11/21 16:33
 * FileReader可以读取默认编码格式（UTF-8）的文件
 * FileReader读取系统默认编码（中文GBK）会产生乱码
 */
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader ("E:\\home\\yj\\test\\GBK文本.txt");
        int len = 0;
        while((len = fr.read())!=-1){
            System.out.println((char) len);
        }
        fr.close();
    }
}
