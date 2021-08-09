package co.com.itglobers.certification.testqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.logging.Level;

import static co.com.itglobers.certification.testqa.util.Constant.*;
import static co.com.itglobers.certification.testqa.util.MetodosComunes.adicionarLog;

public class VerifyResultBreweries implements Question<Boolean> {
    private String strKeyName;
    private String strStreet;
    private String strPhone;

    public VerifyResultBreweries(String strKeyName, String strStreet, String strPhone) {
        this.strKeyName = strKeyName;
        this.strStreet = strStreet;
        this.strPhone = strPhone;
    }

    public static VerifyResultBreweries with(String strKeyName, String strStreet, String strPhone) {
        return new VerifyResultBreweries(strKeyName,strStreet,strPhone);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        if(cerveceria.getName().equalsIgnoreCase(strKeyName)&&cerveceria.getStreet().equalsIgnoreCase(strStreet)&&cerveceria.getPhone().equalsIgnoreCase(strPhone)){
            adicionarLog(Level.INFO,String.format("Se verifico sobre la cervecería resultante,lo siguiente: \nName:%s \nstreet:%s \nphone:%s",
                    cerveceria.getName(),
                    cerveceria.getStreet(),
                    cerveceria.getPhone()));
        }


        return cerveceria.getName().equalsIgnoreCase(strKeyName)&&cerveceria.getStreet().equalsIgnoreCase(strStreet)&&cerveceria.getPhone().equalsIgnoreCase(strPhone);
    }
}