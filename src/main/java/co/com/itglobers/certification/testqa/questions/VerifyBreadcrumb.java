package co.com.itglobers.certification.testqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.itglobers.certification.testqa.userinterface.FilterInHomeBrandPage.*;

public class VerifyBreadcrumb implements Question<Boolean> {
    private String resultExpected;

    public VerifyBreadcrumb(String resultExpected) {
        this.resultExpected = resultExpected;
    }

    public static VerifyBreadcrumb with(String strPath) {
        return new VerifyBreadcrumb(strPath);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String labelResultPath = Text.of(BREADCRUMB).viewedBy(actor).asString();
        System.out.println("- En el breadcrumb de la página se encuentre la palabra: "+labelResultPath);
        return resultExpected.equalsIgnoreCase(labelResultPath);
    }
}
