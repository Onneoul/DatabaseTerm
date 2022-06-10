package com.teammate.find.Event;

import java.math.BigDecimal;

public class Event {
	private BigDecimal code;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String link;
	
	public Event() {
		
	}
	
	public Event(BigDecimal code, String title, String content, String startDate, String endDate, String link) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.link = link;
	}

	public BigDecimal getCode() {
		return code;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getstartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getLink() {
		return link;
	}
	
	public void setCode(BigDecimal code) {
		this.code = code;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
