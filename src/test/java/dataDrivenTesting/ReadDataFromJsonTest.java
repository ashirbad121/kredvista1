package dataDrivenTesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws IOException, ParseException
	{
		//used to read json file
		FileReader file=new FileReader("./src\\test\\resources\\JSONRead.json");
		
		//JSONParser used to read/write json formatted file
		JSONParser jsonp= new JSONParser();
		
		//parse method used to convert from json to java object
		Object obj=jsonp.parse(file);
		
		//read data from json file by converting java object to json object
		
		JSONObject map=(JSONObject) obj;
		
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}
}
