package com.weather.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class SddVO {
	/** 요청된 위치의 시간대 이름 */
	private String timezone;
	
	/** 요청된 위치의 시간대 이름 */
	private Current current;
	
	/** (분) 예보 날씨 데이터 API 응답 */
	private List<Minutely> minutely;
	
	/** 시간별 예보 날씨 데이터 API 응답 */
	private List<Hourly> hourly;
	
	/** 일일 예보 날씨 데이터 API 응답 */
	private List<Daily> daily;
	
	private LocalDateTime date = LocalDateTime.now(); 
	
	

	
@Data
public class Current {
	/** 현재시간 Unix, UTC */
	private long dt;

	/** 일출시간 Unix, UTC */
	private long sunrise;
	
	/** 일몰시간 Unix, UTC */
	private long sunset;
	
	/** 온도  */
	private double temp;
	
	private double temp_max;
	
	private double temp_min;
	
	/** 온도  */
	private double feels_like;
	
	/** 습도  % */
	private double humidity;
	
	/** 흐림 % */
	private int clouds;
	
	/** 날씨  */
	private List<Weather> weather;
	@Data
	public class Weather{
		/** 날씨 상태 ID */
		private int id;
		
		/** 날씨 날씨 매개 변수 그룹 (비, 눈, 극한 등) 그룹 */
		private String main;
		
		/** 그룹 내 날씨 상태 ( 기상 상태의 전체 목록 ) */
		private String description;
		
		/** 날씨 아이콘 ID. */
		private String icon;
	}
}
@Data
public class Minutely{
	
	/** 예측 데이터 시간, unix, UTC */
	private long dt;
	
	/** 강수량, mm */
	/* private long precipitation; */
}

@Data
public class Hourly{
	
	/** 예측 데이터 시간, Unix, UTC */
	private long dt;
	
	private double temp;
	/** 온도. 단위 – 기본값 : 켈빈, 미터법 : 섭씨, 영국식 : 화씨 */
	
	/** 온도. 단위 – 기본값 : 켈빈, 미터법 : 섭씨, 영국식 : 화씨 */
	private double feels_like;
	
	/** 습도 % */
	private double humidity;
	
	
	/** 일출시간 Unix, UTC */
	private List<Weather> weather;
	
	private LocalDateTime date = LocalDateTime.now(); 
	/** 강수 확률 */
	private double pop;
	

	@Data
	public class Weather{
		
	private int id;
	private String main;
	private String description;
	private String icon;
}
}
@Data
public class Daily{
	
	private long dt;
	private long sunrise;
	private long sunset;
	private Temp temp;
	private double humdity;
	
	private List<Weather> weather;
	private int clouds;
	
	
	
	/** 강수 확률 */
	private double pop;

	@Data	
	public class Temp{
		/*
		 daily.temp.morn 아침 온도. 
		 daily.temp.day 낮 온도. 
		 daily.temp.eve 저녁 온도.
		 daily.temp.night 밤 온도.
		 daily.temp.min 최소 일일 온도. 
		 daily.temp.max 최대 일일 온도.
		 							*/		
		private double morn;
		private double day;
		private double eve;
		private double night;
		private double min;
		private double max;
		
	}
	@Data
	public class Weather{
		private int id;
		private String main;
		private String description;
		private String icon;
	}	
}
}


	
	 
