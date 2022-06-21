package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class Request {

    private String url;
    private Map<String, String> queryParams;

    public Request(String url, Map<String, String> queryParams) {
        this.url = url;
        this.queryParams = queryParams;
    }

    public Response sendRequest() {
        return RestAssured
                .given()
                .queryParams(queryParams)
                .get(url);
    }
}
