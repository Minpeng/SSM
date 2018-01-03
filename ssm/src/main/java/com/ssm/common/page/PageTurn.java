package com.ssm.common.page;

import java.io.Serializable;

public class PageTurn implements Serializable {
	private static final long serialVersionUID = -3078109584161867959L;

	private Integer firstPage = new Integer( 0 );

	// 总页数
	private Integer pageCount = new Integer( 0 );

	// 当前页
	private Integer page = new Integer( 0 );

	// 下一页
	private Integer nextPage = new Integer( 0 );

	// 前一页
	private Integer prevPage = new Integer( 0 );

	// 起始行
	private Integer start = new Integer( 0 );

	// 结束行
	private Integer end = new Integer( 0 );

	// 每一页条数
	private Integer pageSize = new Integer( 0 );

	// 总记录条数
	private Integer rowCount = new Integer( 0 );

	public PageTurn() {
	}

	public PageTurn(int page, int pagesize) {
		initWithPage( page, pagesize, (page > 0 ? page : 1) * pagesize );
	}

	public PageTurn(int page, int pagesize, int rowscount) {
		initWithPage( page, pagesize, rowscount );
	}

	public void initWithPage( int page, int pagesize, int rowscount ) {
		initWithStart( (page - 1) * pagesize, pagesize, rowscount );
	}

	public void initWithStart( int startRow, int pagesize, int rowscount ) {
		if( (rowscount <= 0) || (pagesize <= 0) ) {
			return;
		}
		this.firstPage = new Integer( 1 );
		this.rowCount = new Integer( rowscount );

		this.pageSize = new Integer( pagesize );

		int startResult = startRow < 0 ? 0 : startRow;
		if( startResult > rowscount ) {
			startResult = rowscount - pagesize;
		}
		if( startResult < 0 ) {
			startResult = 0;
		}
		this.start = new Integer( startResult );

		this.pageCount = new Integer( (int)Math.ceil( rowscount / pagesize ) );

		int pageResult = startResult / pagesize + 1;
		if( pageResult > this.pageCount.intValue() ) {
			pageResult = this.pageCount.intValue();
		}
		this.page = new Integer( pageResult );

		int nextpageResult = pageResult + 1;
		nextpageResult = nextpageResult >= this.pageCount.intValue() ? this.pageCount.intValue() : nextpageResult;
		this.nextPage = new Integer( nextpageResult );

		int endResult = startResult + pagesize;
		endResult = endResult > rowscount ? rowscount : endResult;
		this.end = new Integer( endResult );

		this.prevPage = new Integer( pageResult > 1 ? pageResult - 1 : 1 );
	}

	public void setPage( Integer page ) {
		this.page = page;
	}

	public void setStart( Integer start ) {
		this.start = start;
	}

	public void setPageSize( Integer pageSize ) {
		this.pageSize = pageSize;
	}

	public void setRowCount( Integer rowCount ) {
		this.rowCount = rowCount;
	}

	public void setFirstPage( Integer firstPage ) {
		this.firstPage = firstPage;
	}

	public void setPageCount( Integer pageCount ) {
		this.pageCount = pageCount;
	}

	public void setNextPage( Integer nextPage ) {
		this.nextPage = nextPage;
	}

	public void setPrevPage( Integer prevPage ) {
		this.prevPage = prevPage;
	}

	public void setEnd( Integer end ) {
		this.end = end;
	}

	public Integer getFirstPage() {
		return this.firstPage;
	}

	public Integer getEnd() {
		return this.end;
	}

	public Integer getPage() {
		return this.page;
	}

	public Integer getCurrentPage() {
		return this.page;
	}

	public Integer getNextPage() {
		return this.nextPage;
	}

	public Integer getPageCount() {
		return this.pageCount;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public Integer getPrevPage() {
		return this.prevPage;
	}

	public Integer getRowCount() {
		return this.rowCount;
	}

	public Integer getStart() {
		return this.start;
	}

}