package Year_2024.Demo_01.Day17.Predicate;

import java.util.function.Predicate;

/**
 *      需求：判断一个字符串长度是否大于5
 *          如果字符串的长度大于5，那返回false
 *          如果字符串的长度不大于5，那么返回true
 *      所以我们可以使用取反符号！对判断的结果进行取反
 *      Predicate 接口中有一个方法negate，表示取反意思
 *      default Predicate<T> negate(){
 *          return （t）-> ！test(t);
 *      }
 * @author liulihua
 * @date 2024/1/17 16:29
 */
public class Demo04Predicate_negate {

    /**
     * 定义一个方法，方法的参数，传递一个字符串
     * 使用Predicate接口，
     * 用于判断字符串的长度是否大于5
     * */
    public static boolean checkString(String s, Predicate<String> pre1){
//        return !pre1.test(s);
        return pre1.negate().test(s);//等价于return !pre1.test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "abc";
        //调用checkString方法参数传递字符串和Lambda表达式
        boolean b = checkString(s, (str) -> {
            return str.length() > 5;
        });
        System.out.println(b);
        boolean b1 = checkString(s, (str) -> str.length() > 5);
        System.out.println(b1);
    }

}
