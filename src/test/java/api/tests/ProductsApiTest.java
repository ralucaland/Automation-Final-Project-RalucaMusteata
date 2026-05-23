package api.tests;

import api.base.BaseApiTest;
import api.data.DataPracticeSoft;
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
                        DataPracticeSoft.SEARCH_QUERY_PARAM,
                        DataPracticeSoft.SEARCH_PRODUCT
                )
                .when()
                .get(DataPracticeSoft.PRODUCTS_ENDPOINT);

        // Afișăm răspunsul pentru a verifica manual ce produse au fost returnate.
        response.prettyPrint();

        // Verificăm că request-ul a fost procesat cu succes.
        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoft.STATUS_CODE_OK
        );

        // Verificăm că lista de produse returnată în "data" conține cel puțin un produs.
        // Dacă size() > 0, înseamnă că search-ul a găsit rezultate.
        Assert.assertTrue(
                response.jsonPath()
                        .getList(DataPracticeSoft.RESPONSE_DATA_KEY)
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
                        DataPracticeSoft.SEARCH_QUERY_PARAM,
                        DataPracticeSoft.SEARCH_INVALID_PRODUCT
                )
                .when()
                .get(DataPracticeSoft.PRODUCTS_ENDPOINT);

        // Afișăm răspunsul pentru debugging.
        // Ar trebui să vedem că lista "data" este goală.
        response.prettyPrint();

        // Verificăm că request-ul a fost acceptat și procesat cu succes.
        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoft.STATUS_CODE_OK
        );

        // Verificăm că lista de produse returnată este goală.
        // Asta confirmă că API-ul nu returnează produse pentru un termen invalid.
        Assert.assertTrue(
                response.jsonPath()
                        .getList(DataPracticeSoft.RESPONSE_DATA_KEY)
                        .isEmpty()
        );
    }

    @Test
    public void getSingleProductByValidIdTest() {

        // API_004
        // Scop: verificăm că API-ul returnează detaliile unui singur produs
        // atunci când folosim un ID valid.
        //
        // Request trimis:
        // GET /products/1
        //
        // Validări principale:
        // 1. Status code trebuie să fie 200 OK.
        // 2. Response-ul trebuie să conțină câmpul "id".
        // 3. Response-ul trebuie să conțină câmpul "name".

        Response response = given()
                // Înlocuim {productId} din endpoint cu valoarea din DataPracticeSoft.
                // Endpoint final: /products/1
                .pathParam(
                        "productId",
                        DataPracticeSoft.VALID_PRODUCT_ID
                )
                .when()
                .get(DataPracticeSoft.SINGLE_PRODUCT_ENDPOINT);

        // Afișăm răspunsul pentru a vedea detaliile produsului returnat.
        response.prettyPrint();

        // Verificăm că request-ul a fost procesat cu succes.
        Assert.assertEquals(
                response.statusCode(),
                DataPracticeSoft.STATUS_CODE_OK
        );

        // Verificăm că produsul returnat are câmpul "id".
        Assert.assertNotNull(
                response.jsonPath().get(DataPracticeSoft.RESPONSE_ID_KEY)
        );

        // Verificăm că produsul returnat are câmpul "name".
        Assert.assertNotNull(
                response.jsonPath().get(DataPracticeSoft.RESPONSE_NAME_KEY)
        );
    }
}
