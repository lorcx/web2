package common;

/**
 * 分页
 * 起始页：（当前页-1*每页个数）+1
 * 结束页：（当前页*每页个数）
 * 总页数： 总记录数/每页的个数
 * <p/>
 * Created by dell on 2016/1/28.
 */
public class PageBean {
    private int totalPageNum;//总页数
    private int currentNum;//当前页
    private int showCount;//每页的个数
    private int totalNum;//总记录数

    public PageBean() {
        showCount = Constant.DEFAULT_PAGE_NUM;//默认5
        currentNum = 1;
    }

    public PageBean(int totalPageNum, int currentNum, int showCount, int totalNum) {
        this.totalPageNum = totalPageNum;
        this.currentNum = currentNum;
        this.showCount = showCount;
        this.totalNum = totalNum;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public int getTotalPageNum() {
        if(totalNum > 0){
            int n = (int) Math.ceil(totalNum / showCount);
            return n == 0 ? 1 : n;
        }
        return 1;
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
