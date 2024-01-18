package Year_2022.Month_09.Day_13.Demo01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/13 14:46
 * JDK7的新特性
 *  在try的后面可以增加一个（），在括号中可以定义流对象
 *  那么这个流对象的作用域就在try中有效
 *  try中的代码执行完毕，会自动把流对象释放，不用写finally
 *      格式：
*           try(){
 *              可能会产生异常的代码
 *          }catch(异常类的变量 变量名){
 *              异常的处理逻辑
 *          }
 */
public class Demo02JDK7 {
    public static void main(String[] args) {
        long o = System.currentTimeMillis();
        try (
                //创建一个字节输入流对象，构造方法放读取的数据源
                FileInputStream fis = new FileInputStream("E:\\home\\yj\\test\\file\\a.txt");
                //创建一个字节输出流对象，构造方法放读取的数据源
                FileOutputStream fos = new FileOutputStream("E:\\home\\yj\\test\\file\\b.txt");
                ){
            byte [] data = new byte[1024];
            int len = 0;
            while ((len = fis.read(data))!=-1){
                fos.write(data,0,len);
            }
        }catch (IOException e){
            System.out.println(e);
        }
        long e = System.currentTimeMillis();
        System.out.println("----"+(o-e)+"----");
    }
}
