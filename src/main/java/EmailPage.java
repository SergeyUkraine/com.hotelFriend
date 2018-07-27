import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EmailPage {

    public EmailPage openLoginPage(){
        open("/");
        return this;
    }

    private void setEmail(String email){
        $("#identifierId").setValue(email);
    }

    private void clickSignInButton(){
        $(By.xpath("//div[@class='gmail-nav__nav-links-wrap']/a[2]")).click();
    }

    private void clickNextButton(){
        $("#identifierNext").click();
    }

    public PasswordPage setUserEmail(String email){
        openLoginPage();
        clickSignInButton();
        setEmail(email);
        clickNextButton();
        return new PasswordPage();
    }
}
