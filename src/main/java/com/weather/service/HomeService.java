package com.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weather.model.SddVO;
import com.weather.model.WeatherVO;
import com.weather.model.WeatherVO2;

@Service
public interface HomeService {    
	// public List<WeatherVO> gweatherList() throws Exception;
	
	// public List<WeatherVO2> listWeather() throws Exception;
	
	public List<WeatherVO2> testRow() throws Exception;
	
	public int insertWeather(WeatherVO2 weatherVO) throws Exception;

	public WeatherVO2 getUrlweather(String lat, String lon);
	
	// 재수정
}
