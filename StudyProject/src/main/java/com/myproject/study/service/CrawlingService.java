package com.myproject.study.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.myproject.study.model.Movie;
import com.myproject.study.model.Room;
import com.myproject.study.model.TheaterCondition;
import com.myproject.study.model.Time;

@Service
public class CrawlingService {
	
	// 상영중인 영화 리스트 크롤링
	public List<String> getMovieList() {
		String url = "http://www.cgv.co.kr/reserve/show-times/movies.aspx";
		Document doc = null;
		try {
			doc = crawling(url);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Elements elements = doc.select("div#movie_list").select("li");
		List<String> movieList = new ArrayList<String>();
		for(int i=0; i<elements.size() ; i++) {
			movieList.add(elements.get(i).select("strong").text());
		}
		return movieList;
	}
	// 전국 cgv 상영관 정보 txt 파일 가져오기
	public List<TheaterCondition> getTheaterList() throws IOException {
		ClassPathResource re = new ClassPathResource("theaterlist.txt");
		Path path = Paths.get(re.getURI());
		List<TheaterCondition> theaterList = new ArrayList<TheaterCondition>();
		for(String str : Files.readAllLines(path)) {
			TheaterCondition tc = new TheaterCondition();
			tc.setTheater_code(str.split(",")[0]);
			tc.setTheater_name(str.split(",")[1]);
			theaterList.add(tc);
		}
		return theaterList;
	}
	// 선택한 조건으로 상영시간 정보 크롤링
	public Movie cgvCrawling(TheaterCondition condition) {
		Movie movie = null;
		// URL 만들어주기
		String url = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?theatercode=";
		url += condition.getTheater_code();
		
		// URL 로 크롤링해오기
		Document doc = crawling(url);
		Elements elements = doc.select("div.col-times");
		List<Element> elList = new ArrayList<Element>();
		for(int i = 0 ; i<elements.size() ; i++) {
			elList.add(elements.get(i));
		}
		movie = movieCheck(elList, condition.getMovie_name());
		return movie;
	}
	
	// (공통) 크롤링
	private Document crawling(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
	// 선택한 영화 상영시간표만 추출
	private Movie movieCheck(List<Element> elList, String movieNameValue) {
		for(int i=0 ; i<elList.size();i++) {
			Element el = elList.get(i);
			String movie_name = el.select("div.info-movie").select("a").text();
			if(movie_name.equals(movieNameValue)) {
				Movie movie = new Movie();
				Elements roomsEl = el.select("div.type-hall");
				List<Room> roomlist = roomCheck(roomsEl);
				if(roomlist.size() !=0 ) {
					movie.setRoomlist(roomlist);
					movie.setMovie_name(movie_name);
					movie.setOpeninfo(el.select("div.info-movie").select("em").text());
					return movie;
				}
			}
		}
		return null;
	}
	
	private List<Room> roomCheck(Elements roomsEl){
		List<Room> roomList= new ArrayList<Room>();
		Room room = new Room();
		for(int i=0 ; i<roomsEl.size();i++) {
			Elements roomEl = roomsEl.get(i).select("div.type-hall");
			room = makeRoom(roomEl);
			roomList.add(room);
		}
		return roomList;
	}
	// 2d, 3d, 4d등의 특성으로 담기
	private Room makeRoom(Elements roomEl) {
		Room room = new Room();
		room.setRoom_type(roomEl.select("div.info-hall").select("li").get(0).text());
		room.setRoom_name(roomEl.select("div.info-hall").select("li").get(1).text());
		room.setRoom_qty(roomEl.select("div.info-hall").select("li").get(2).text());
		Elements timeEl = roomEl.select("div.info-timetable").select("li");
		room.setTimelist(makeTimeList(timeEl));
		return room;
	}
	// 시간표 정보 담기
	private List<Time> makeTimeList(Elements timeEl){
		List<Time> timeList = new ArrayList<Time>();
		int index = 0;
		for(int i=0 ; i<timeEl.size();i++) {
			Time time = new Time();
			String seatinfo = timeEl.select("span").get(i).text();
			if(seatinfo.equals("매진") || seatinfo.equals("마감")) {
				time.setTimeinfo(timeEl.select("em").get(i).text());
				time.setSeatinfo(seatinfo);
			} else {
				time.setTimeinfo(timeEl.select("em").get(i).text());
				time.setReserveurl(timeEl.select("a").get(index).attr("href"));
				time.setSeatinfo(timeEl.select("span.txt-lightblue").get(index).text());
				index++;
			}
			timeList.add(time);
		}
		return timeList;
	}
}
