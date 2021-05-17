package com.weather.model;
  
  import lombok.Data;
  
  @Data public class MainVO {
  
 /** 온도. 단위 기본값 : 켈빈, 미터법 : 섭씨, 임페리얼 : 화씨 */

 private double temp;
  
 /** 현재 최저 온도.(대규모 대도시 및 도시 지역 내) */

 private double temp_min;
  
 /** 현재 최대 온도.(대규모 대도시 및 도시 지역 내) */

 private double temp_max;
  

 private double humidity;
  
  }
						 