package com.kefang.autoditacte.utils.util;

import com.kefang.autoditacte.utils.CommonUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * 查询模型
 * @param <T>
 */
public class Querys<T> implements Serializable {

    /**  */
    private static final long serialVersionUID = -6794022780266465264L;

    /**
     * 是否分页 默认是
     */
    private boolean doPage = true;

    /**
     * 分页信息
     */
    private Paging paging;

    /**
     * 查询条件
     */
    private Object condition;
    /**
     * 查询结果
     */
    private List<T> results;

    /**
     * 扩展结果对象
     */
    private Object extResult;

    public Querys() {
        this.paging = new Paging();
    }

    public Querys(Paging paging) {
        this.paging = paging;
    }

    /**
     * 取消分页
     */
    public void cancelPage() {
        this.doPage = false;
        this.paging = null;
    }

    /**
     * 设置记录数
     *
     * @param total
     */
    public void setTotal(int total) {
        if (doPage && paging != null) {
            paging.setTotal(total);
        }
    }

    /**
     * 设置记录数
     *
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        if (doPage && paging != null) {
            paging.setCurrentPage(currentPage);
        }
    }

    public boolean isDoPage() {
        return doPage;
    }

    public void setDoPage(boolean doPage) {
        this.doPage = doPage;
    }

    /**
     * 设置分页
     * @param request
     */
    public void setPages(HttpServletRequest request) {
        String currentPageStr = request.getParameter("currentPage");
        String limitNumStr = request.getParameter("limitNum");
        if (CommonUtils.isNotBlank(currentPageStr)) {
            int currentPage = CommonUtils.parseInt(currentPageStr);
            paging.setCurrentPage(currentPage);
        }
        if (CommonUtils.isBlank(limitNumStr)) {
            paging.setLimitNum(15);
        } else {
            int limitNum = CommonUtils.parseInt(limitNumStr);
            paging.setLimitNum(limitNum);
        }

    }



    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public Object getExtResult() {
        return extResult;
    }

    public void setExtResult(Object extResult) {
        this.extResult = extResult;
    }

    @Override
    public String toString() {
        return "Querys [doPage=" + doPage + ", paging=" + paging + ", condition=" + condition
                + ", results=" + results + ", extResult=" + extResult + "]";
    }
}
