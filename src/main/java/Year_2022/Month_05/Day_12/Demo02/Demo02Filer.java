package Year_2022.Month_05.Day_12.Demo02;

import java.io.File;

/**
 * @DATA 2022/5/12
 * @Author liulihua
 *
 * 要求遍历文件夹E:\home中的文件，
 * 只要已.java结尾的文件
 * E:\home
 *
 * 我们可以使用过滤器来实现
 * 在File类中有两个和ListFiles重载的方法，方法的参数传递的就是过滤器
 * File [] listFiles(FileFilter filter)
 * java.io.FileFilter:接口 用于抽象路径名（File 对象）的过滤器。
 * 作用：用来过滤文件（File对象）
 *      抽象方法：用来过滤文件的方法
 *          boolean accept（File pathname）测试指定抽象路径名师傅应包含在某个路径名列表中。
 *              参数： File pathname :使用ListFiles 方法遍历目录，得到的每一个文件对象
 * File [] listFiles(FilenameFilter filter)
 *  java.io.FilenameFilter接口：实现接口的类实例可用于过滤器文件名。
 *  作用：用于过滤文件名称
 *  抽象方法：用来过滤文件的方法
 *      boolean accept(File dir,String name):测试指定文件是否应该包含在某一文件列表中。
 *      参数：
 *          File dir:构造方法中传递的被遍历的目录
 *          String name:使用ListFiles方法遍历目录，获取的每一个文件/文件夹的名称
 *   注意：两个过滤器接口无实现类，需要自己写实现类，重写过滤方法accept,在方法中自己定义过滤的规则
 *
 * */
public class Demo01Filer {

    public static void main(String[] args) {
        File file = new File("E:\\home\\yj");
        getAllFile(file);
    }

    /**
     * 定义一个方法，参数传递File类型的目录
     * 方法中对目录进行遍历
     */
    public static void getAllFile(File dir) {
        File[] files = dir.listFiles(new FileFilterImpl());//传递过滤器对象
        /**
         * listFiles方法一共做了三件事：
         * 1.listFiles方法会对构造方法中传递的目录进行遍历，获取目录中的每一个文件/文件夹-->封装为File对象
         * 2.listFiles方法会调用参数传递的过滤器中的方法accept
         * 3.listFiles方法会把遍历得到的每一个File对象，传递过accept方法的参数pathname
         *---------------------------------------------------------------------
         * accept方法:返回值是一个布尔值
         * true：就会把传递过去的File对象保存到File数组中
         * false:就不会把传递过去的File对象保存到File数组中。
         *
         * */
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }
}

