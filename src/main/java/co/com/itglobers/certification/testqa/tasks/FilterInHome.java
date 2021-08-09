package co.com.itglobers.certification.testqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.itglobers.certification.testqa.userinterface.FilterInHomePage.*;

public class FilterInHome implements Task {
    private String strKeyword;

    public FilterInHome(String strKeyword) {
        this.strKeyword = strKeyword;
    }

    public static FilterInHome byKeyword(String strKeywordFilter) {
        return Tasks.instrumented(FilterInHome.class,strKeywordFilter);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SUBCATEGORY_AGGREGATION_KEYWORD.of(strKeyword))
        );

    }
}