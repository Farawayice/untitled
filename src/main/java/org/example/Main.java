package org.example;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
*
*   @DATA ${DATE}
*   @Author liulihua
* */public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String strTime = ("2022-10-28 16:53:00.0");
        String[] split = strTime.split("\\.");

        String s = "1";
        String string = "";
        if (s.equals(string)){
            System.out.println("相同！");
        }else {
            System.out.println("不同或为空！");
        }
        String str = "{\"status\":\"其他\"}";

        String[] split2 = str.split("\"");
        for (String s1 : split2) {
            System.out.println(s1);
        }
        if (split2[3].equals("1")){
            System.out.println("===========");
        }

        System.out.println(split2[3]);
    }
}