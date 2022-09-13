package Year_2022.Month_09.Day_13.Demo02;

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
    public static void main(String[] args) {
        show01();
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
