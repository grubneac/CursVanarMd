import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class TestApplication {

	public static void main(String[] args) throws MalformedURLException, IOException {
		OpenWeatherProvider openWeatherProvider = new OpenWeatherProvider();
		System.out.println("Chisinau temp="+openWeatherProvider.getCurrentTemperature("Chisinau"));
		System.out.println("London temp="+openWeatherProvider.getCurrentTemperature("London"));
		System.out.println("Moscow temp="+openWeatherProvider.getCurrentTemperature("Moscow"));
	
	}

}
