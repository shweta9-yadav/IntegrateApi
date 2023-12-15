package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.Model.WeatherModel;
import com.example.demo.Service.WeatherService;

@RequestMapping(value="/weather")
@RestController
public class WeatherController {
	
	@Autowired
	public WeatherService weatherService;
	

    @GetMapping("/{locationName}/{data}")
    public ResponseEntity<Map<String, Object>> alldata(@PathVariable String locationName,@PathVariable String data){

    	 try {
             Map<String, Object> summary = weatherService.getWeatherSummary(locationName,data);
             return ResponseEntity.ok(summary);
         } catch (HttpClientErrorException.NotFound e) {
             return ResponseEntity.notFound().build();
         }
    	
    }
  


}
