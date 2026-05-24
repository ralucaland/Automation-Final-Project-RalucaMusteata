package api.data;

public class DataPracticeSoftTests {

    // Base URL for Practice Software Testing API
    public static final String BASE_URL =
            "https://api.practicesoftwaretesting.com";

    // Endpoint pentru lista de produse și search produse
    public static final String PRODUCTS_ENDPOINT =
            "/products";

    // Endpoint pentru un produs specific
    public static final String SINGLE_PRODUCT_ENDPOINT =
            "/products/{productId}";

    // Query parameter pentru căutarea produselor
    public static final String SEARCH_QUERY_PARAM =
            "q";

    // Termen de căutare pentru test pozitiv
    public static final String SEARCH_PRODUCT =
            "hammer";

    // Termen de căutare pentru test negativ
    public static final String SEARCH_INVALID_PRODUCT =
            "zzzzInvalidProduct";

    // ID produs valid luat din response-ul real al API-ului
    public static final String VALID_PRODUCT_ID =
            "01KSCPVBFSNZWC2YD3JNZSTVCD";

    // Chei JSON folosite în validări
    public static final String RESPONSE_DATA_KEY =
            "data";

    public static final String RESPONSE_ID_KEY =
            "id";

    public static final String RESPONSE_NAME_KEY =
            "name";

    // Status code pentru request reușit
    public static final int STATUS_CODE_OK =
            200;



    // Endpoint pentru login
    public static final String LOGIN_ENDPOINT =
            "/users/login";

    // Date invalide pentru test negativ de login
    public static final String INVALID_LOGIN_EMAIL =
            "invalid_user@test.com";

    public static final String INVALID_LOGIN_PASSWORD =
            "wrongPassword123";

    // Cheie JSON pentru mesajul de eroare
    public static final String RESPONSE_ERROR_KEY =
            "error";

    // Status code pentru request neautorizat
    public static final int STATUS_CODE_UNAUTHORIZED =
            401;
}