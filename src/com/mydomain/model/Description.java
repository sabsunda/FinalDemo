package com.mydomain.model;

import java.util.List;

public class Description {
	private String description;
	private List<ImageInfo> urls;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ImageInfo> getUrls() {
		return urls;
	}
	public void setUrls(List<ImageInfo> urls) {
		this.urls = urls;
	}
	
}
