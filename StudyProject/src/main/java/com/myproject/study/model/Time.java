package com.myproject.study.model;

public class Time {
	
	private String timeinfo;
	private String seatinfo;
	private String reserveurl;
	
	
	public String getReserveurl() {
		return reserveurl;
	}
	public void setReserveurl(String reserveurl) {
		this.reserveurl = reserveurl;
	}
	public String getTimeinfo() {
		return timeinfo;
	}
	public void setTimeinfo(String timeinfo) {
		this.timeinfo = timeinfo;
	}
	public String getSeatinfo() {
		return seatinfo;
	}
	public void setSeatinfo(String seatinfo) {
		this.seatinfo = seatinfo;
	}
	@Override
	public String toString() {
		return "Time [timeinfo=" + timeinfo + ", seatinfo=" + seatinfo + ", reserveurl=" + reserveurl + "]";
	}

}
