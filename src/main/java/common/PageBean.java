package common;

/**
 * 分页
 * 起始页：（当前页-1*每页个数）+1
 * 结束页：（当前页*每页个数）
 * 总页数： 总记录数/每页的个数
 *
 * Created by dell on 2016/1/28.
 */
@SuppressWarnings("all")
public class PageBean {
    public int totalPageNum;//总页数
    public int currentNum;//当前页
    public int pageNum;//每页的个数
    public int totalNum;//总记录数

    public PageBean() {
    }

    public PageBean(int totalPageNum, int currentNum, int pageNum, int totalNum) {
        this.totalPageNum = totalPageNum;
        this.currentNum = currentNum;
        this.pageNum = pageNum;
        this.totalNum = totalNum;
    }

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
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
