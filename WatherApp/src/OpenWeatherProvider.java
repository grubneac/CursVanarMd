import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

public class OpenWeatherProvider {
	
	final String ENDPOINT ="http://api.openweathermap.org/data/2.5/weather?q=City&units=metric&APPID=5c2bafacdd1fff84aac28141f5227cfb";
	
	/**
	 * endpoint: api.openweathermap.org/data/2.5/weather
	 * params: 
	 * city 
	 * units
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * 
	 * */
	public Float  getCurrentTemperature(String city) throws MalformedURLException, IOException {
		String localEndPoint = ENDPOINT;
			localEndPoint = localEndPoint.replace("City", city);
		Scanner scaner = new Scanner(new URL(localEndPoint).openStream());
			String  json_str =scaner.nextLine();
		scaner.close();
		
//		System.out.println(json_str);
		JSONObject json = new JSONObject(json_str);
//		System.out.println(json.get("main"));
		JSONObject temper =json.getJSONObject("main");
		Float temp = Float.parseFloat(temper.get("temp").toString());
//		System.out.println(temp);	
		return  temp;
	}
	
	
	/**
	 * endpoint: api.openweathermap.org/data/2.5/forecast/daily
	 * params: city, units
	 * */	
	public ArrayList<Float>  getForecast16DaysTemperature(String city) {
		
		return null;
	}	
	
}