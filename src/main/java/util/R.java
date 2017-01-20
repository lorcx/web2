package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R result = new R();
        result.put("msg",msg);
        return result;
    }

    public static R ok(Map<String, Object> map) {
        R result = new R();
        result.putAll(map);
        return result;
    }

    public static R error(){
        return error(500, "未知异常，请联系管理员！");
    }

    public static R error(String msg){
        return error(500, msg);
    }

    public static R error(int code, String msg){
        R result = new R();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
