package com.weather.model;

import java.util.List;

import lombok.Data;

@Data
public class WeatherVO2{
	private String name;
	private MainVO main;
	private Sys sys;
	private List<Weather> weather;
}


