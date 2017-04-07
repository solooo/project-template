package net.solooo.template.base.page;

/**
 * 分页对象
 * @author Jeff
 */
public class Page {

	//当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    
    public Page(int pageNum, int pageSize){
    	this.pageNum = pageNum;
    	this.pageSize = pageSize;
    }
    
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
