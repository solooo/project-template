package net.solooo.template.base.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import net.solooo.template.base.exception.WebException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装的分页对象
 * @author Jeff
 */
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;
    
    private PageResult(){}
    
    public PageResult(List<T> list){
    	if(!(list instanceof Page)){
    		throw new WebException("请在使用分页对象前调用PageHelper.startPage(pageNum, pageSize);");
    	}
    	PageInfo<T> pageinfo = new PageInfo<T>(list);
    	
    	pageNum = pageinfo.getPageNum();
    	pageSize = pageinfo.getPageSize();
    	size = pageinfo.getSize();
    	total = pageinfo.getTotal();
    	pages = pageinfo.getPages();
    	this.list = pageinfo.getList();
    }
    
    /**
     * 如果PagteInfo信息为null， 则采用这个返回分页数据
     * @param cla	指定对象
     * @param pageNum	页码
     * @param pageSize 也大小
     * @return PageResult
     */
    public static <T> PageResult<T> isNull(Class<T> cla, int pageNum, int pageSize){
    	PageResult<T> result = new PageResult<T>();
    	result.setList(new ArrayList<T>());
    	result.setPageNum(pageNum);
    	result.setPageSize(pageSize);
    	return result;
    }
    
    /**
     * 根据数据创建一个PageResult对象
     * @param list	集合数据
     * @param total	总记录数
     * @param pages	总页数
     * @param pageNum	页码
     * @param pageSize	页数量
     * @return PageResult
     */
    public static <T> PageResult<T> createPage(List<T> list, long total, int pages, int pageNum, int pageSize){
    	PageResult<T> result = new PageResult<T>();
    	result.setList(list);
    	result.setTotal(total);
    	result.setPages(pages);
    	result.setPageNum(pageNum);
    	result.setPageSize(pageSize);
    	return result;
    }

	public int getPageNum() {
		return pageNum;
	}

	private void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	private void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	private void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	private void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	private void setList(List<T> list) {
		this.list = list;
	}

}
