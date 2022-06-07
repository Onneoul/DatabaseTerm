package com.teammate.find.Project;

import java.util.Date;

public class Feedback {

	public class FeedBack {
		private int projectCode;
		private int FeedBackCode;
		private int writer;
		private String content;
		private Date date;
		
		public FeedBack() {
			
		}
		
		public FeedBack(int projectCode, int FeedBackCode, int writer, String content, Date date) {
			super();
			this.projectCode = projectCode;
			this.FeedBackCode = FeedBackCode;
			this.writer = writer;
			this.content = content;
			this.date = date;
		}
		
		public int getProjectCode() {
			return projectCode;
		}
		public int getWriter() {
			return writer;
		}
		public String getContent() {
			return content;
		}
		public Date getDate() {
			return date;
		}
		public int getFeedBackCode() {
			return FeedBackCode;
		}
		
		
		public void setProjectCode(int projectCode) {
			this.projectCode = projectCode;
		}
		public void setWriter(int writer) {
			this.writer = writer;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public void setFeedBackCode(int FeedBackCode) {
			this.FeedBackCode = FeedBackCode;
		}
	}

}
