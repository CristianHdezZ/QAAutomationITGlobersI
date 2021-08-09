package co.com.itglobers.certification.testqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.itglobers.certification.testqa.userinterface.FilterInHomeBrandPage.*;

public class FilterInHomeBrand implements Task {
    private String strBrand;

    public FilterInHomeBrand(String strBrand) {
        this.strBrand = strBrand;
    }

    public static FilterInHomeBrand withTheKeyword(String strBrand) {
        return Tasks.instrumented(FilterInHomeBrand.class,strBrand);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CATEGORY_BRAND.of(strBrand))
        );

    }
}