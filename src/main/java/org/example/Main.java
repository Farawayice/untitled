package org.example;

import java.sql.Timestamp;
import java.util.*;

/**
*
*   @DATA ${DATE}
*   @Author liulihua
* */public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.set(0,"1");
        list.set(1,"2");
        list.set(3,"3");
        list.set(2,"4");
        list.set(4,"5");
        for (String S : list) {
            System.out.println(S);
        }
    }
}