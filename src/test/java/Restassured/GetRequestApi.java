package Restassured;

import java.util.HashMap;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;

public class GetRequestApi {
	static String token;
	static String access_token;
	static String BaseURI = "https://stage.rgw.calix.ai";
	
	public static void main(String[] args) {
		apigeeLogInApi();
	}
	
		public static void apigeeLogInApi() {
		
		    HashMap<String,String>	postcontent = new HashMap<>();
	        postcontent.put("email", "zyxel_lite@calix.com");
	        postcontent.put("password", "12345678");
	        postcontent.put("client_secret", "E91f10AbhcAQG8Lv");
	        postcontent.put("grant_type", "password");
	        postcontent.put("locale", "us");
	        postcontent.put("msisdn", "123456");
	        postcontent.put("notificationToken", "");
	        postcontent.put("packageName", "com.calix.smarthome");
	        postcontent.put("mobileOs", "ios");
	        postcontent.put("mobileDeviceId", "1234567");
	        
	          Response res= (Response) given()
	        		.header("X-Calix-ClientID","RR8ST5guVPKop2SqhK11lkJYL991umAA")
	        		.formParams(postcontent)
	        		.when()
	        		.post("https://stage.api.calix.ai/v1/ciq/authentication/token");
	        	
	        		System.out.println(res.asPrettyString());
	        	String str=	res.jsonPath().get("firstName").toString();
	    		System.out.println(str);
	        	Assert.assertEquals(str, "zyxel");
	        	
	        
	}


}
