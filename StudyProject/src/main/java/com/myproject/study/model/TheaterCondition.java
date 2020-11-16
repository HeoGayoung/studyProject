package com.myproject.study.model;

import java.util.Date;

public class TheaterCondition {
	
	private int num;
	private String condition_name;
	private String id;
	private String movie_name;
	private String region_code;
	private String region_name;
	private String theater_code;
	private String theater_name;
	private String room;
	private Date target_date;
	private Date reg_date;
	
	
	
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getTheater_name() {
		return theater_name;
	}
	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}
	public String getCondition_name() {
		return condition_name;
	}
	public void setCondition_name(String condition_name) {
		this.condition_name = condition_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	public String getTheater_code() {
		return theater_code;
	}
	public void setTheater_code(String theater_code) {
		this.theater_code = theater_code;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Date getTarget_date() {
		return target_date;
	}
	public void setTarget_date(Date target_date) {
		this.target_date = target_date;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "TheaterCondition [num=" + num + ", condition_name=" + condition_name + ", id=" + id + ", movie_name="
				+ movie_name + ", region_code=" + region_code + ", region_name=" + region_name + ", theater_code="
				+ theater_code + ", theater_name=" + theater_name + ", room=" + room + ", target_date=" + target_date
				+ ", reg_date=" + reg_date + "]";
	}
	
	
	
	

}
