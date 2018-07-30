package com.webshop.bean;

public class Page {
	private Long totalcount;//总条数
	private Integer pagecount=3;//每页显示的条数
	private Long totalpage;//总页数
	private Integer dpage;//当前显示的页码
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}
	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
	public Long getTotalpage() {
		return totalpage;
	}
	public void setTotalpage() {
		if(totalcount%pagecount==0) {
			this.totalpage=totalcount/pagecount;
		}else {
			this.totalpage=totalcount/pagecount+1;
		}
	}
	public Integer getDpage() {
		return dpage;
	}
	public void setDpage(Integer dpage) {
		this.dpage = dpage;
	}
	
}
