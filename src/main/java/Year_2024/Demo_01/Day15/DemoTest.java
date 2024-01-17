package Year_2024.Demo_01.Day15;

/**
 * 函数式接口的使用：一版作为方法的参数和返回值类型
 *
 *
 * @author liulihua
 * @date 2024/1/15
 */

public class DemoTest {
    //定义一个方法，参数使用函数式接口，MyFunctionalInterface Interface
    public static void show(MyFunctionalInterface myInterface){
        myInterface.method();
    }
    public static void main(String[] args){
        //调用show方法，方法的参数是一个接口，所以可以传递接口的实现类对象
        show(new MyFunctionalInterfaceImpl());

        //使用show方法，方法的参数是一个接口，所以我们可以传递接口的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类中的抽象方法");
            }
        });

        //调用show方法，方法的参数是一个函数式接口，所以我们可以使用Lambda表达式
        show(()->{
            System.out.println("使用Lambda表达式，重写接口。");
        });

        //简化Lambda表达式
        show(()-> System.out.println("简化 使用Lambda表达式，重写接口。"));
    }
}
