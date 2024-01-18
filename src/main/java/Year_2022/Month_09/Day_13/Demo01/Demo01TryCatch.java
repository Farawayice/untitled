package Year_2022.Month_09.Day_13.Demo01;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/9/13 14:26
 * 在jdk1.7之前使用try catch finally 处理流中的异常
 *  格式：
 *      try{
 *              可能会产生异常的代码
 *      }catch(异常类的变量 变量名){
 *          异常的处理逻辑
 *      }finally{
 *          一定会执行的代码
 *          资源释放
 *      }
 */
public class Demo01TryCatch {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("E:\\home\\yj\\test\\file\\g.txt",true);
            for (int i = 0; i < 10; i++) {
                fw.write("helloWord"+i+"\r\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fw != null){
                    fw.flush();
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }

        }

    }
}
