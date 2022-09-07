package Year_2022.Month_05.Day_06.Demo02;

import java.io.File;

/**
 * @DATA 2022/5/6
 * @Author liulihua
 *
 *      File类获取功能的方法：
 *      public String getAbsolutePath():返回此File的绝对路径名字字符串。
 *      public String getPath():将此File转换为路径名字字符串。
 *      public String getName()：返回由此File表示的文件或目录的名称。
 *      public long length():返回由此File表示的文件的大小。
 *
 *      */
public class Demo03File {
    public static void main(String[] args) {
        show04();
    }
    /*
    * public long length():返回由此File表示的文件的大小。
    * 获取的是构造方法指定的文件的大小，以字节为单位
    * 注意：
    *       文件夹是没有大小概念的，不能获取文件夹的大小。
    * 如果构造方法中给出的路径不存在，那么length方法返回0
    * */
    private static void show04() {
        File f1 = new File("D:\\Program Files\\DDD\\a.txt");
        long l1 = f1.length();
        System.out.println(l1);
        File f2 = new File("D:\\Program Files\\DDD\\c.jpg");
        long l2 = f2.length();
        System.out.println(l2);
        File f3 = new File("D:\\Program Files\\DDD");
        long l3 = f3.length();
        System.out.println(l3);

    }

    /*
    * public String getName()：返回由此File表示的文件或目录的名称。
    * 获取的就是构造方法传递路径的结尾部分（文件/文件夹）
    * */
    private static void show03() {
        File f1 = new File("D:\\Program Files\\DDD\\a.txt");
        String name1 = f1.getName();
        System.out.println(name1);
        File f2 = new File("D:\\Program Files\\DDD");
        String name2 = f2.getName();
        System.out.println(name2);


    }

    /*
    *  public String getPath():将此File转换为路径名字字符串。
    *   获取的构造方法中传递的路径
    *  toString就是调用的getPath方法
    *   源码：
    *     public String toString() {
            return getPath();
          }
    * */
    private static void show02() {
        File f1 = new File("D:\\Program Files\\DDD\\a.txt");
        File f2 = new File("a.txt");
        String path1 = f1.getPath();
        System.out.println(path1);
        String path2 = f2.getPath();
        System.out.println(path2);
        System.out.println(f1);
        System.out.println(f1.toString());
    }

    /*
        * public String getAbsolutePath():返回此File的绝对路径名字字符串。
        * 获取的构造方法中传递的路径
        * 无论路径是绝对的还是相对的，getAbsolutePath()方法返回的都是绝对路径
        *
        * */
    private static void show01() {
        File f1 = new File("D:\\Program Files\\DDD\\a.txt");
        String f1AbsolutePath = f1.getAbsolutePath();
        System.out.println(f1AbsolutePath);
        File f2 = new File("a.txt");
        String f2AbsolutePath = f2.getAbsolutePath();
        System.out.println(f2AbsolutePath);
    }
}
