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




    @Test
    public void BurgerMenu() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byId("nav-hamburger-menu")).click();
        $(byXpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
        $(byXpath("//*[@id=\"hmenu-content\"]/ul[28]/li[3]/a")).click();
        sleep(5000);

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

   @Test
    public void ReviewPage() {
       WebDriverManager.firefoxdriver().setup();
       Configuration.startMaximized = true;
       Selenide.open("https://www.amazon.com/s?k=black+friday+deals+2021&crid=D24428MFQC15&sprefix=black+friday+de%2Caps%2C343&ref=nb_sb_ss_ts-doa-p_1_15");
       $(byXpath("//*[@id=\"p_72/1248879011\"]/span/a/section/span")).click();
       $(byXpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[2]/div/div/div[2]/div/span[1]/span/a/i[2]")).click();
       $(byXpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[2]/div/div/div[2]/div/span[1]/span/a/i[2]")).click();
       $(byXpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[1]/span[1]/a")).waitUntil(Condition.visible, 1000);
       $(byXpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[1]/span[1]/a")).click();

    }



@Test
    public void SortPage() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byXpath("//*[@id=\"searchDropdownBox\"]")).selectOption("Women's Fashion");
        $(byId("twotabsearchtextbox")).setValue("clothing for women");
        $(byId("nav-search-submit-button")).click();
        $(byXpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")).click();
        $(byId("s-result-sort-select_1")).click();
        sleep(1000);
    }












    }








