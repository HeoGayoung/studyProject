package com.myproject.study.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.study.model.Dust;
import com.myproject.study.service.ApiService;


@Controller
@RequestMapping("/api/")
public class ApiController {
	
	@Autowired
	private ApiService service;
	
	@RequestMapping("dust")
	public ModelAndView dustInfo(@RequestParam(value = "regionCode", required = false) String regionCode, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("dustInfo");
		List<Dust> regionList = service.getRegionListApi();
		model.addObject("regionList", regionList);
		List<Dust> dustInfoList = service.getRegionDustInfoApi(regionCode);
		model.addObject("dustInfoList", dustInfoList);
		model.addObject("regionCode", regionCode);
		return model;
	}

}
