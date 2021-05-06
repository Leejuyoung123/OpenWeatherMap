package com.weather.controller;

import java.net.URLEncoder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.weather.model.WeatherVO;



@Controller
@ComponentScan
public class HomeController {
	
	private final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
	private final String apiKey = "382337faac5360f4627378b171bb335c";  // 諛쒓툒諛쏆� API key
	@GetMapping("weather")
    @RequestMapping("weather")
	public String weatherApi(Model model,@ModelAttribute("weatherVO")WeatherVO weatherVO) throws Exception {
		
		 StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		try {	
				urlBuilder.append("?" + URLEncoder.encode("q", "UTF-8") + "=seoul");
			    urlBuilder.append("&" + URLEncoder.encode("lat", "UTF-8") + "=lat");
			    urlBuilder.append("&" + URLEncoder.encode("lon", "UTF-8") + "=lon");
			    urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
			    urlBuilder.append("&" + URLEncoder.encode("lang", "UTF-8") + "=lang");
			    urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");
	
			    RestTemplate restTemplate = new RestTemplate();
			    weatherVO = restTemplate.getForObject(urlBuilder.toString(), WeatherVO.class);
			 
			} 	catch (Exception e) {
		  		e.printStackTrace();
		  	}

			model.addAttribute("weatherVO",weatherVO);
			return "weather";
	}
}
