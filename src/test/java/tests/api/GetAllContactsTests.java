package tests.api;

import dto.AllContactsDTO;
import org.testng.annotations.Test;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class GetAllContactsTests extends BaseTestAPI{

    private static final String ENDPOINT_GET_ALL_CONTACTS = "/contacts";

    @Test(description = "positive get all contacts test")
    public void getAllContactsTest() {
        AllContactsDTO allContactsDTO = given()
                .header(AUTH, token)
                .when()
                .get(ENDPOINT_GET_ALL_CONTACTS)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDTO.class);
        System.out.println(allContactsDTO.getContacts().get(0).getId());
    }
}
