package com.sf.framework.domain;

/**
 * 页面请求类，需分页的查询请求对象都需继承此类
 * @author 696248
 *
 */
abstract public class PageBounds {

	private int currentPage = 1; // 当前页
	private int pageSize = 20; //每页显示记录数
	private int startRecord = 1; //起始查询记录
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getStartRecord() {
		startRecord = (getCurrentPage() - 1) * pageSize;
		return startRecord;
	}
	
}
