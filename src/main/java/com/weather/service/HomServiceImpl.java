package com.weather.service;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.mapper.HomeMapper;
import com.weather.model.SddVO;
import com.weather.model.WeatherVO;
import com.weather.model.WeatherVO2;

@Service
public class HomServiceImpl implements HomeService {
	
	public static final String URL_WEATHER = "weather";
	public static final String URL_CALL = "onecall";
	private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
	private final String apiKey = "382337faac5360f4627378b171bb335c"; // 諛쒓툒諛쏆� API key
	// private final String icon_URL = "http://openweathermap.org/img/w/";
	

	@Autowired
	private HomeMapper homeMapper;
	/**
	@Override
	public List<WeatherVO> gweatherList() throws Exception {
		return homeMapper.gweatherList();
	}
	*/
	@Override
	public int insertWeather(WeatherVO2 weatherVO) throws Exception {
		return homeMapper.insertWeather(weatherVO);
	}

	@Override
	public WeatherVO2 getUrlweather(String lat, String lon) {
		WeatherVO weatherVO = new WeatherVO();
		Map<String, Object> respData = null;
		StringBuilder urlBuilder = new StringBuilder(BASE_URL + URL_WEATHER);
		WeatherVO2 weatherVO2 = null;
		
		try {
			urlBuilder.append("?" + URLEncoder.encode("lat", "UTF-8") + "=" + lat);
			urlBuilder.append("&" + URLEncoder.encode("lon", "UTF-8") + "=" + lon);
			urlBuilder.append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + apiKey);
			urlBuilder.append("&" + URLEncoder.encode("units", "UTF-8") + "=metric");
				
			RestTemplate restTemplate = new RestTemplate();
			
			weatherVO2 = restTemplate.getForObject(urlBuilder.toString(), WeatherVO2.class);
			
			insertWeather(weatherVO2);
			
		//	List<WeatherVO> weatherVOList =  gweatherList();
		//	List<WeatherVO2> weatherList = listWeather();
			
			System.out.println("");
			
			/*
			respData = restTemplate.getForObject(urlBuilder.toString(), Map.class);
			
			//weather
			Map<String,Object> weather = (Map<String,Object>)((List<Object>)respData.get("weather")).get(0);
			weatherVO.setDescription((String)weather.get("description"));
			weatherVO.setIcon((String)weather.get("icon"));
			
			//main
			Map<String,Object> main = (Map<String,Object>)respData.get("main");
			weatherVO.setTemp((Double)main.get("temp"));
			weatherVO.setTempMin((Double)main.get("temp_min"));
			weatherVO.setTempMax((Double)main.get("temp_max"));
			weatherVO.setHumidity((Double)main.get("humidity"));
			
			//sys
			Map<String,Object> sys = (Map<String,Object>)respData.get("sys");
			weatherVO.setCountry((String)sys.get("country"));
			
			//name
			weatherVO.setName((String)respData.get("name"));
			
			//DB INSERT
			homeService.insertWeather(weatherVO);
			*/
			
			//weatherVO= homeService.gweatherList(weatherVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return weatherVO2;
	}


	/*
	 * @Override public List<WeatherVO2> listWeather() throws Exception {
	 * 
	 * return homeMapper.listWeather(); }
	 */


	@Override
	public List<WeatherVO2> testRow() throws Exception {
		// TODO Auto-generated method stub
		return homeMapper.testRow();
	}


	

}
