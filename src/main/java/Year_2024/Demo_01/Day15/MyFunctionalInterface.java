package Year_2024.Demo_01.Day15;

/**
 *
 * 函数式接口，有且仅有一个抽象方法的接口，称之位函数式接口。
 * 当然接口中当然可以包含其他的方法（默认，静态，私有）
 *  @FunctionalInterface  函数式接口的注解
 *      作用：监测接口是否是一个函数式接口，
 *          是：编译成功
 *          否：编译失败（接口中没有抽象方法，抽象方法的个数大于1个）
 *
 * @author liulihua
 * @date 2024/1/15
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    //定义一个抽象方法
    public abstract void method();

}
