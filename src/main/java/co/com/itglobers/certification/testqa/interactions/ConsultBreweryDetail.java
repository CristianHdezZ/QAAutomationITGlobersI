package co.com.itglobers.certification.testqa.interactions;

import co.com.itglobers.certification.testqa.model.Cerveceria;
import co.com.itglobers.certification.testqa.util.Constant;
import co.com.itglobers.certification.testqa.util.ConsumoServicios;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.codehaus.groovy.util.ListHashMap;

import java.util.Map;
import java.util.logging.Level;

import static co.com.itglobers.certification.testqa.util.Constant.*;
import static co.com.itglobers.certification.testqa.util.MetodosComunes.adicionarLog;

public class ConsultBreweryDetail implements Interaction {
    private String strState;
    private String strUrlDetalleCervecerías;
    private int intStatusCode;
    private int intContador;

    public ConsultBreweryDetail(String strState) {
        this.strState = strState;
    }

    public static ConsultBreweryDetail withTheState(String strState) {
        return Tasks.instrumented(ConsultBreweryDetail.class,strState);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        hmDetalleCerveceria = new ListHashMap<>();
        intContador = 0;

        try {
            adicionarLog(Level.INFO, Constant.MSG_CONSULTA_SERVICIO_REST);

            for (Map.Entry<Integer,String> entry: hmFiltroDatosCerveceria.entrySet() ) {
                intContador = intContador+1;

                strUrlDetalleCervecerías = String.format(URL_PARA_OBTENER_DETALLE_CERVECERIA,entry.getKey());
                adicionarLog(Level.INFO, String.format("Url del servicio: %s", strUrlDetalleCervecerías));

                Response obtenerDetalleDeCervecerias = ConsumoServicios.servicioRestGet(strUrlDetalleCervecerías);

                if (obtenerDetalleDeCervecerias !=null){
                    intStatusCode = obtenerDetalleDeCervecerias.statusCode();
                    adicionarLog(Level.INFO,"Status code: "+intStatusCode);
                    if (intStatusCode==200){

                        adicionarLog(Level.INFO,obtenerDetalleDeCervecerias.body().asString());

                        hmDetalleCerveceria.put(intContador,new Cerveceria(
                                obtenerDetalleDeCervecerias.path("id").toString(),
                                obtenerDetalleDeCervecerias.path("name").toString(),
                                obtenerDetalleDeCervecerias.path("street").toString(),
                                obtenerDetalleDeCervecerias.path("city").toString(),
                                obtenerDetalleDeCervecerias.path("state").toString(),
                                obtenerDetalleDeCervecerias.path("phone").toString())
                        );

                        for (Map.Entry<Integer,Cerveceria> entryDetalleCervecerias : hmDetalleCerveceria.entrySet()) {
                            adicionarLog(Level.INFO,String.format("\n Id: %s \nName: %s \nStreet:%s \ncity:%s \nstate:%s \nphone:%s \n---------------------------------------------------",
                                    entryDetalleCervecerias.getValue().getId(),
                                    entryDetalleCervecerias.getValue().getName(),
                                    entryDetalleCervecerias.getValue().getStreet(),
                                    entryDetalleCervecerias.getValue().getCity(),
                                    entryDetalleCervecerias.getValue().getState(),
                                    entryDetalleCervecerias.getValue().getPhone()));
                        }
                    }
                }
            }

            adicionarLog(Level.INFO,String.format("------------- Se toma solo aquel que contenga state = %s ------------",strState));
            for (Map.Entry<Integer,Cerveceria> entryDetalleCervecerias : hmDetalleCerveceria.entrySet()) {

                if (entryDetalleCervecerias.getValue().getState().equalsIgnoreCase(strState)){
                    cerveceria = new Cerveceria(entryDetalleCervecerias.getValue().getId(),
                            entryDetalleCervecerias.getValue().getName(),
                            entryDetalleCervecerias.getValue().getStreet(),
                            entryDetalleCervecerias.getValue().getCity(),
                            entryDetalleCervecerias.getValue().getState(),
                            entryDetalleCervecerias.getValue().getPhone());

                    adicionarLog(Level.INFO,String.format("\n Id: %s \nName: %s \nStreet:%s \ncity:%s \nstate:%s \nphone:%s \n---------------------------------------------------",
                            entryDetalleCervecerias.getValue().getId(),
                            entryDetalleCervecerias.getValue().getName(),
                            entryDetalleCervecerias.getValue().getStreet(),
                            entryDetalleCervecerias.getValue().getCity(),
                            entryDetalleCervecerias.getValue().getState(),
                            entryDetalleCervecerias.getValue().getPhone()));
                }

            }

        } catch (NullPointerException e) {
            adicionarLog(Level.SEVERE, String.format("No se pudo acceder al servicio cervecerias, se obtuvo el siguiente error: %s", e));
        }

    }
}
