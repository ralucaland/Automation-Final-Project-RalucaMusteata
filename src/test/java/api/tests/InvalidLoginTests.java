package api.tests;

import api.base.BaseApiTest;
import api.data.DataPracticeSoftTests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InvalidLoginTests extends BaseApiTest {

    @Test
    public void loginInvalid() {

        // API_005
        // Scop: verificăm că API-ul respinge login-ul
        // atunci când trimitem email și parolă invalide.

        String body = """
                {
                    "email": "%s",
                    "password": "%s"
                }
                """.formatted(
                DataPracticeSoftTests.INVALID_LOGIN_EMAIL,
                DataPracticeSoftTests.INVALID_LOGIN_PASSWORD
        );

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(DataPracticeSoftTests.LOGIN_ENDPOINT);

        response.prettyPrint();

        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoftTests.STATUS_CODE_UNAUTHORIZED
        );

        Assert.assertNotNull(
                response.jsonPath().get(DataPracticeSoftTests.RESPONSE_ERROR_KEY)
        );

        Assert.assertEquals(
                response.jsonPath().getString(DataPracticeSoftTests.RESPONSE_ERROR_KEY),
                "Unauthorized"
        );
    }
}