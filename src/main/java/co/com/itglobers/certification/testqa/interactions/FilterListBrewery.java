package co.com.itglobers.certification.testqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.codehaus.groovy.util.ListHashMap;

import java.util.Map;
import java.util.logging.Level;

import static co.com.itglobers.certification.testqa.util.Constant.hmDatosCerveceria;
import static co.com.itglobers.certification.testqa.util.Constant.hmFiltroDatosCerveceria;
import static co.com.itglobers.certification.testqa.util.MetodosComunes.adicionarLog;


public class FilterListBrewery implements Interaction {
    private String strKeyName;

    public FilterListBrewery(String strKeyName) {
        this.strKeyName = strKeyName;
    }

    public static FilterListBrewery withKeyName(String strKeyName) {
        return Tasks.instrumented(FilterListBrewery.class,strKeyName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        hmFiltroDatosCerveceria = new ListHashMap<>();

        adicionarLog(Level.INFO,String.format("----- Lista de cervecerias que contengan en la key 'name', el valor: %s ------",strKeyName));
        for (Map<String, Object> mapaInformacionCervecerias : hmDatosCerveceria) {
            if (mapaInformacionCervecerias.get("name").toString().equalsIgnoreCase(strKeyName)){
                adicionarLog(Level.INFO,String.format("\n Id: %s - Name: %s",
                        mapaInformacionCervecerias.get("id"),
                        mapaInformacionCervecerias.get("name")));
                hmFiltroDatosCerveceria.put(Integer.parseInt(mapaInformacionCervecerias.get("id").toString()),mapaInformacionCervecerias.get("name").toString());
            }
        }
    }
}