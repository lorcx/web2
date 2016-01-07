package test;

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
    }

}