package com.myproject.study.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.myproject.study.model.Movie;
import com.myproject.study.model.TheaterCondition;
import com.myproject.study.service.CrawlingService;

@Controller
@RequestMapping("/crawling/")
public class CrawlingController {
	
	@Autowired
	private CrawlingService service;
	
	@RequestMapping("cgv")
	public ModelAndView cgvCrawlingInfo(@RequestParam Map<String, String> parameters, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("cgvCrawling");
		List<String> movieList = service.getMovieList();
		model.addObject("movieList", movieList);
		try {
			model.addObject("theaterList", service.getTheaterList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addObject("theater_code", parameters.get("theater_code"));
		model.addObject("movie_name", parameters.get("movie_name"));
		TheaterCondition tc = new TheaterCondition();
		tc.setMovie_name(parameters.get("movie_name"));
		tc.setTheater_code(parameters.get("theater_code"));
		Movie movie = service.cgvCrawling(tc);
		if(movie != null) {
			model.addObject("movie", movie);
			System.out.println(movie);
		}
		return model;
	}
	
}
