package New;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


import javax.swing.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TestCase1 {
    @Test
    public void Registration() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byId("nav-link-accountList-nav-line-1")).click();
        sleep(1000);
        $(byId("createAccountSubmit")).click();
        $(byId("ap_customer_name")).setValue("Ani");
        $(byId("ap_email")).setValue("anitsamalashvili13@gmail.com");
        $(byId("ap_password")).setValue("test");
        $(byId("ap_password_check")).setValue("test");
        $(byId("continue")).waitUntil(Condition.visible, 1500);
    }

    @Test
    public void RegNegative() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byId("nav-link-accountList-nav-line-1")).click();
        $(byId("ap_email")).setValue("jbcwjcbwjcb@");
        $(byId("continue")).click();
        Assert.assertTrue($(byXpath("//*[@id=\"auth-error-message-box\"]/div/h4")).is(Condition.visible));
        $(byXpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/div[3]/div/a")).click();
        sleep(1500);
        $(byId("auth-fpp-link-bottom")).click();
        $(byLinkText("Customer Service")).click();
        sleep(1500);
        $(byId("cu-select-firstNode")).selectOption("I forgot my password");


    }

}
