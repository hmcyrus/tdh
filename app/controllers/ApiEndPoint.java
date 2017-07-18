package controllers;

import static play.libs.Json.toJson;

import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;

public class ApiEndPoint extends Controller {
	public static Result getHospitals() {
    	return ok(toJson(models.Hospital.find.all()));
    }
	
	public static Result checkString() {
    	//return ok(toJson(models.Hospital.find.all()));
		RequestBody body = request().body();
		String data = body.asText();
		for(int i = 0; i < data.length(); i++){
			System.out.println(data.charAt(i) + " -- "  + (int) data.charAt(i));
		}
		String[] logs = data.substring(2).split("\n"); 
		System.out.println(data + logs.length +  " -- " + logs[0]); 
		return ok("Got body: " + body);
    }
	
}
