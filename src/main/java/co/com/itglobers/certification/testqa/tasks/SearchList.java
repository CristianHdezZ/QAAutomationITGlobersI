package co.com.itglobers.certification.testqa.tasks;



import co.com.itglobers.certification.testqa.interactions.SearchListOfBreweries;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SearchList implements Task {
    private String strName;

    public SearchList(String name) {
        this.strName = name;
    }

    public static SearchList ofBreweries(String listName) {
        return Tasks.instrumented(SearchList.class,listName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SearchListOfBreweries.inTheAPI(strName)
        );
    }
}
