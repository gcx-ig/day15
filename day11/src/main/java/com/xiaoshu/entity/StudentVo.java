package com.xiaoshu.entity;

import java.util.Date;

import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentVo extends Student{

	private String cname;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entrytime1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entrytime2;
	private Integer num;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Date getEntrytime1() {
		return entrytime1;
	}
	public void setEntrytime1(Date entrytime1) {
		this.entrytime1 = entrytime1;
	}
	public Date getEntrytime2() {
		return entrytime2;
	}
	public void setEntrytime2(Date entrytime2) {
		this.entrytime2 = entrytime2;
	}
	@Override
	public String toString() {
		return "StudentVo [cname=" + cname + ", entrytime1=" + entrytime1 + ", entrytime2=" + entrytime2 + ", num="
				+ num + "]";
	}
	
	
}
