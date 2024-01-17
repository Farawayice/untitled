package Year_2024.Demo_01.Day16;

/**
 *  例如java.lang.Runnable接口就是一个函数式接口，
 *  假设有一个startThread方法使用该接口作为参数，那么就可以使用Lambda进行参数。
 *  这种情况其实和Thread类的构造方法参数为Runnable没有本质区别。
 *
 * @author liulihua
 * @date 2024/1/16 16:21
 */
public class Demo04Runnable {
    //定义一个方法startThread，方法的参数使用函数式接口Runnable
    public static void startThread(Runnable run){
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //调用startThread方法，方法的参数是一个函数式接口，那么可以传递匿名内部类或实现类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->"+"线程启动");
            }
        });
        //调用startThread方法，方法的参数是一个函数式接口，所以可以传递Lambda表达式
        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"-->"+"线程启动111");
        });
        //优化Lambda表达式
        startThread(()->System.out.println(Thread.currentThread().getName()+"-->"+"线程启动111"));

    }
}
