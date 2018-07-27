import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PasswordPage {

    private void setEmail(String password){
        $(By.name("password")).setValue(password);
    }

    private void clickNextButton(){
        $("#passwordNext").click();
    }

    public GmailInboxPage setUserPassword(String password){
        setEmail(password);
        clickNextButton();
        return new GmailInboxPage();
    }
}
