package com.teammate.find.Project;

import java.math.BigDecimal;

public class ProjectSelector {
	private String search;
	private BigDecimal start;
	private BigDecimal end;
	
	public ProjectSelector() {
		
	}
	
	public ProjectSelector(String search, BigDecimal start, BigDecimal end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
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
	
	
	public void setSearch(String search) {
		this.search = search;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
}
