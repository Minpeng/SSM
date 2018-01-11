package com.ssm.common.util;

import java.util.HashMap;
import java.util.Map;

import com.ssm.common.page.PageList;
import com.ssm.common.page.PageTurn;

public class PageUtil {

	public static <T> Map<String, Object> getPageList( PageList<?> pageList ) {
		Map<String, Object> result = new HashMap<String, Object>();

		if( pageList.isEmpty() ) {
			return result;
		}

		PageTurn pageTurn = pageList.getPageTurn();

		int totalCount = pageTurn.getRowCount();
		int page = pageTurn.getCurrentPage();

		int totalPages = pageTurn.getPageCount();
		int nextPage = pageTurn.getNextPage();

		int limit = pageTurn.getPageSize();
		int offset = pageTurn.getStart();

		int prePage = pageTurn.getPrevPage();

		boolean firstPage = page == 1 ? true : false;

		boolean lastPage = nextPage >= totalPages ? true : false;

		boolean hasNextPage = !lastPage;
		boolean hasPrePage = !firstPage;
		Object items = pageList;

		int[] slider = new int[totalPages];
		for( int i = 0; i < totalPages; i++ ) {
			slider[i] = i + 1;
		}

		int startRow = offset + 1;
		int endRow = startRow + limit >= totalCount ? totalCount : offset + limit;

		result.put( "endRow", endRow );
		result.put( "firstPage", firstPage );
		result.put( "hasNextPage", hasNextPage );
		result.put( "hasPrePage", hasPrePage );
		result.put( "items", items );
		result.put( "lastPage", lastPage );
		result.put( "limit", limit );
		result.put( "nextPage", nextPage );
		result.put( "offset", offset );
		result.put( "page", page );
		result.put( "prePage", prePage );
		result.put( "slider", slider );
		result.put( "startRow", startRow );
		result.put( "totalCount", totalCount );
		result.put( "totalPages", totalPages );
		return result;
	}
}
