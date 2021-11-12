package New;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TestCase2 {
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
    public void BurgerMenu() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
        $(byId("nav-hamburger-menu")).click();
        $(byXpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
        $(byXpath("//*[@id=\"hmenu-content\"]/ul[28]/li[3]/a")).click();
        sleep(5000);

    }
}
