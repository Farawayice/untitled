package Year_2022.Month_05.Day_05.Demo01;

/**
 * @DATA 2022/5/5
 * @Author liulihua
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable 接口的实现类对象
        Runnableimpl run = new Runnableimpl();
        //创建Thread 类对象，构造方法中传递Runnable 接口的实现类对象
        Thread t0  = new Thread(run);
        Thread t1  = new Thread(run);
        Thread t2  = new Thread(run);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}
