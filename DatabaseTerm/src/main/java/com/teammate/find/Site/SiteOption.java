package com.teammate.find.Site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteOption {
	private int eventPerPage;
	
	public SiteOption() {
		
	}
	
	public int getEventPerPage() {
		return eventPerPage;
	}
	
	
	public void setCountPerPage(int countPerPage) {
		countPerPage = countPerPage;
	}
	
	public void setEventPerPage(int eventPerPage) {
		this.eventPerPage = eventPerPage;
	}
	
	public SiteOption(int eventPerPage) {
		super();
		this.eventPerPage = eventPerPage;
	}
	
	public static void clearSearch(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", null);
	}
	
	public static void clearSearchDate(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("startDate", null);
		req.getSession().setAttribute("endDate", null);
	}
}
