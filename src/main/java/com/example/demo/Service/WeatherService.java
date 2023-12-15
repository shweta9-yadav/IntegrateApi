package com.example.demo.Service;

import java.util.Map;

import com.example.demo.Model.WeatherModel;

public interface WeatherService {

	public Map<String, Object> getWeatherSummary(String locationName,String data);


}
