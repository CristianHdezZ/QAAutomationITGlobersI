package co.com.itglobers.certification.testqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class FilterInHomeBrandPage {
    public static final Target CATEGORY_BRAND = Target.the("").locatedBy("//*[contains(text(),'Marca')]/../..//input[@value='{0}']/..");
    public static final Target LIST_PRODUCT = Target.the("").locatedBy("(//*[@name='itemsGrid' and @class='ProductNavigator__SearchResultList-ktvc0v-0 fKgFJs'])[1]//li//div//h3");
    public static final Target LABEL_RESULT_ELEMENT = Target.the("").locatedBy("//*[@name='totalResult']/span");
    public static final Target BREADCRUMB = Target.the("").locatedBy("//*[@id='__next']/div[2]/div[3]/div/div/div[1]/ol/li[5]");
}
