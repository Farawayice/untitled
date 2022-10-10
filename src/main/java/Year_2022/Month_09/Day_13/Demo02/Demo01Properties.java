package Year_2022.Month_09.Day_13.Demo02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

/**
 * @author liulihua
 * @date 2022/9/13 16:50
 * java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
 *     Properties 类表示了一个持久的属性集。Properties可保存在流汇总或从流中加载
 *     Properties 集合是唯一一个和IO流相结合的集合
 *          可以使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储
 *          可以使用Properties集合中的方法load,把硬盘中保存的文件（键值对），读取到集合中使用
 *     属性列表中每一个键及其对应值都是一个字符串
 *          Properties集合是一个双列集合，key和valuemore都是字符串
 *          
 *
 */
public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        show03();
    }
    /**
     * 可以使用Properties集合中的方法load,把硬盘中保存的文件（键值对），读取到集合中使用
     *      void load(InputStream inStream)
     *      load(Reader reader)
     *      参数：
     *          InputStream inStream :字节输出流，不能读取含有中文的键值对
     *          Reader reader :字符输入流，能读取含有中文的键值对
     *      使用步骤：
     *          1.使用Properties集合对象
     *          2.使用Properties集合对象中的方法load读取保存键值对的文件
     *          3.遍历Properties集合对象
     *      注意：
     *          1.存储键值对的文件中，键与值默认的连接符号可以使用=，空格（其他符号）
     *          2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再读取
     *          3.存储键值对的文件中中，键与值默认都是字符串，不用再加引号
     * */
    private static void show03() throws IOException {
        //1.使用Properties集合对象
        Properties prop = new Properties();
        //2.使用Properties集合对象中的方法load读取保存键值对的文件
//        prop.load(new FileReader("E:\\home\\yj\\test\\file\\porp.txt"));
//        prop.load(new FileInputStream("E:\\home\\yj\\test\\file\\porp.txt"));//字节输入流读取中文会乱码
        //3.遍历Properties集合对象
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String property = prop.getProperty(key);
            System.out.println(key+"="+property );
        }

    }

    /**
     * 可以使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储
     * void store(OutputStream out,String comments)
     * store(Writer writer,String comments)
     *  参数：
     *      OutputStream out: 字节输出流，不能写入中文
     *      String comments:  注释，用来解释说明保存的文件是做什么用的
     *                  不能使用中文，会缠身乱码，默认是Unicode编码
     *                  一般使用空字符串
     * 使用步骤：
     *      1.创建Properties 集合对象，添加数据
     *      2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
     *      3.使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储(字符流可以写中文，字节流不能写中文)
     *      4.释放资源
     * */
    private static void show02() throws IOException {
        //创建Properties 集合对象，添加数据
        Properties porp = new Properties();
        porp.setProperty("远辰","176");
        porp.setProperty("知非","176");
        porp.setProperty("xxx","175");
        //创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        FileWriter fw = new FileWriter("E:\\home\\yj\\test\\file\\porp.txt");
//        porp.store(fw,"Save data");
//        fw.close();
        porp.store(Files.newOutputStream(Paths.get("E:\\home\\yj\\test\\file\\port2.txt")),"");
    }

    /**
     * 使用Properties集合存储数据，遍历出Properties集合中的数据
     * Properties集合是一个双列集合，key和value默认都是字符串
     * Properties集合有一些操作字符串的特有方法
     *      Object setProperty(String key,String value):调用Hashtable方法put
     *      object getProperty(String key):通过key找到value值此方法相当于Map集合中的get(key)方法
     *      set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串
     * */
    private static void show01() {
        //创建一个Properties对象
        Properties porp = new Properties();
        //调用Object setProperty(String key,String value):调用Hashtable方法put
        porp.setProperty("远辰","176");
        porp.setProperty("知非","176");
        porp.setProperty("xxx","175");
        //调用set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串
        Set<String> set = porp.stringPropertyNames();
        for (String key : set) {
            String value = porp.getProperty(key);
            System.out.println(key+":"+value);
        }
    }

}
