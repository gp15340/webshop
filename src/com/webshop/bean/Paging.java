package com.webshop.bean;

public class Paging {
	public Page checkByPage(Long totalCount,Integer pageS) {
		Integer dpage = 1;
		if (pageS != null) {
			dpage = pageS;
		}
		Page page = new Page();
		page.setTotalcount(totalCount);
		page.setTotalpage();
		page.setDpage(dpage);
		return page;
	}
}
