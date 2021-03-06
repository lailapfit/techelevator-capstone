package com.techelevator.naturalpark;

public class Weather {
	private String parkCode;
	private String day;
	private Integer lowTemp;
	private Integer lowTempC;
	private Integer highTemp;
	private Integer highTempC;
	private String forecast;
	private String advisory;
	private String imgWeatherName;
	
	
	public Integer getLowTempC() {
		return lowTempC;
	}
	public void setLowTempC(Integer lowTempC) {
		this.lowTempC = lowTempC;
	}
	public Integer getHighTempC() {
		return highTempC;
	}
	public void setHighTempC(Integer highTempC) {
		this.highTempC = highTempC;
	}

	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
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
