package tests.api;

import dto.UserDTOLombok;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTestAPI {

    UserDTOLombok userAPI = UserDTOLombok.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidGVzdHFhMjBAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MTU5Mjk2MzIsImlhdCI6MTcxNTMyOTYzMn0.DMjDaMqj4vQNu-jqyCWGDAtr4WMFzTW6qe2jitqAFjc";
    public static final String AUTH = "Authorization";

    @BeforeSuite
    public void initAPI() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "/v1";
    }
}
