package com.laptrinhweb.utils;

import java.io.BufferedReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	private String value;	
	public HttpUtils(String value) {
		this.value = value;
	}
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	public static HttpUtils Of(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
			return new HttpUtils(sb.toString());
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
}
