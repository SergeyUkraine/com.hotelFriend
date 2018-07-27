import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParametersForWebTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "http://www.gmail.com";
        Configuration.screenshots = false;
    }

    @BeforeMethod
    public void openGmail(){

        new EmailPage()
                .openLoginPage();
    }
}
