package co.com.itglobers.certification.testqa.util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;


public class ConsumoServicios {
    private static final Logger LOGGER = Logger.getLogger(ConsumoServicios.class.getName());
    private static final String AVISO = "\n----------------------------------------------------------------\n".concat("%s").concat("\n----------------------------------------------------------------");

    /**
     * permite consultar un servicio REST con metodo get contentType.JSON
     *
     * @param urlRequest url del servicio REST a consumir con parametros incluidos, si son necesarios.
     * @return objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio. si se
     * presenta alguna Exception retorna un valor nulo
     */
    public static Response servicioRestGet(String urlRequest) {
        try {
            return given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .when().get(urlRequest)
                    .then().extract().response();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format(AVISO, e.getMessage()));
            return null;
        }
    }

    /**
     * permite consultar un servicio REST con metodo get contentType.JSON
     *
     * @param urlRequest url del servicio REST a consumir con parametros incluidos, si son necesarios.
     * @param cabecera   objeto que implemente la interface Map < V, K > que contiene en formato clave, valor las cabeceras
     *                   necesarias para consumir el servicio
     * @return objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio. si se
     * presenta alguna Exception retorna un valor nulo
     */
    public static Response servicioRestGet(String urlRequest, Map<String, Object> cabecera) {
        try {
            return given().contentType(ContentType.JSON).relaxedHTTPSValidation().headers(cabecera)
                    .when().get(urlRequest)
                    .then().extract().response();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format(AVISO, e.getMessage()));
            return null;
        }
    }

    /**
     * permite consultar un servicio REST con metodo post contentType.JSON
     *
     * @param urlRequest url del servicio REST a consumir con parametros incluidos, si son necesarios.
     * @param body       String que contiene, en formato JSON, el body a ser publicado
     * @return objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio. si se
     * presenta alguna Exception retorna un valor nulo
     */
    public static Response servicioRestPost(String urlRequest, String body) {

        try {
            return given().contentType(ContentType.JSON).relaxedHTTPSValidation().body(body)
                    .when().post(urlRequest)
                    .then().extract().response();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format(AVISO, e.getMessage()));
            return null;
        }
    }

    /**
     * permite consultar un servicio REST con metodo get contentType.JSON
     *
     * @param urlRequest url del servicio REST a consumir con parametros incluidos, si son necesarios.
     * @param body       String que contiene, en formato JSON, el body a ser publicado
     * @param cabecera   objeto que implemente la interface Map < V, K > que contiene en formato clave, valor las cabeceras
     *                   necesarias para consumir el servicio
     * @return objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio. si se
     * presenta alguna Exception retorna un valor nulo
     */
    public static Response servicioRestPost(String urlRequest, String body, HashMap<String, Object> cabecera) {
        try {
            return given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .body(body).headers(cabecera)
                    .when().post(urlRequest)
                    .then().extract().response();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format(AVISO, e.getMessage()));
            return null;
        }
    }

    /**
     * permite consultar un servicio SOAP con metodo post contentType.XML
     *
     * @param urlRequest  url del servicio REST a consumir con parametros incluidos, si son necesarios.
     * @param requestBody String que contiene, en formato JSON, el body a ser publicado
     * @return objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio. si se
     * presenta alguna Exception retorna un valor nulo
     */
    public static Response requestSoap(String urlRequest, String requestBody) {
        try {
            return given().contentType(ContentType.XML).relaxedHTTPSValidation().body(requestBody)
                    .when().post(urlRequest)
                    .then().extract().response();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format(AVISO, e.getMessage()));
            return null;
        }
    }
}