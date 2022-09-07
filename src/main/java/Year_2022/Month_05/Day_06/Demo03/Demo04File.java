package Year_2022.Month_05.Day_06.Demo02;

import java.io.File;

/**
 * @DATA 2022/5/9
 * @Author liulihua
 *
 * File类判断功能的方法：
 *  public boolean exists():此File表示的文件或目录是否实际存在。
 *  public boolean isDirectory():此File表示的是否为目录。
 *  public boolean isFile()；此File表示是否为文件
 *
 */
public class Demo04File {
    public static void main(String[] args) {
        show02();
    }
    /**
     * public boolean isDirectory():此File表示的是否为目录。
     * public boolean isFile()；此File表示是否为文件
     *      是：true
     *      否：false
     * 注意：
     *      电脑的影片中只有文件、文件夹，两个方法互斥
     *      这两个方法使用前提，路径必须存在，否则均返回false
     * */
    private static void show02() {
        File f1 = new File("E:\\工作\\DataAcquisition-dev");
        boolean b11 = f1.isDirectory();
        boolean b12 = f1.isFile();
        System.out.println(b11);
        System.out.println(b12);
        System.out.println("------");
        File f2 = new File("E:\\工作\\DataAcquisition-dev\\pom.xml");
        boolean b21 = f2.isDirectory();
        boolean b22 = f2.isFile();
        System.out.println(b21);
        System.out.println(b22);
        System.out.println("------");
        File f3 = new File("E:\\工作\\DataAcquisition-dev\\pom .xml");
        //不存在，没必要获取
        if (f3.exists()){
            System.out.println(f3.isDirectory());
            System.out.println(f3.isFile());
        }

    }

    /**
    * public boolean exists():此File表示的文件或目录是否实际存在。
    * 用于判断构造方法中的路劲是否存在
     *      存在：true
     *      不存在：false
    * */
    private static void show01() {
        File f1 = new File("E:\\工作\\DataAcquisition-dev");
        boolean b1 = f1.exists();
        System.out.println(b1);
        File f2 = new File("E:\\工作\\DataAcquisition-de");
        boolean b2 = f2.exists();
        System.out.println(b2);
        File f3 = new File("pom.xml");
        boolean b3 = f3.exists();
        System.out.println(b3);
    }

}
