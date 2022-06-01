package com.teammate.find.Site.Event;

import java.util.Date;

public class Event {
	private String title;
	private String content;
	private Date reportDate;
	private String thumbnail;
	private String link;
	
	public Event(String title, String content, Date reportDate, String thumbnail, String link) {
		this.title = title;
		this.content = content;
		this.reportDate = reportDate;
		this.thumbnail = thumbnail;
		this.link = link;
	}
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public String getLink() {
		return link;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
