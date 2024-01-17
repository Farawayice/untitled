package Year_2024.Demo_01.Day17.Predicate;

import java.util.function.Predicate;

/**
 *      需求：判断一个字符串，有两个判断的条件
 *          1.判断字符串的长度是否大于5
 *          2.判断字符串中是否包含a
 *      满足一个条件就可以，我们就可以使用||运算符连接两个条件
 *      Predicate 接口中有一个方法or，表示并且关系，也可以用于连接两个判断条件
 *      default Predicate<T> or(Predicate<? super T> other){
 *          Objects.requireNonNull(other);
 *          return （t）-> this.test(t) || other.test(t);
 *      }
 * @author liulihua
 * @date 2024/1/17 16:24
 */
public class Demo03Predicate_or {
    /**
     * 定义一个方法，方法的参数，传递一个字符串
     * 传递两个Predicate接口，
     *      一个用于判断字符串的长度是否大于5
     *      一个用于判断字符串中是否包含a
     *      满足一个条件即可
     *
     * */
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2){
//        return pre1.test(s)||pre2.test(s);
        return pre1.or(pre2).test(s);//等价于return pre1.test(s)||pre2.test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "bcdef";
        //调用checkString 方法，参数传递字符串和两个Lambda表达式
        boolean b = checkString(s, (s1) -> {
            //判断字符串的长度是否大于5
            return s1.length()>5;
        }, (s2) -> {
            //判断字符串中是否包含a
            return s2.contains("a");
        });
        System.out.println(b);
    }
}
