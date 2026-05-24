package api.tests;

import api.base.BaseApiTest;
import api.data.DataPracticeSoftTests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductsApiTest extends BaseApiTest {


    @Test
    public void searchProductWithValidKeywordTest() {

        // API_002
        // Scop: verificăm că funcționalitatea de search returnează rezultate
        // atunci când folosim un cuvânt de căutare valid.
        //
        // Request trimis:
        // GET /products?q=hammer
        //
        // Validări principale:
        // 1. Status code trebuie să fie 200 OK.
        // 2. Lista "data" din răspuns nu trebuie să fie goală.

        Response response = given()
                // Adăugăm query parameter-ul pentru căutare.
                // q = hammer
                .queryParam(
                        DataPracticeSoftTests.SEARCH_QUERY_PARAM,
                        DataPracticeSoftTests.SEARCH_PRODUCT
                )
                .when()
                .get(DataPracticeSoftTests.PRODUCTS_ENDPOINT);

        // Afișăm răspunsul pentru a verifica manual ce produse au fost returnate.
        response.prettyPrint();

        // Verificăm că request-ul a fost procesat cu succes.
        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoftTests.STATUS_CODE_OK
        );

        // Verificăm că lista de produse returnată în "data" conține cel puțin un produs.
        // Dacă size() > 0, înseamnă că search-ul a găsit rezultate.
        Assert.assertTrue(
                response.jsonPath()
                        .getList(DataPracticeSoftTests.RESPONSE_DATA_KEY)
                        .size() > 0
        );
    }

    @Test
    public void searchProductWithInvalidKeywordTest() {

        // API_003
        // Scop: verificăm comportamentul API-ului atunci când căutăm
        // un produs care nu ar trebui să existe.
        //
        // Request trimis:
        // GET /products?q=zzzzInvalidProduct
        //
        // Validări principale:
        // 1. Status code trebuie să fie 200 OK.
        // 2. Lista "data" trebuie să fie goală.
        //
        // Important:
        // Nu așteptăm 404 aici, pentru că endpoint-ul /products există.
        // API-ul răspunde corect cu 200, dar fără rezultate.

        Response response = given()
                // Adăugăm un query parameter cu un termen invalid.
                // Scopul este să verificăm că API-ul nu returnează produse greșite.
                .queryParam(
                        DataPracticeSoftTests.SEARCH_QUERY_PARAM,
                        DataPracticeSoftTests.SEARCH_INVALID_PRODUCT
                )
                .when()
                .get(DataPracticeSoftTests.PRODUCTS_ENDPOINT);

        // Afișăm răspunsul pentru debugging.
        // Ar trebui să vedem că lista "data" este goală.
        response.prettyPrint();

        // Verificăm că request-ul a fost acceptat și procesat cu succes.
        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoftTests.STATUS_CODE_OK
        );

        // Verificăm că lista de produse returnată este goală.
        // Asta confirmă că API-ul nu returnează produse pentru un termen invalid.
        Assert.assertTrue(
                response.jsonPath()
                        .getList(DataPracticeSoftTests.RESPONSE_DATA_KEY)
                        .isEmpty()
        );
    }

    @Test
    public void getSingleProductByValidIdTest() {

        // API_004
        // Scop: verificăm că API-ul returnează detaliile unui produs existent.
        //
        // Request trimis:
        // GET /products/{productId}
        //
        // Notă:
        // Folosim un ID real copiat din response-ul GET /products?q=hammer.

        Response response = given()
                .pathParam(
                        "productId",
                        "01KSCXQ23BVG38QVJV1ST1WDH6"
                )
                .when()
                .get(DataPracticeSoftTests.SINGLE_PRODUCT_ENDPOINT);

        response.prettyPrint();

        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoftTests.STATUS_CODE_OK
        );

        Assert.assertNotNull(
                response.jsonPath().get(DataPracticeSoftTests.RESPONSE_ID_KEY)
        );

        Assert.assertNotNull(
                response.jsonPath().get(DataPracticeSoftTests.RESPONSE_NAME_KEY)
        );
    }
}
