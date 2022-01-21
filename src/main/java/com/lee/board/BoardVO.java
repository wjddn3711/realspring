package com.lee.board;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class BoardVO {
	private int bid;
	private String title;
	private String writer;
	private String content;
	private Date bdate;
	private String searchCondition;
	private String searchContent;

	private MultipartFile file;
	private String filepath;

	@Override
	public String toString() {
		return "BoardVO{" +
				"bid=" + bid +
				", title='" + title + '\'' +
				", writer='" + writer + '\'' +
				", content='" + content + '\'' +
				", bdate=" + bdate +
				", searchCondition='" + searchCondition + '\'' +
				", searchContent='" + searchContent + '\'' +
				", file=" + file +
				", filepath='" + filepath + '\'' +
				", cnt=" + cnt +
				'}';
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public String getSearchContent() {
		return searchContent;
	}

	private int cnt;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
