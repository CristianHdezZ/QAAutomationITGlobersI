package co.com.itglobers.certification.testqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchInHomePage {
    public static final Target POPUP_CODIGO_POSTAL = Target.the("").located(By.xpath("//*[@id='modal']/div[1]/button"));
    public static final Target INPUT_BUSCAR_PRODUCTO =  Target.the("").located(By.xpath("//*[@placeholder='Buscar productos']"));
    public static final Target BUTTON_BUSCAR_PRODUCTO = Target.the("").located(By.xpath("//*[@placeholder='Buscar productos']/../button"));
}

