package com.myproject.study.model;

public class Dust {
	
	// private String areaNm; // 권역명
	
	private String regionNm; // 구
	private String regionCode; // 구 코드
	
	private String msDt; // 측정일
	
	private String ultrafineDust; // 초미세먼지
	private String fineDust; // 미세먼지
	
	private String airGrade; // 통합대기환경등급
	private String airIndex; // 통합대기환경지수
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getMsDt() {
		return msDt;
	}
	public void setMsDt(String msDt) {
		this.msDt = msDt;
	}
	public String getUltrafineDust() {
		return ultrafineDust;
	}
	public void setUltrafineDust(String ultrafineDust) {
		this.ultrafineDust = ultrafineDust;
	}
	public String getFineDust() {
		return fineDust;
	}
	public void setFineDust(String fineDust) {
		this.fineDust = fineDust;
	}
	public String getAirGrade() {
		return airGrade;
	}
	public void setAirGrade(String airGrade) {
		this.airGrade = airGrade;
	}
	public String getAirIndex() {
		return airIndex;
	}
	public void setAirIndex(String airIndex) {
		this.airIndex = airIndex;
	}
	
		
}
