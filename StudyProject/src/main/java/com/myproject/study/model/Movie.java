package com.myproject.study.model;

import java.util.List;

public class Movie {
	
	private String movie_name;
	private String openinfo;
	private List<Room> roomlist;
	
	
	
	
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getOpeninfo() {
		return openinfo;
	}
	public void setOpeninfo(String openinfo) {
		this.openinfo = openinfo;
	}
	public List<Room> getRoomlist() {
		return roomlist;
	}
	public void setRoomlist(List<Room> roomlist) {
		this.roomlist = roomlist;
	}
	@Override
	public String toString() {
		return "Movie [movie_name=" + movie_name + ", openinfo=" + openinfo + ", roomlist=" + roomlist + "]";
	}
	
	
	
	
	
	
	

}
