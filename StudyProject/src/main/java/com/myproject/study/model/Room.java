package com.myproject.study.model;

import java.util.List;

public class Room {
	
	private String room_type;
	private String room_name;
	private String room_qty;
	private List<Time> timelist;
	
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_qty() {
		return room_qty;
	}
	public void setRoom_qty(String room_qty) {
		this.room_qty = room_qty;
	}
	public List<Time> getTimelist() {
		return timelist;
	}
	public void setTimelist(List<Time> timelist) {
		this.timelist = timelist;
	}
	@Override
	public String toString() {
		return "Room [room_type=" + room_type + ", room_name=" + room_name + ", room_qty=" + room_qty + ", timelist="
				+ timelist + "]";
	}
	
	
	

	

}
