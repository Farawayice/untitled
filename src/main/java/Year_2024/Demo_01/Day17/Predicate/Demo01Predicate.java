package Year_2024.Demo_01.Day17.Predicate;


import java.util.function.Predicate;

/**
 *  java.util.function.Predicate<T>接口
 *  作用：对某种数据类型的数据进行判断，结果返回一个boolean值
 *  Predicate 接口 中包含一个抽象方法：
 *  boolean test（T t）：用来对指定数据类型数据判断的方法，
 *      结果：
 *          符合条件：true
 *          不符合条件：false
 * @author liulihua
 * @date 2024/1/17
 */
public class Demo01Predicate {
    /**
     * 定义一个方法
     * 参数传递一个String类型的字符串
     * 传递一个Predicate接口，泛型使用String
     * 使用Predicate接口中的方法test对字符串进行判断，并把判断的结果返回
     * */
    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "abdcsd";
        //调用checkString方法对字符串进行校验，参数传递字符串和Lambda表达式
        boolean b = checkString(s, (String str) -> {
            //对对象传递的字符串进行判断，判断字符串长度是否大于5，并把判断结果返回
            return str.length() > 5;
        });
        System.out.println(b);
        //优化Lambda表达式
        boolean b1 = checkString(s, (str) -> str.length() > 5);
        System.out.println(b1);
    }
}
