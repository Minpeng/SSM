package com.ssm.common.page;

import java.io.Serializable;
import java.util.ArrayList;

public class PageList<E> extends ArrayList<E> implements Serializable {
	private static final long serialVersionUID = -7317702765506896103L;

	private PageTurn pageTurn;

	public PageList() {
	}

	public PageList(int page, int pagesize, int rowscount) {
		this.pageTurn = new PageTurn( page, pagesize, rowscount );
	}

	public PageTurn getPageTurn() {
		return this.pageTurn;
	}

	public void setPageTurn( PageTurn pageTurn ) {
		this.pageTurn = pageTurn;
	}

	public String toString() {
		return "pageList:" + super.toString() + ",pageTurn:" + this.pageTurn;
	}

}
