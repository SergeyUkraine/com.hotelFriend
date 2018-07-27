import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.dataprovider.LoginData;

import static com.codeborne.selenide.Selenide.$;

public class UITests extends ParametersForWebTest{

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginData.class)
    public void testCanLoginAsValidUser(String email, String password){

        new EmailPage()
                .setUserEmail(email)
                .setUserPassword(password);

        $(By.xpath("//div[@class='TK']")).shouldBe(Condition.visible);

    }

    @Test(dataProvider = "invalidEmailData", dataProviderClass = LoginData.class)
    public void testCannotLoginViaInvalidEmail(String email, String requiredMessage){

        new EmailPage()
                .setUserEmail(email);
        $(By.xpath("//div[@class='LXRPh']/div[2]")).shouldHave(Condition.text(requiredMessage));

    }

    @Test(dataProvider = "invalidPasswordData", dataProviderClass = LoginData.class)
    public void testCannotLoginViaInvalidPassword(String email, String password, String requiredMessage){

        new EmailPage()
                .setUserEmail(email)
                .setUserPassword(password);

        $(By.xpath("//div[@class='LXRPh']/div[2]")).shouldHave(Condition.text(requiredMessage));
    }
}
