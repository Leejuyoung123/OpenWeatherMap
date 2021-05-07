package com.weather.controller;

import java.net.URLEncoder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.weather.model.SddVO;
import com.weather.model.WeatherVO;

@Controller
public class HomeController {

	private final String BASE_URL = "http://api.openweathermap.org/data/2.5/onecall";
	private final String apiKey = "382337faac5360f4627378b171bb335c"; // 諛쒓툒諛쏆� API key
	// private final String icon_URL = "http://openweathermap.org/img/w/";

	@RequestMapping("/restApi")
	public String weatherApi(Model model, @RequestParam("lat") String lat, @RequestParam("lon") String lon) {
		// System.out.println("lat:" + latparam + "lon : " + lonparam);
		// http://api.openweathermap.org/data/2.5/weather?lat=37.566386&lon=126.977948&appid=382337faac5360f4627378b171bb335c&lang=kr&units=metric
		// http://api.openweathermap.org/data/2.5/forecast?lat=37.4599695&lon=126.89448&appid=382337faac5360f4627378b171bb335c&units=metric%22;

		StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		WeatherVO weatherVO = null;
		
		try {
			// urlBuilder.append("?" + URLEncoder.encode("q", "UTF-8") + "= seoul");
			urlBuilder.append("?" + URLEncoder.encode("lat", "UTF-8") + "=" + lat);
			urlBuilder.append("&" + URLEncoder.encode("lon", "UTF-8") + "=" + lon);
			urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
			// urlBuilder.append("&" + URLEncoder.encode("lang", "UTF-8") + "=kr");
			urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");

			RestTemplate restTemplate = new RestTemplate();
			weatherVO = restTemplate.getForObject(urlBuilder.toString(), WeatherVO.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("weatherVO", weatherVO);
		return "weather";
	}
	@RequestMapping("/hourlyApi")
	public String hourlyApi(Model model, @RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		SddVO hourly = null;
		try {
			urlBuilder.append("?" + URLEncoder.encode("lat", "UTF-8") + "=" + lat);
			urlBuilder.append("&" + URLEncoder.encode("lon", "UTF-8") + "=" + lon);
			urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
			urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");

			RestTemplate restTemplate = new RestTemplate();
			hourly = restTemplate.getForObject(urlBuilder.toString(), SddVO.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("hourly", hourly);
		return "post";
	}
	
	
	
	
	
	

	/*
	 * @RequestMapping("/weather") public String getWeather(Model
	 * model,@RequestParam("lat") String lat , @RequestParam("lon") String lon ) {
	 * // Weather weather = new Weather(); // ,@RequestParam("37.5683")double
	 * lat,@RequestParam("126.9778")double lon // String icon = icon_URL +
	 * weather.getIcon() + ".png"; // StringBuilder iconBuilder = new
	 * StringBuilder(icon); StringBuilder urlBuilder = new StringBuilder(BASE_URL);
	 * //System.out.println("lat:" + latparam + "lon : " + lonparam); WeatherVO
	 * weatherVO =null; try { urlBuilder.append("?" + URLEncoder.encode("q",
	 * "UTF-8") + "=seoul"); urlBuilder.append("&" + URLEncoder.encode("lat",
	 * "UTF-8") + "=lat"); urlBuilder.append("&" + URLEncoder.encode("lon", "UTF-8")
	 * + "=lon"); urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "="
	 * + apiKey); urlBuilder.append("&" + URLEncoder.encode("lang", "UTF-8") +
	 * "=kr"); urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") +
	 * "=metric");
	 * 
	 * RestTemplate restTemplate = new RestTemplate(); weatherVO =
	 * restTemplate.getForObject(urlBuilder.toString(), WeatherVO.class);
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }
	 * 
	 * model.addAttribute("weatherVO",weatherVO); return "weather"; }
	 */
}
