package Year_2022.Month_11.Day_21.Demo01;

import java.io.*;

/**
 * @author liulihua
 * @date 2022/12/5 15:37
 * 练习：转换文件的编码
 *      将GBK编码的文本文件，转换为UTF-8编码的文本文件。
 * 分析：
 *      1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称GBK
 *      2.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称UTF-8
 *      3.使用InputStreamReader对象中的方法read读取文件
 *      4.使用OutputStreamWriter对象中的方法Write,把读取到的数据写入到文件中
 *      5.释放资源
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称GBK
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\home\\yj\\test\\GBK文本.txt"),"GBK");
        //2.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\home\\yj\\test\\text_utf-8.txt"),"UTF-8");
        //3.使用InputStreamReader对象中的方法read读取文件
        int len = 0;
        while ((len = isr.read())!=-1){
            //4.使用OutputStreamWriter对象中的方法Write,把读取到的数据写入到文件中
            osw.write(len);
        }
        //
        osw.flush();
        System.out.println("运行成功");

        osw.close();
        isr.close();
    }
}
