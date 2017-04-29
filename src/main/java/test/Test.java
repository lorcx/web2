package test;

/**
 * Created by dell on 2016/1/28.
 */
public class Test {
    public static void main(String[] args) {
//        Integer[] i = {1,2,3};
////        System.out.println(new Test().join(i , "="));
//        String str = "0";
//        int i = 0;
//        System.out.println(str.equals(i));


//        int startIndex = 0;
//        int endIndex = 0;
//        int unitNum = 500;
//        int size = 600;
//        while (size > 0) {
//            if (size > unitNum) {
//                endIndex = startIndex + unitNum;
//            } else {
//                endIndex = startIndex + size;
//            }
//
//            System.out.println("save...");
//
//            size = size - unitNum;
//            startIndex = endIndex;
//        }


//        int a = 0;
//        int b = 11;
//        int c = 0;
//        c |= a;
//        c |= b;
//        System.out.println(c);


        final int DEFAULT_SOUND = 1;
        final int DEFAULT_VIBRATE = 2; // is the same than 1<<1 or 10 in binary
        final int DEFAULT_LIGHTS = 4;

        int myFlags = DEFAULT_SOUND | DEFAULT_VIBRATE;
//
//        myFlags |= DEFAULT_LIGHTS;
//        System.out.println(myFlags);
        System.out.println(1 << 1);

//        int myFlags = DEFAULT_SOUND | DEFAULT_LIGHTS;

        boolean hasVibrate = (DEFAULT_VIBRATE & myFlags) != 0;
        System.out.println(hasVibrate);
        System.out.println(DEFAULT_VIBRATE & myFlags);

        System.out.println((char) 0x1A);

        boolean b2 = false;
        boolean b1 = true;
        b2 |= b1;

        boolean b3 = b2 || b1;

        System.out.println( "b2 : "+b2);
        System.out.println( "b3 : "+b3);

        System.out.println("_________________________________________");
        boolean flag = true;
        flag &= true;
        System.out.println("true\t&=\ttrue\t==>\t" + flag);
        flag = true;
        flag &= false;
        System.out.println("true\t&=\tfalse\t==>\t" + flag);
        flag = false;
        flag &= true;
        System.out.println("false\t&=\ttrue\t==>\t" + flag);
        flag = false;
        flag &= false;
        System.out.println("false\t&=\tfalse\t==>\t" + flag+"\n");

        flag = true;
        flag |= true;
        System.out.println("true\t|=\ttrue\t==>\t" + flag);
        flag = true;
        flag |= false;
        System.out.println("true\t|=\tfalse\t==>\t" + flag);
        flag = false;
        flag |= true;
        System.out.println("false\t|=\ttrue\t==>\t" + flag);
        flag = false;
        flag |= false;
        System.out.println("false\t|=\tfalse\t==>\t" + flag+"\n");

        System.out.println("^=  相同为真，不同为假");
        flag = true;
        flag ^= true;
        System.out.println("true\t^=\ttrue\t==>\t" + flag);
        flag = true;
        flag ^= false;
        System.out.println("true\t^=\tfalse\t==>\t" + flag);
        flag = false;
        flag ^= true;
        System.out.println("false\t^=\ttrue\t==>\t" + flag);
        flag = false;
        flag ^= false;
        System.out.println("false\t^=\tfalse\t==>\t" + flag);
    }

//    /**
//     * 数组拼接
//     * @param objArr
//     * @param flag
//     * @return
//     */
//    public String join(Object[] objArr, String flag) {
//        StringBuilder result = new StringBuilder();
//        for(int i = 0,len = objArr.length;i < len;i++){
//            result.append(objArr[i]);
//            if(i < len - 1){
//                result.append(flag);
//            }
//        }
//        return result.toString();
//    }
}
