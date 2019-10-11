import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class TestApplication {

	public static void main(String[] args) throws MalformedURLException, IOException {
		final String ENDPOINT ="http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5c2bafacdd1fff84aac28141f5227cfb";
		
		Scanner scaner = new Scanner(new URL(ENDPOINT).openStream());
//		String  json_str= "{ \"name\": \"Ion\", \"age\" : 25}";
		String  json_str =scaner.nextLine();
//		System.out.println(json_str);
		JSONObject json = new JSONObject(json_str);
		System.out.println(json.get("main"));
		JSONObject temper =json.getJSONObject("main");
		System.out.println(temper.get("temp"));
	}

}
