package Year_2024.Demo_01.Day16.Supplier;

import java.util.function.Supplier;

/**
 * Supplier接口 练习
 *
 * @author liulihua
 * @date 2024/1/16 16:55
 */
public class Demo02Test {
    //定义一个方法，用于获取int类型数组中元素的最大值，方法的参数传递Supplier接口，泛型使用Integer
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }
    //
    public static void main(String[] args) {
        //定义一个int类型的数组，并赋值
        int [] arr = {100,0,-50,88,99,33,-30};
        //调用getMax方法，方法的参数Supplier是一个函数式接口，所以可以传递Lambda表达式
        int max1 = getMax(() -> {
            //获取数组的最大值，并返回
            //定义一个变量，把数组中男的第一个元素赋值给该变量，记录数组中元素的最大值
            int max = arr[0];
            //遍历数组，获取数组中的其他元素
            for (int i : arr) {
                //使用其他元素和最大值比较
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(max1 );
    }
}
