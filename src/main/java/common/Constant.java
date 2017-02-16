package common;

/**
 * 常量类
 * Created by lx on 2016/2/28.
 */
public class Constant {

    //默认每页个数
    public static final int DEFAULT_PAGE_NUM = 10;
    //默认当前页
    public static final int CURRENT_NUM = 1;

    /**
     * 菜单
     */
    public enum MenuType {
        CATALOG(0),//目录
        MENU(1),//菜单
        BUTTON(2);//按钮

        private int value;

        public int getValue() {
            return value;
        }

        MenuType(int value) {
            this.value = value;
        }
    }
}
