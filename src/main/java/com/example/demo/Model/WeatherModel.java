package com.example.demo.Model;

public class WeatherModel {
	private String title;
	private String version;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "WeatherModel [title=" + title + ", version=" + version + ", description=" + description + "]";
	}
	

}
