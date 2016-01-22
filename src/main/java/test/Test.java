package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import module.entity.base.BaseUser;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by dell on 2015/12/14.
 */
public class Test {
    public static void main(String[] args) {
        int i = 0x1010 & 0x1111;
        int i1 = 0x0 & 0x1;
        System.out.println(i);
        System.out.println(i1);
        /**
         * 位运算
         *
         * 1  1  1
         * 0  0  0
         * 1  0  0
         * 0  1  0
         * 0101 0011 0001  :5 & 3  1
         * 0100 0001 0000  :4 & 1  0
         */
        int n1 = 5 << 2;
        System.out.println(n1);
        int n2 = 5 >> 2;
        System.out.println(n2);
        /**
         * 左移 (最低位补0)
         * int 是4个字节 32位  （1字节8位）
         * 0000 0000 0000 0000 0000 0000 0000 0101 : 5
         * 0000 0000 0000 0000 0000 0000 0001 0100 : 20
         *                                  4 3210 : 2^4 + 2^2
         *
         *
         * 右移 (最高位补0)
         * 0000 0000 0000 0000 0000 0000 0000 0101 : 5
         * 0000 0000 0000 0000 0000 0000 0000 0001 : 1
         *                                         2^0
         *
         * long 8字节
         * 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001 : 1
         *   << 60
         * 0001 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 : 268435456
         */

        int n3 = 1 << 60;
        System.out.println(n3);

        System.out.println("--------------------------------gson-----------------------------------------");
        int[] numbers = {1, 1, 2, 3, 5, 8, 13};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        Gson gson = new Gson();

        String str1 = gson.toJson(numbers);
        String str2 = gson.toJson(days);
        System.out.println(str1);
        System.out.println(str2);

        int[] ins = gson.fromJson(str1,int[].class);
        System.out.println(ins);
//        for (int i2 : ins){
//            System.out.println(i2);
//        }

        int[][] data = {{1, 2, 3}, {3, 4, 5}, {4, 5, 6}};
        String str3 = gson.toJson(data);
        System.out.println(str3);

        List<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add("Mallory");

       String str4 = gson.toJson(names);
        System.out.println(str4);

        BaseUser b1 = new BaseUser("1","aa","123","123",null,"1",null);
        BaseUser b2 = new BaseUser("2","bb","165","123",null,"1",null);
        BaseUser b3 = new BaseUser("3","cc","345","123",null,"1",null);

        System.out.println("list 转 json字符串");
        List<BaseUser> userList = Arrays.asList(b1,b2,b3);
        String str5 = gson.toJson(userList);
        System.out.println(str5);

        System.out.println("json字符串转 list");
        Type type = new TypeToken<List<BaseUser>>(){}.getType();
        List<BaseUser> bus = gson.fromJson(str5,type);
        for (BaseUser bu : bus){
            System.out.println(bu.getUserName());
        }

        System.out.println("map处理");
        Map<String, String> colours = new HashMap<String, String>();
        colours.put("BLACK", "#000000");
        colours.put("RED", "#FF0000");
        colours.put("GREEN", "#008000");
        colours.put("BLUE", "#0000FF");
        colours.put("YELLOW", "#FFFF00");
        colours.put("WHITE", "#FFFFFF");
        String str6 = gson.toJson(colours);
        System.out.println(str6);
        Type type1 = new TypeToken<Map<String ,String >>(){}.getType();
        Map<String ,String > map2 = gson.fromJson(str6,type1);
        for (Map.Entry<String ,String > entry : map2.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("操作对象");
        String str7 = gson.toJson(b1);
        System.out.println(str7);

        BaseUser bu = gson.fromJson(str7,BaseUser.class);
        System.out.println(bu.getUserName());

        Type type3 = new TypeToken<BaseUser>(){}.getType();
        gson.fromJson(str7,type3);

        System.out.println("如何利用Gson处理一个对象的某一字段。");


    }


}
