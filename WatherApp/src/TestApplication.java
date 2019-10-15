import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class TestApplication {

	public static void main(String[] args) throws MalformedURLException, IOException {
//		OpenWeatherProvider openWeatherProvider = new OpenWeatherProvider();
//		System.out.println("Chisinau temp="+openWeatherProvider.getCurrentTemperature("Chisinau"));
//		System.out.println("London temp="+openWeatherProvider.getCurrentTemperature("London"));
//		System.out.println("Moscow temp="+openWeatherProvider.getCurrentTemperature("Moscow"));
		
		CoinRateProvider coinRateProvider = new CoinRateProvider();
		
//		-------------------------------------------------------------------------------
		HashMap<String, Float> hashMap= coinRateProvider.getLiveRates();
		System.out.println("function getLiveRates return:");
		for (Map.Entry<String, Float> pair	: hashMap.entrySet()) {
			System.out.println(pair.getKey()+" : "+String.format("%.7f", pair.getValue()));
		}
//		-------------------------------------------------------------------------------
		HashSet<String> codVal = new HashSet<>(Arrays.asList("MDA","LUX","EUR"));
		HashMap<String, Float> hashMap2= coinRateProvider.getLiveRates(codVal);
		System.out.println("function getLiveRates return:");
		for (Map.Entry<String, Float> pair	: hashMap2.entrySet()) {
			System.out.println(pair.getKey()+" : "+String.format("%.7f", pair.getValue()));
		}
//		-------------------------------------------------------------------------------
	}

}
