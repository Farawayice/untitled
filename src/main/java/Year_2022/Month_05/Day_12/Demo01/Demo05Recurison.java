package Year_2022.Month_05.Day_12.Demo01;

import java.io.File;

/**
 * @DATA 2022/5/12
 * @Author liulihua
 */
public class Demo04Recurison {
    public static void main(String[] args) {
        File file = new File("E:\\home\\yj");
        getAllFile(file);
    }
    /**
     * 定义一个方法，参数传递File类型的目录
     * 方法中对目录进行遍历
     *
     * */
    public static void getAllFile(File dir){
        System.out.println(dir);
        File [] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
