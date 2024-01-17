package Year_2024.Demo_01.Day16;

/**
 *  使用Lambda优化日志案例
 *  Lambda特点：延迟加载
 *              使用前提，必须存在函数式接口
 *
 *
 * @author liulihua
 * @date 2024/1/16 16:08
 */
public class Demo02Lambda {
    //定义一个显示日志的方法，方法的参数传递日志的等级和MessageBuilder接口
    private static  void showLog(int level,MessageBuilder mb){
        //对日志的等级进行判断，如果是1级别，则调用MessageBuilder接口中的builderMessage方法
        if (level==1){
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        String msgA = "hello";
        String msgB = "world";
        String msgC = "java";
//        showLog(2,()->{
//            //返回一个拼接好的字符串
//            return msgA+msgB+msgC;
//        });
        /**
         * 使用Lambda表达式作为参数传递，仅仅是把参数传递到showlog方法中
         * 只有满足条件，日志的等级是1级
         *      才会调用接口MessageBuilder接口中的方法builderMessage也不会执行
         *      所以拼接字符串的代码也不会执行
         *  所以不会存在性能浪费的问题
         *
         * */
        showLog(1,()->{
            //返回一个拼接好的字符串
            System.out.println("不满足条件不执行！");
            return msgA+msgB+msgC;
        });
    }
}
