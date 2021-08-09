package co.com.itglobers.certification.testqa.tasks;

import co.com.itglobers.certification.testqa.interactions.FilterListBrewery;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FilterList implements Task {
    private String strKeyName;

    public FilterList(String strKeyName) {
        this.strKeyName = strKeyName;
    }

    public static FilterList withKeyName(String strKeyName) {
        return Tasks.instrumented(FilterList.class,strKeyName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                FilterListBrewery.withKeyName(strKeyName)
        );

    }
}