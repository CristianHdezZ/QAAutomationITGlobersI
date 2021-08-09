package co.com.itglobers.certification.testqa.stepdefinitions;

import co.com.itglobers.certification.testqa.questions.VerifyResultBreweries;
import co.com.itglobers.certification.testqa.tasks.BreweryDetail;
import co.com.itglobers.certification.testqa.tasks.FilterList;
import co.com.itglobers.certification.testqa.tasks.SearchList;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CerveceriasTestBackendStepdefinition {
    @Before
    public void SetUp(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) obtiene una lista de cervecerías que contengan en su nombre, el texto$")
    public void cristianObtieneUnaListaDeCerveceríasQueContenganEnSuNombreElTexto(String strActor, List<String> listName) throws Exception {
        theActorCalled(strActor).wasAbleTo(SearchList.ofBreweries(listName.get(0)));
    }
    @When("^de la lista de resultados toma aquellos que contengan en la key name, el valor$")
    public void deLaListaDeResultadosTomaAquellosQueContenganEnLaKeyNameElValor(List<String> lisKeyName) throws Exception {
        theActorInTheSpotlight().attemptsTo(FilterList.withKeyName(lisKeyName.get(0)));
    }
    @When("^por cada elemento de la lista anterior pedir el detalle en API y tomar solo aquel que contenga$")
    public void porCadaElementoDeLaListaAnteriorPedirElDetalleEnAPIYTomarSoloAquelQueContenga(List<String> listState) throws Exception {
        theActorInTheSpotlight().attemptsTo(BreweryDetail.withTheState(listState.get(0)));
    }
    @Then("^Sobre la cervecería resultante, assertar lo siguiente$")
    public void sobreLaCerveceríaResultanteAssertarLoSiguiente(List<String> listDatosExpected) throws Exception {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyResultBreweries.with(listDatosExpected.get(0),listDatosExpected.get(1),listDatosExpected.get(2))));
    }
}
