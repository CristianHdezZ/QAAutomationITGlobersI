package co.com.itglobers.certification.testqa.util;

import co.com.itglobers.certification.testqa.model.Cerveceria;
import org.codehaus.groovy.util.ListHashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Constant {
    public static int SIZE_RESULT_PRODUCTO_FILTER_BRAND;
    public static final Logger LOG_ITGLOBERS = Logger.getLogger("com.itglobers");
    public static final String MSG_CONSULTA_SERVICIO_REST = "---------- CONSULTA DE SERVICIO REST ----------";
    public static List<Map<String, Object>> hmDatosCerveceria;
    public static ListHashMap<Integer,String> hmFiltroDatosCerveceria;
    public static ListHashMap<Integer, Cerveceria> hmDetalleCerveceria;
    public static Cerveceria cerveceria;


    /**
     * WEBSERVICES REST
     */
    public static final String URL_PARA_OBTENER_INFORMACION_CERVECERIAS = "https://api.openbrewerydb.org/breweries/autocomplete?query=%s";
    public static final String URL_PARA_OBTENER_DETALLE_CERVECERIA ="https://api.openbrewerydb.org/breweries/%s";
}