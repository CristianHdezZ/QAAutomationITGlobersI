package co.com.itglobers.certification.testqa.interactions;

import co.com.itglobers.certification.testqa.util.Constant;
import co.com.itglobers.certification.testqa.util.ConsumoServicios;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

import static co.com.itglobers.certification.testqa.util.Constant.*;
import static co.com.itglobers.certification.testqa.util.MetodosComunes.adicionarLog;

public class SearchListOfBreweries implements Interaction {
    private String strName;
    private int intStatusCode;
    private String strUrlListaCervecerías;


    public SearchListOfBreweries(String strName) {
        this.strName = strName;
    }

    public static SearchListOfBreweries inTheAPI(String strName) {
        return Tasks.instrumented(SearchListOfBreweries.class,strName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        strUrlListaCervecerías = String.format(URL_PARA_OBTENER_INFORMACION_CERVECERIAS,strName);
        hmDatosCerveceria = new ArrayList<>();

        try {
            adicionarLog(Level.INFO, Constant.MSG_CONSULTA_SERVICIO_REST);
            adicionarLog(Level.INFO, String.format("Url del servicio: %s", strUrlListaCervecerías));
            Response obtenerInformacionCervecerias = ConsumoServicios.servicioRestGet(strUrlListaCervecerías);

            if (obtenerInformacionCervecerias != null) {

                intStatusCode = obtenerInformacionCervecerias.statusCode();
                adicionarLog(Level.INFO,"Status code: "+intStatusCode);

                if (intStatusCode == 200) {
                    adicionarLog(Level.INFO, "La consulta 'Cervecerias' se ha realizado exitosamente");
                    adicionarLog(Level.INFO, String.format("Respuesta del servicio:\n%s", obtenerInformacionCervecerias.body().asString()));

                    adicionarLog(Level.INFO,String.format(" ------ Lista de Cervecerias con el texto: %s ---------",strName));

                    hmDatosCerveceria = obtenerInformacionCervecerias.body().path("$");
                    for (Map<String, Object> mapaInformacionCervecerias : hmDatosCerveceria) {
                        adicionarLog(Level.INFO,String.format("\n Id: %s - Name: %s",
                                mapaInformacionCervecerias.get("id"),
                                mapaInformacionCervecerias.get("name")));
                    }

                } else {
                    adicionarLog(Level.SEVERE, String.format("No se pudo acceder al servicio cervecerias, se obtuvo el siguiente codigo de respuesta %s", intStatusCode));
                }
            } else {
                adicionarLog(Level.SEVERE, "No se pudo acceder al servicio cervecerias");
            }
        } catch (NullPointerException e) {
            adicionarLog(Level.SEVERE, String.format("No se pudo acceder al servicio cervecerias, se obtuvo el siguiente error: %s", e));
        }


    }
}