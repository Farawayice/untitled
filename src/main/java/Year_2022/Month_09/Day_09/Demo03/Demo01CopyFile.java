package Year_2022.Month_09.Day_09.Demo03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 16:10
 * 文件复制练习：一读一写
 * 明确：
 *      数据源：E:\home\yj\test\jpg\tp.jpg
 *      目的地:E:\home\yj\test\png\tp.jpg
 *  文件复制的步骤:
 *  1、定义一个FileInputStream对象绑定数据源
 *  2、定义一个FileOutputStream对象绑定输出目的地
 *  3、按照单字节读取或者字节数组读取
 *  4、调用输出对象写入目的文件
 *  5、关闭输出、输入流释放资源 ，先关闭写的流，再关闭读取的流
 */
public class Demo01CopyFile {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        FileInputStream fis  = new FileInputStream("E:\\home\\yj\\test\\jpg\\tp.jpg");
        FileOutputStream fos = new FileOutputStream("E:\\home\\yj\\test\\png\\tp.jpg");
        int len = 0;
        byte[] data = new byte[1024];
        while ((len=fis.read(data))!=-1){
            fos.write(data,0,len);
        }
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("复制文件耗时："+(e-s)+"毫秒");
    }
}
