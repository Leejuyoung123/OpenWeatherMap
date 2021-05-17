package com.weather.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.weather.model.WeatherVO;
import com.weather.model.WeatherVO2;

@Mapper
public interface HomeMapper { 
	
	// public List<WeatherVO> gweatherList() throws Exception;
	
	public List<WeatherVO2> listWeather() throws Exception;
	
	public List<WeatherVO2> testRow() throws Exception;
	
	public int insertWeather(WeatherVO2 weatherVO) throws Exception;

}
