package com.techelevator.naturalpark;

public class Weather {
	private String parkCode;
	private Integer day;
	private Integer lowTemp;
	private Integer highTemp;
	private String forecast;
	private String advisory;
	private String imgWeatherName;
	
	
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(Integer lowTemp) {
		this.lowTemp = lowTemp;
	}
	public Integer getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(Integer highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getAdvisory() {
		return advisory;
	}
	public void setAdvisory(String advisory) {
		this.advisory = advisory;
	}
	public String getImgWeatherName() {
		return imgWeatherName;
	}
	public void setImgWeatherName(String imgWeatherName) {
		this.imgWeatherName = imgWeatherName;
	}
	
	
	
}
