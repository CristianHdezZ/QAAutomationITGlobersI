package co.com.itglobers.certification.testqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.itglobers.certification.testqa.userinterface.FilterInHomeBrandPage.*;

public class VerifyQuantity implements Question<Boolean> {
    private int resultExpected;

    public VerifyQuantity(int resultExpected) {
        this.resultExpected = resultExpected;
    }
    public static VerifyQuantity ofElement(int sizeResultProductoFilterBrand) {
        return new VerifyQuantity(sizeResultProductoFilterBrand);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String labelResultElement = Text.of(LABEL_RESULT_ELEMENT).viewedBy(actor).asString();
        System.out.println("- La cantidad de elementos de la lista coincide con los resultados mostrandos por el frontend: "+labelResultElement);
        return String.valueOf(resultExpected).equalsIgnoreCase(labelResultElement);
    }
}

