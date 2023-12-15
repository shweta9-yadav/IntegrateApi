package com.example.demo.ServiceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	    @Value("${weather.api.key}")
	    private String apiKey;
	    
	    @Value("${weather.api.host}")
	    private String apiHost;


	

	@Override
	public Map<String, Object> getWeatherSummary(String locationName,String data) {
		ResponseEntity<Map<String, Object>> response = null;
		try {
			String apiUrl =null;
		if(data.toLowerCase().equals("summary")) {
			 apiUrl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + locationName + "/summary/";
			}
			else if (data.toLowerCase().equals("hourly")) {
				apiUrl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + locationName + "/hourly/";
			}

	        RestTemplate restTemplate = new RestTemplate();

	        // Set headers
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-RapidAPI-Key", apiKey);
	        headers.set("X-RapidAPI-Host", apiHost);
	        headers.set("Content-Type", "application/json");
	        headers.set("Access-Control-Allow-Credentials", "true");
	        headers.set("Access-Control-Allow-Headers", "*");
	        headers.set("Access-Control-Allow-Origin", "*"); 
	        // Make the request
	        HttpEntity<String> entity = new HttpEntity<>(headers);
	        response = restTemplate.exchange(
	                apiUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>() {});

	        return response.getBody();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return response.getBody();

	}


}
