package co.com.itglobers.certification.testqa.tasks;

import co.com.itglobers.certification.testqa.interactions.ConsultBreweryDetail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class BreweryDetail implements Task {
    private String strState;

    public BreweryDetail(String strState) {
        this.strState = strState;
    }

    public static BreweryDetail withTheState(String strState) {
        return Tasks.instrumented(BreweryDetail.class,strState);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ConsultBreweryDetail.withTheState(strState)
        );
    }
}