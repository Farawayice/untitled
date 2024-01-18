package Year_2022.Month_10.Day_10.Demo02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author liulihua
 * @date 2022/10/10 15:40
 *      文件复制练习：一读一写
 *    明确：
 *      数据源：E:\home\yj\test\jpg\a.jpg
 *      数据的目的地：E:\home\yj\test\png\a.jpg
 *    文件复制的步骤
 *          1.创建字节缓冲输入流对象，构造方法中传递字节输入流
 *          2.创建字节缓冲输出流对象，构造方法中传递字节输出流
 *          3.使用字节输入流对象中的read方法，读取文件
 *          4.使用字节缓冲输出流中的方法write 把读取到的数据写入到内部缓冲区中
 *          5.释放资源
 */
public class Demo02CopyFile {//E:\home\yj\test\jpg
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        //
        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get("E:\\home\\yj\\test\\jpg\\a.jpg")));
        BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Paths.get("E:\\home\\yj\\test\\png\\a.jpg")));
        //单独个字节写入用时19mm
//        int len = 0;
//        while ((len = bis.read())!=-1){
//            bos.write(len);
//        }

        //用数组来存储写入用时6mm
        byte [] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes);
        }

        bos.flush();
        bos.close();
        bis.close();
        long e = System.currentTimeMillis();
        System.out.println("运行所需的毫秒值"+(e-s));
    }

}
