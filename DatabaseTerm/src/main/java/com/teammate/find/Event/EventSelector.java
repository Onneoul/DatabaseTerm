package com.teammate.find.Event;

import java.math.BigDecimal;

public class EventSelector {
	private String search;
	private BigDecimal start;
	private BigDecimal end;
	private String startDate;
	private String endDate;
	
	public EventSelector() {
		
	}
	
	public EventSelector(String search, BigDecimal start, BigDecimal end, String startDate, String endDate) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getSearch() {
		return search;
	}
	public BigDecimal getStart() {
		return start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
