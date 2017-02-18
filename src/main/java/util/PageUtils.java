package util;

import common.Constant;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * Created by Administrator on 2017/2/13 0013.
 */
public class PageUtils implements Serializable{

    private static final long serialVersionUID = 1L;
    // 总记录数
    private int totalCount;
    // 每页记录数
    private int pageSize = Constant.DEFAULT_PAGE_NUM;
    // 总页数
    private int totalPage;
    // 当前页数
    private int currPage;
    // 列表数据
    private List<?> list;
    // 查询参数
    private Map<String, Object> params;

    /**
     * 分页
     * @param pageSize
     * @param currPage
     */
    public PageUtils(Integer pageSize, Integer currPage) {
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
        this.currPage = currPage;
    }

    /**
     * 计算总页数
     */
    private void calculateTotalPage() {
        this.totalPage = (int) Math.ceil((double)totalCount / pageSize);
    }

    /**
     * 获取结束页
     * @return
     */
    public int getLimit() {
        return totalPage * pageSize;
    }

    /**
     * 获取起始页
     * @return
     */
    public int getOffset() {
        return (totalPage - 1) * pageSize + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
        calculateTotalPage();
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", currPage=" + currPage +
                ", list=" + list +
                '}';
    }
}
