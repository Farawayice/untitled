package Test.workTest;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * @author liulihua
 * @date 2022/10/26 11:04
 */
public class test {

    public static void main(String[] args) {
        /**
         * 单属性变量list 自定义顺序排序
         */
        List<String> list =new ArrayList<>();
        list.add("43");
        list.add("92");
        list.add("81");
        list.add("99");
        list.add("102");
        int size = list.size();
        String num = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int n = Integer.parseInt(list.get(i));
                int m = Integer.parseInt(list.get(j));
                if (n<m){
                    num=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,num);
                }
            }
        }
        list.forEach(n->{
            System.out.print(n+" ");
        });

    }
}
