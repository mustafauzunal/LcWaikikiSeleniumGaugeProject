import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest{


    @Step("<url> li ve <name> isimli sayfa açık mı")
    public void assertTrue(String url,String name){
        assertEquals(name + " isimli sayfada değilsiniz",driver.getCurrentUrl(),url);
        Logger.info(name + " isimli sayfadasınız");
    }


    @Step("<xpath1> li elementin üzerine gelip menüden <xpath2> li elemente tıklama")
    public void hover(String xpath1,String xpath2) throws InterruptedException {
        Thread.sleep(1000);
        WebElement mainMenu = driver.findElement(By.xpath(xpath1));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();
        Thread.sleep(1000);
        WebElement subMenu = driver.findElement(By.xpath(xpath2));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    @Step("<xpath1> li elementin üzerine gelip tıklayarak menüden <xpath2> li elemente tıklama")
    public void hoverOver(String xpath1,String xpath2) throws InterruptedException {

        WebElement mainMenu = driver.findElement(By.xpath(xpath1));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).click().build().perform();
        WebElement subMenu = driver.findElement(By.xpath(xpath2));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

    }

    @Step("<xpath> li listeden ilk 3 ürünü favorilere ekle")
    public void addToFav(String xpath) throws InterruptedException {
        List<WebElement> li = driver.findElements(By.xpath(xpath));
        li.get(0).click();
        Thread.sleep(500);
        li.get(1).click();
        Thread.sleep(500);
        li.get(2).click();

    }

    @Step("<xpath> li listede 3 eleman var mı?")
    public  void listControl(String xpath){
        boolean x = false;
        List<WebElement> li = driver.findElements(By.xpath(xpath));
        if(li.size()==3){
            x = true;
        }

        Assert.assertTrue("Favoriye eklenen 3 ürün görünmüyor",x);
        Logger.info("Favoriye eklenen 3 ürün görünüyor");
    }

    @Step("<xpath> li listede 3 eleman da seçildi mı?")
    public  void listCheckControl(String xpath){
        boolean x = false;
        List<WebElement> li = driver.findElements(By.xpath(xpath));
        if(li.size()==3){
            x = true;
        }

        Assert.assertTrue("Favoriye eklenen 3 ürün de seçilmedi",x);
        Logger.info("Favoriye eklenen 3 ürün de seçilmiştir");
    }

    @Step("<css> li elementin içinde Favori Ürününüz Yok yazıyor mu?")
    public void checkWritten(String xpath) throws InterruptedException {
        Thread.sleep(1000);
        String x = driver.findElement(By.cssSelector(xpath)).getText();
        String y = "Favori Ürününüz Yok";
        Assert.assertEquals("Favori ürününüz yok yazmıyor",y , x);
        Logger.info("Favori Ürününüz Yok metni sayfadadır");
    }

    @Step("<xpath> li elementin içinde En Yüksek Fiyat yazıyor mu?")
    public void checkWrittenFiyat(String xpath) throws InterruptedException {
        Thread.sleep(1000);
        String x = driver.findElement(By.xpath(xpath)).getText();
        String y = "En Yüksek Fiyat";
        Assert.assertEquals("En Yüksek Fiyat yazmıyor",y , x);
        Logger.info("En Yüksek Fiyat metni sayfadadır");
    }



    @Step("<xpath> li elemente tıkla")
    public void clickOnce(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click().build().perform();
    }

}
