package com.bit.sts09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.bit.sts09.model.entity.DeptVo;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("index");
		
		RestTemplate template=new RestTemplate();
//		String url="http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
		String url="http://localhost:8080/sts09/dept/";
		ResponseEntity<String> entity = template.getForEntity(url, String.class);
		String json = entity.getBody();
		model.addAttribute("json", json);
		System.out.println(json);
		return "home";
	}
	
}










