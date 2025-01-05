package Restassured;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;

import com.qa.api.Pojo_PostRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GetRequestApi {
	static String token;
	static String access_token;
	static String orgId;
	static String fsan;
	static String userId;
	static String firstSsid;
	static String CscBaseURI = "https://stage.api.calix.ai/";
	
	public static void main(String[] args) {
		
//	login();
//		apigeeLogInApi();
		main1();
//		getSubscribeinfo();
//		getSsidPool();
//		getFeatureProperties();
	//	postUsingPojo();
	}
	
    public static void main1() {
        try {
            URL url = new URL("http://127.0.0.1:4723/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Appium Server is up and running");
            } else {
                System.out.println("Failed to connect: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
		public static void apigeeLogInApi() {
		
		    HashMap<String,String>	postcontent = new HashMap<>();
	        postcontent.put("email", "zyxel_liteold@calix.com");
	        postcontent.put("password", "12345678");
	        postcontent.put("client_secret", "E91f10AbhcAQG8Lv");
	        postcontent.put("grant_type", "password");
	        postcontent.put("locale", "us");
	        postcontent.put("msisdn", "123456");
	        postcontent.put("notificationToken", "");
	        postcontent.put("packageName", "com.calix.smarthome");
	        postcontent.put("mobileOs", "ios");
	        postcontent.put("mobileDeviceId", "1234567");
	        
	            Response res= given()
	        		.header("X-Calix-ClientID","RR8ST5guVPKop2SqhK11lkJYL991umAA")
	        		.formParams(postcontent)
	        		.when()
	        		.post(CscBaseURI+"v1/ciq/authentication/token");
	                 Assert.assertEquals(res.getStatusCode(), 200);
	                 System.out.println(res.asPrettyString());
                     token=res.jsonPath().get("token").toString();
	                 access_token=res.jsonPath().get("access_token").toString();
	                 orgId=res.jsonPath().get("orgId").toString();
	                 userId=res.jsonPath().get("userId").toString();
	                 System.out.println(userId);
	                 System.out.println(orgId);
	                 System.out.println(token);
	                 System.out.println(access_token);
	}
		
		
		public static void getSubscribeinfo() {
			Response res = given().header("X-Calix-ClientID", "RR8ST5guVPKop2SqhK11lkJYL991umAA")
					.header("X-Calix-AccessToken", access_token).when()
					.get(CscBaseURI + "v1/ciq/device/router/subscriber?userId=" + userId);
			System.out.println(res.asPrettyString());
			fsan = res.jsonPath().getString("fsan");

		}
		
		public static void getSsidPool() {
			Response res = given().header("X-Calix-ClientID", "RR8ST5guVPKop2SqhK11lkJYL991umAA")
					.header("X-Calix-AccessToken", access_token).when()
					.get(CscBaseURI + "v1/csc/device/"+orgId+"/"+fsan+"/ssidPool");
			System.out.println(res.asPrettyString());
			firstSsid=res.jsonPath().getString("[\"primary-operator-ssid\"][0].SSIDName");
			 System.out.println("firstSsid"+firstSsid);
		}
		
		public static void getFeatureProperties() {
			Response res = given().header("X-Calix-ClientID", "RR8ST5guVPKop2SqhK11lkJYL991umAA")
					.header("X-Calix-AccessToken", access_token)
					.contentType(ContentType.JSON)
					.when()
					.get(CscBaseURI + "v1/calix/support/device/feature-properties?serialNumber="+fsan);			
			System.out.println(res.asPrettyString());
		String valueList=res.jsonPath().getString("properties[?(@.featureName=='SSID1')].fields[?(@.name=='BeaconType')].valueList");
		System.out.println(valueList);
		}
			
//			//JsonObject class
//			JSONObject jo=new JSONObject(res.asPrettyString());//Converting response to JSON Object type
//			for (int i = 0; i <jo.getJSONArray("properties").length(); i++) {
//                String featureName=jo.getJSONArray("properties").getJSONObject(i).get("featureName").toString();
//                System.out.println(featureName+""+i);
//				if (featureName.equals("SSID1")) {
//					System.out.println("Test");
//					  String arr=   res.jsonPath().getString("properties["+i+"].fields[3].valueList");
//			             System.out.println(arr);
//					for (int j = 0; j <jo.getJSONArray("properties").length(); j++) {
//		                String fieldName=jo.getJSONArray("properties").getJSONObject(i).get("fields").toString();
//					System.out.println(fieldName);
////		           
//					}
//				}
//				
//			}
		
		
		/*
		 * Authorization
		 * basic- auth().basic();
		 * Digest- auth().digest();
		 * Preemptive- auth().Preemptive().basic();
		 * 
		 * oath1.0- auth().oath("consumerkey","consumersecrat","accessToken","tokenSecrate")
		 * oath2.0- auth().oath2()
		 */
		
		public static void login() {
			given()
			.auth().basic("postman", "password")
			.when()
			.get("https://postman-echo.com/basic-auth");	
		}
		
		
		
		public static void postUsingPojo() {
			Pojo_PostRequest data=new Pojo_PostRequest();
			data.setEmail("automation@testing2.com");
			data.setPassword("12345678");
			data.setClient_secret("E91f10AbhcAQG8Lv");
			data.setGrant_type("password");
			data.setLocale("us");
			data.setMsisdn("123456");
			data.setNotificationToken("");
			data.setPackageName("com.calix.smarthome");
			data.setMobileOs("ios");
			data.setMobileDeviceId("1234567");
			
			   given()
       		.header("X-Calix-ClientID","RR8ST5guVPKop2SqhK11lkJYL991umAA")
       		.contentType(ContentType.JSON)
       		.body(data)
       		.when()
       		.post("https://stage.api.calix.ai/v1/ciq/authentication/token")
       		.then()
       		.statusCode(200)
       		.body("firstName", equalTo("automation"))
       		.log().all();
		}

}