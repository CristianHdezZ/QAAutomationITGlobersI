package co.com.itglobers.certification.testqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class FilterInHomePage {
    public static final Target SUBCATEGORY_AGGREGATION_KEYWORD = Target.the("").locatedBy("//*[@name='categoryAggregation'][contains(text(),'{0}')]/../../li/h4[contains(text(),'{0}')]");
}
