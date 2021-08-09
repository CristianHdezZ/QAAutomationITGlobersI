package co.com.itglobers.certification.testqa.tasks;

import co.com.itglobers.certification.testqa.userinterface.HomePageFravega;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenThePage implements Task {
    private HomePageFravega homePageFravega;

    public static OpenThePage homeTheFravega() {
        return Tasks.instrumented(OpenThePage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePageFravega));
    }
}

