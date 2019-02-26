package org.zerock.domain;

public class Criteria {
	public Criteria() {
	    this(1, 10);
	  }
	public Criteria(int pageNum, int amount) {
	    this.pageNum = pageNum;
	    this.amount = amount;
	}
	private int pageNum=1;
	private int amount=5;
	private String type,keyword;
	private String[] typeArr;
	 
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type==null?"":type.trim();
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword==null?"":type.trim();
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String[] getTypeArr() {
		return type==null?new String[]{}:type.split("");
	}
	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}
 }
