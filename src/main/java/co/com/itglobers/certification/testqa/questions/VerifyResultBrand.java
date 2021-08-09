package co.com.itglobers.certification.testqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.itglobers.certification.testqa.util.Constant.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class VerifyResultBrand implements Question<Boolean> {
    private String resultExpected;
    private int sizeList = 0;


    public VerifyResultBrand(String resultExpected) {
        this.resultExpected = resultExpected;
    }

    public static VerifyResultBrand expectedBrand(String listBrandExpected) {
        return new VerifyResultBrand(listBrandExpected);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean resultBool = false;
        SIZE_RESULT_PRODUCTO_FILTER_BRAND = 0;

        List<WebElement> allElementsPaginacion = getDriver().findElements(By.xpath("//*[@id='__next']/div[2]/div[3]/div/div/div[2]/section/ul[2]/li/following-sibling::li[1]/a"));
        int sizePaginacion = allElementsPaginacion.size();
        System.out.println("Paginacion: "+sizePaginacion);

        for (int i=0;i<sizePaginacion;i++){

            allElementsPaginacion = getDriver().findElements(By.xpath("//*[@id='__next']/div[2]/div[3]/div/div/div[2]/section/ul[2]/li/following-sibling::li[1]/a"));
            allElementsPaginacion.get(i).click();

            List<WebElement> allElements = getDriver().findElements(By.xpath("(//*[@name='itemsGrid' and @class='ProductNavigator__SearchResultList-ktvc0v-0 fKgFJs'])[1]//li//div//h3"));
            sizeList = allElements.size()+sizeList;

            System.out.println("Pagina: "+(i+1));
            for (WebElement element: allElements) {
                System.out.println(element.getText());
                if (element.getText().toLowerCase().contains(resultExpected.toLowerCase())){
                    System.out.println("Si contiene el title de la marca filtrada: "+resultExpected);
                    resultBool=true;
                }else {
                    System.out.println("No contiene el title de la marca filtrada: "+resultExpected);
                    resultBool=false;
                    break;
                }
            }

        }

        System.out.println("Tamaño: "+sizeList+"  Resultado comparacion: "+resultBool);
        SIZE_RESULT_PRODUCTO_FILTER_BRAND = sizeList;

        return resultBool;
    }
}