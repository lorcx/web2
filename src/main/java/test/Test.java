package test;

/**
 * Created by dell on 2016/1/28.
 */
public class Test {
    public static void main(String[] args) {
        Integer[] i = {1,2,3};
        System.out.println(new Test().join(i , "="));
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
