import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class CoinRateProvider {
	private static final String  ENDPOINT ="http://api.coinlayer.com/api/live?access_key=e86330f4310b780fc3ebac7b9a6bc617"; 
	private static String CurENDPOINT = ENDPOINT;
	/**
	 * endpoint: Reques https://api.coinlayer.com/live
	 * возвращает карту где код валюты - ключ, а коэфициент - значение
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */
	public HashMap<String,Float>  getLiveRates() throws MalformedURLException, IOException {
		Scanner scaner = new Scanner(new URL(CurENDPOINT).openStream());
		String  json_str =scaner.nextLine();
		scaner.close();
	
//		System.out.println(json_str);
		JSONObject json = new JSONObject(json_str);

		Map<String, Object> hashMap = new HashMap<>();
		hashMap =json.getJSONObject("rates").toMap();
		
		HashMap<String,Float> resultMap = new HashMap<>();
		for (Map.Entry<String, Object> pair : hashMap.entrySet()) {
			resultMap.put(pair.getKey(), Float.parseFloat(pair.getValue().toString()));
		}
		return resultMap;
	}

	/**
	 * endpoint: Request https://api.coinlayer.com/live
	 * возвращает карту где код валюты - ключ, а коэфициент - значение
	 * параметр "currencies" служит фильтром (мы передаем коды тех валют что нас интересуют) 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */
	public HashMap<String,Float>  getLiveRates(HashSet<String> currencies) throws MalformedURLException, IOException {
		CurENDPOINT = ENDPOINT;
		CurENDPOINT = SetCurEndPointByCodeVal(currencies, CurENDPOINT);
//		System.out.println(CurENDPOINT);
		
		HashMap<String,Float> hashMap =getLiveRates();
		CurENDPOINT = ENDPOINT;
		return hashMap;
	}
	
	
	/**
	 * endpoint: https://api.coinlayer.com/YYYY-MM-DD
	 * возвращает карту где код валюты - ключ, а коэфициент - значение - за определенную дату
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */	
	public HashMap<String,Float>  getHistoricalRates(Date date) throws MalformedURLException, IOException {
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		CurENDPOINT = ENDPOINT;
		CurENDPOINT = CurENDPOINT.replace("live", df.format(date));
//		System.out.println(CurENDPOINT);
		
		HashMap<String,Float> hashMap =getLiveRates();
		CurENDPOINT = ENDPOINT;
		return hashMap;
		
	}	

	/**
	 * endpoint: https://api.coinlayer.com/YYYY-MM-DD
	 * возвращает карту где код валюты - ключ, а коэфициент - значение - за определенную дату
	 * параметр "currencies" служит фильтром (мы передаем коды тех валют что нас интересуют) 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */	
	public HashMap<String,Float>  getHistoricalRates(HashSet<String> currencies, Date date) throws MalformedURLException, IOException {
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		CurENDPOINT = ENDPOINT;
		CurENDPOINT = CurENDPOINT.replace("live", df.format(date));
		CurENDPOINT = SetCurEndPointByCodeVal(currencies, CurENDPOINT);
//		System.out.println(CurENDPOINT);
		
		HashMap<String,Float> hashMap =getLiveRates();
		CurENDPOINT = ENDPOINT;
		return hashMap;
		
	}	
	
	private static String SetCurEndPointByCodeVal(HashSet<String> currencies,String vPoint) {
		Boolean flag =false;
		String resultPoint=vPoint;
		resultPoint +="&&symbols=";
		for (String code : currencies) {
			if(flag) {//первый раз запятая не нужна
				resultPoint +=",";
			}
			resultPoint +=code;
			flag =true;
		}		
		return resultPoint;		
	}
	
}