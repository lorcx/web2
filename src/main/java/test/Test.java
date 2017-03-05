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


        int startIndex = 0;
        int endIndex = 0;
        int unitNum = 500;
        int size = 600;
        while (size > 0) {
            if (size > unitNum) {
                endIndex = startIndex + unitNum;
            } else {
                endIndex = startIndex + size;
            }

            System.out.println("save...");

            size = size - unitNum;
            startIndex = endIndex;
        }
    }

    /**
     * 数组拼接
     * @param objArr
     * @param flag
     * @return
     */
    public String join(Object[] objArr, String flag) {
        StringBuilder result = new StringBuilder();
        for(int i = 0,len = objArr.length;i < len;i++){
            result.append(objArr[i]);
            if(i < len - 1){
                result.append(flag);
            }
        }
        return result.toString();
    }
}
