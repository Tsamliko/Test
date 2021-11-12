package New;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TestCase3 {
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
}
