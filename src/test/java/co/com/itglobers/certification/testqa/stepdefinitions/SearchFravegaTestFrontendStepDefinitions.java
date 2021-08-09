package co.com.itglobers.certification.testqa.stepdefinitions;



import co.com.itglobers.certification.testqa.questions.VerifyBreadcrumb;
import co.com.itglobers.certification.testqa.questions.VerifyQuantity;
import co.com.itglobers.certification.testqa.questions.VerifyResultBrand;
import co.com.itglobers.certification.testqa.tasks.FilterInHome;
import co.com.itglobers.certification.testqa.tasks.FilterInHomeBrand;
import co.com.itglobers.certification.testqa.tasks.OpenThePage;
import co.com.itglobers.certification.testqa.tasks.SearchInHome;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;


import static co.com.itglobers.certification.testqa.util.Constant.SIZE_RESULT_PRODUCTO_FILTER_BRAND;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchFravegaTestFrontendStepDefinitions {
    @Before
    public void SetUp(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) ingresa a la home de Frávega$")
    public void IngresaALaHomeDeFrávega(String strActor) throws Exception {
        theActorCalled(strActor).wasAbleTo(OpenThePage.homeTheFravega());
    }
    @When("^busca la palabra$")
    public void buscaLaPalabra(List<String> listKeyword) throws Exception {
        theActorInTheSpotlight().attemptsTo(SearchInHome.theKeyword(listKeyword.get(0)));
    }
    @When("^Filtra desde los filtros de la sección izquierda de la página por$")
    public void filtraDesdeLosFiltrosDeLaSecciónIzquierdaDeLaPáginaPor(List<String> listKeywordFilter) throws Exception {
        theActorInTheSpotlight().attemptsTo(FilterInHome.byKeyword(listKeywordFilter.get(0)));
    }
    @When("^Filtra en sección izquierda de la página por la marca$")
    public void filtraEnSecciónIzquierdaDeLaPáginaPorLaMarca(List<String> listBrand) throws Exception {
        theActorInTheSpotlight().attemptsTo(FilterInHomeBrand.withTheKeyword(listBrand.get(0)));
    }
    @Then("^cada uno de los elementos contenga en su title la marca filtrada$")
    public void cadaUnoDeLosElementosContengaEnSuTitleLaMarcaFiltrada(List<String> listBrandExpected) throws Exception {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyResultBrand.expectedBrand(listBrandExpected.get(0))));
    }
    @Then("^la cantidad de elementos de la lista coincida con los resultados mostrandos por el frontend$")
    public void laCantidadDeElementosDeLaListaCoincidaConLosResultadosMostrandosPorElFrontend() throws Exception {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyQuantity.ofElement(SIZE_RESULT_PRODUCTO_FILTER_BRAND)));
    }
    @Then("^en el breadcrumb de la página se encuentre la palabra$")
    public void enElBreadcrumbDeLaPáginaSeEncuentreLaPalabra(List<String> listPath) throws Exception {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyBreadcrumb.with(listPath.get(0))));
    }
}
