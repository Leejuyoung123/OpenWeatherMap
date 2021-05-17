package com.weather.model;

import lombok.Data;

@Data
public class WeatherVO{

	private String name;
	private double temp;
	private double tempMin;
	private double tempMax;
	private double humidity;
	private String country;
	private String description;
	private String icon;
}