package Year_2022.Month_09.Day_09.Demo04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/9 17:19
 * flush 方法和close方法区别
 *      -flush:刷新缓存区，流对象可继续使用。
 *      -close:先刷新缓存区，然后通知系统释放资源，流对象不可以载被使用了。
 *
 *
 *
 */
public class Demo02CloseAndFlush {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\home\\yj\\test\\d.txt");
        fw.write(97);
        //刷新后，流可继续使用
        fw.flush();
        fw.write(98);
        //关闭缓存，释放资源，流不可再次使用
        fw.close();
//        fw.write(99);//Stream closed
    }
}
