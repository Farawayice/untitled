package Year_2022.Month_05.Day_06.Demo02;

/**
 * @DATA 2022/5/9
 * @Author liulihua
 * 创建Runnable接口的实现类，重写run方法，设置线程任务
 */
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"新线程创建了");
    }
}
