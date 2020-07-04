package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	private static Response response = null;
	
	public Response getResponse() {
		return response;
	}

	public static void setResponse(Response _response) {
		response = _response;
	}
	
	private static RequestSpecification setBaseUri(String url) {
		return RestAssured.given().contentType(ContentType.JSON).baseUri(url).when();
	}

	public static void executaGET(String url, String endpoint) {
		Response response = setBaseUri(url)
				.get(endpoint)
				.then()
				.extract()
				.response();
		RestUtils.setResponse(response);
	}
	
	public static void executaPOST(String url, String endpoint, Object json) {
		Response response = setBaseUri(url)
				.body(json)
				.post(endpoint)
				.then()
				.extract()
				.response();
		RestUtils.setResponse(response);
	}
	
	
	
	public static Object getValue(String key) {
		return response.getBody().jsonPath().get(key);
	}
	
	
}
