package co.com.itglobers.certification.testqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.itglobers.certification.testqa.userinterface.SearchInHomePage.*;

public class SearchInHome implements Task {
    private String strKeyword;

    public SearchInHome(String strKeyword) {
        this.strKeyword = strKeyword;
    }

    public static SearchInHome theKeyword(String strKeyword) {
        return Tasks.instrumented(SearchInHome.class,strKeyword);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(POPUP_CODIGO_POSTAL),
                Enter.theValue(strKeyword).into(INPUT_BUSCAR_PRODUCTO),
                Click.on(BUTTON_BUSCAR_PRODUCTO)
        );


    }
}
