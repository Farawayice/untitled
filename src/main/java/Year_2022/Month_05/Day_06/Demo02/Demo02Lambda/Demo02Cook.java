package Year_2022.Month_05.Day_06.Demo02;

import java.util.SortedMap;

/**
 * @DATA 2022/5/9
 * @Author liulihua
 */
public class Demo02Cook {
    public static void main(String[] args) {
        //调用invokeCook方法，参数是Cook接口，传递Cook接口的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭！");
            }
        });
        //使用lambda表达式
        invokeCook(()->{
            System.out.println("吃饭了！");
        });

        
    }
    //定义一个方法，传递Cook接口，方法内部调用Cook接口中的方法makeFood
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
