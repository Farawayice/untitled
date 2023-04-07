package Year_2023.Demo_4.day_04.main;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author liulihua
 * @date 2023/4/7 15:37
 *
 * 可以改变输出语句的目的地(打印流的流向)
 * 输出语句，默认在控制台输出
 * 使用System.setOut 方法改变输出语句的目的地为参数中传递的打印流的目的地
 *    static void setOut(PrintStream out)
 *      重新分配标准”输出流“
 */
public class Demo02PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("在控制台输出");
        PrintStream ps = new PrintStream("E:\\home\\yj\\test\\test.txt");
        System.setOut(ps);
        System.out.println("在打印流的目的地中打印");
        ps.close();

    }
}
