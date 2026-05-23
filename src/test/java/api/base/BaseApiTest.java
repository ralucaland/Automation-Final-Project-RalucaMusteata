package api.base;

import api.data.DataPracticeSoft;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    @BeforeMethod
    public void setupApi() {

        RestAssured.baseURI = DataPracticeSoft.BASE_URL;
    }
}