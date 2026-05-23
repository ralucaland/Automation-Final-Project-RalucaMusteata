package api.base;

import api.data.DataPracticeSoftTests;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    @BeforeMethod
    public void setupApi() {

        RestAssured.baseURI = DataPracticeSoftTests.BASE_URL;
    }
}