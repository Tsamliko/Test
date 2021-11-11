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

//@Listeners (FinalProject.Chrome.TestLister.class)
public class FinalProject {
    @Test
    public void FinalProject() {
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
    public void negative() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byId("nav-link-accountList-nav-line-1")).click();
        $(byId("ap_email")).setValue("jbcwjcbwjcb@");
        $(byId("continue")).click();
        sleep(1500);
        $(byXpath("//*[@id=\"auth-error-message-box\"]/div/h4")).shouldBe(Condition.visible);
        $(byXpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/div[3]/div/a")).click();
        $(byId("auth-fpp-link-bottom")).click();
        $(byLinkText("Customer Service")).click();
        $(byId("cu-select-firstNode")).selectOption("I forgot my password");

    }

    @Test
    public void BurgerMenu() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byId("nav-hamburger-menu")).click();
        $(byXpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
        $(byXpath("//*[@id=\"hmenu-content\"]/ul[28]/li[3]/a")).click();

    }


    @Test
    public void DeleteCart() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byName("field-keywords")).setValue("playstation gift card").pressEnter();
        $(byLinkText("$25 PlayStation Store Gift Card [Digital Code]")).click();
        $(byName("submit.add-to-cart")).click();
        sleep(1000);
        $(byId("nav-cart-text-container")).click();
        Assert.assertTrue($(byId("nav-cart-text-container")).is(Condition.visible));
        $(byValue("Delete")).click();

    }

    @Test
    public void  Filter() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byName("field-keywords")).setValue("game gift card").pressEnter();
        $(byCssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        $(byId("low-price")).setValue("50");
        $(byId("high-price")).setValue("100");
        $(byCssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        $(byXpath("//*[@id=\"p_n_format_browse-bin/2740964011\"]/span/a/div/label/i")).click();

        






    }

    }








