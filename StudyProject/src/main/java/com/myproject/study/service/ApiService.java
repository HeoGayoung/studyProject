package com.myproject.study.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.myproject.study.dao.ApiDao;
import com.myproject.study.model.Dust;


@Service
public class ApiService {
	
	@Value("#{configProperties.authentication_key}")
	private String key;
	
	// api로 미세먼지 정보 가져오기
	public List<Dust> getRegionDustInfoApi(String regionCode) {
		StringBuilder sb = new StringBuilder("http://openAPI.seoul.go.kr:8088/");
		sb.append(key);
		sb.append("/json");
		sb.append("/ListAirQualityByDistrictService");
		sb.append("/1/25/");
		if(regionCode != null) {
			sb.append(regionCode);
		}
		List<Dust> list = new ArrayList<Dust>();
		try {
			String result = requestApi(sb.toString());
			JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject().getAsJsonObject("ListAirQualityByDistrictService");
			JsonArray arr = jsonObject.getAsJsonArray("row");
			for (int i = 0; i < arr.size(); i++) {
				JsonObject object = (JsonObject) arr.get(i);
				Dust dust = new Dust();
				dust.setMsDt(object.get("MSRDATE").getAsString());
				dust.setRegionCode(object.get("MSRADMCODE").getAsString());
				dust.setRegionNm(object.get("MSRSTENAME").getAsString());
				dust.setAirGrade(object.get("GRADE").getAsString());
				dust.setAirIndex(object.get("MAXINDEX").getAsString());
				dust.setFineDust(object.get("PM10").getAsString());
				dust.setUltrafineDust(object.get("PM25").getAsString());
				list.add(dust);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	// api로 지역 정보 가져오기
	public List<Dust> getRegionListApi() {
		StringBuilder sb = new StringBuilder("http://openAPI.seoul.go.kr:8088/");
		sb.append(key);
		sb.append("/json");
		sb.append("/SearchMeasuringSTNOfAirQualityService");
		sb.append("/1/25/");
		List<Dust> list = new ArrayList<Dust>();
		try {
			String result = requestApi(sb.toString());
			JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject().getAsJsonObject("SearchMeasuringSTNOfAirQualityService");
			JsonArray arr = jsonObject.getAsJsonArray("row");
			for (int i = 0; i < arr.size(); i++) {
				JsonObject object = (JsonObject) arr.get(i);
				Dust dust = new Dust();
				dust.setRegionCode(object.get("MSRADM").getAsString());
				dust.setRegionNm(object.get("MSRSTE_NM").getAsString());
				list.add(dust);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// (공통) api 요청
	public String requestApi(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while((line = br.readLine()) != null) {
        	sb.append(line);
        }
        br.close();
        conn.disconnect();
        return sb.toString();
	}
	
	
}
