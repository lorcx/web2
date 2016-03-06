package common;

/**
 * 分页
 * 起始页：（当前页-1*每页个数）+1
 * 结束页：（当前页*每页个数）
 * 总页数： 总记录数/每页的个数
 *
 * Created by dell on 2016/1/28.
 */
@SuppressWarnings("unused")
public class PageBean {
    public int totalPageNum;//总页数
    public int currentNum;//当前页
    public int showCount;//每页的个数
    public int totalNum;
    public int totalResult;//总记录数

    public PageBean() {
    }

    public PageBean(int totalPageNum, int currentNum, int showCount, int totalNum) {
        this.totalPageNum = totalPageNum;
        this.currentNum = currentNum;
        this.showCount = showCount;
        this.totalNum = totalNum;
    }

    /**
     * 获取起始记录数
     * @return
     */
//    public int getFirstPageNum(){
////        double d = totalResult/showCount;
////        Math.pow(d,1);
//        return ;
//    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getPageNum() {
        return showCount;
    }

    public void setPageNum(int showCount) {
        this.showCount = showCount;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
