package com.weather.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import lombok.Data;


@Data
@ComponentScan
public class WeatherVO {
	  private List<Weather> weather;
	  
	  private final LocalDateTime date;
	  /** �궡遺� 留ㅺ컻 蹂��닔 */
	  private String base;

	  private Main main;

	  private Wind wind;

	  private Clouds clouds;

	  private Rain rain;

	  private Snow snow;
	  
	  private Sys sys;
	  
	  private Dt_txt dt_txt;
	  /** 媛��떆�꽦 */
	  private int visibility;

	  /** �뜲�씠�꽣 怨꾩궛 �떆媛�, �쑀�땳�뒪, UTC */
	  private long dt;
	  


	  /** UTC�뿉�꽌 珥� �떒�쐞濡� �씠�룞 */
	  private int timezone;

	  /** �룄�떆 ID */
	  private long id;

	  /** �룄�떆 �씠由� */
	  private String name;

	  /** �궡遺� 留ㅺ컻 蹂��닔 */
	  private int cod;

	  @Data
	  public static class Weather {

	    /** 湲곗긽 議곌굔 ID */
	    private int id;

	    /** �궇�뵪 留ㅺ컻 蹂��닔 洹몃９ (鍮�, �늿, 洹뱁븳 �벑) */
	    private String main;

	    /** 洹몃９ �궡 �궇�뵪 議곌굔 */
	    private String description;

	    /** �궇�뵪 �븘�씠肄� ID */
	    private String icon;
	    
		private LocalDate date = LocalDate.now(); 
		
	  }

	  @Data
	  public static class Main {

	    /** �삩�룄. �떒�쐞 湲곕낯媛� : 耳덈퉰, 誘명꽣踰� : �꽠�뵪, �엫�럹由ъ뼹 : �솕�뵪 */
	    private float temp;

	    /** �삩�룄. �떒�쐞 湲곕낯媛� : 耳덈퉰, 誘명꽣踰� : �꽠�뵪, �엫�럹由ъ뼹 : �솕�뵪 */
	    private float feels_like;

	    /** �쁽�옱 理쒖� �삩�룄.(��洹쒕え ���룄�떆 諛� �룄�떆 吏��뿭 �궡) */
	    private float temp_min;

	    /** �쁽�옱 理쒕� �삩�룄.(��洹쒕え ���룄�떆 諛� �룄�떆 吏��뿭 �궡)*/
	    private float temp_max;

	    /** ��湲곗븬 (�빐�닔硫�, �빐�닔硫� �삉�뒗 grnd_level �뜲�씠�꽣媛� �뾾�뒗 寃쎌슦), hPa */
	    private int pressure;

	    /** �뒿�룄, % */
	    private float humidity;

	    /** �빐�닔硫댁쓽 ��湲곗븬, hPa */
	    private float sea_level;

	    /** 吏�硫댁뿉�꽌�쓽 ��湲곗븬, hPa */
	    private float grnd_level;
	  } 

	  @Data
	  public static class Wind {

	    /** 諛붾엺�쓽 �냽�룄. �떒�쐞 湲곕낯媛� : meter/sec, 誘명꽣踰� : meter/sec, �엫�럹由ъ뼹 : miles/hour */
	    private float speed;

	    /** �뭾�뼢,�룄 (湲곗긽) */
	    private int deg;

	    /**  諛붾엺 �룎�뭾. �떒�쐞 湲곕낯媛� : meter/sec, 誘명꽣踰� : meter/sec, �엫�럹由ъ뼹 : miles/hour */
	    private float gust;
	  }

	  @Data
	  public static class Clouds {

	    /** �쓲由�, % */
	    private int all;
	  }

	  @Data
	  public static class Rain {

	    /** 吏��궃 1 �떆媛� �룞�븞�쓽 媛뺤슦�웾, mm */
	    private float rain1h;

	    /** 吏��궃 3 �떆媛� �룞�븞�쓽 媛뺤슦�웾, mm */
	    private float rain3h;
	  }

	  @Data
	  public static class Snow {

	    /** 吏��궃 1 �떆媛� �룞�븞�쓽 �늿�웾, mm */
	    private float snow1h;

	    /** 吏��궃 3 �떆媛� �룞�븞�쓽 �늿�웾, mm */
	    private float snow3h;
	  }

	  @Data
	  public static class Sys {

	    private int type;

	    private int id;

	    /** 援�媛� 肄붾뱶 (GB, JP �벑) */
	    private String country;

	    /** �씪異� �떆媛�, �쑀�땳�뒪, UTC */
	    private long sunrise;

	    /** �씪紐� �떆媛�, �쑀�땳�뒪, UTC */
	    private long sunset;
	  }
	  @Data
	  public static class Dt_txt {
		  private Date dt_txt;
	  }

}