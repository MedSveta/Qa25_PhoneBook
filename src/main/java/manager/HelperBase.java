package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public  void  type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text!=null){
            element.sendKeys(text);
        }
    }
    public void  clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }


    public void click(By locator){
       WebElement element = wd.findElement(locator);
       element.click();
    }
    public boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        if(alert!=null&&alert.getText().contains(message)){
          //click OK ---> alert.accept();
            alert.accept();
            return true;
        }
        return false;
    }

    public boolean isTextInElementPresent(By locator, String text){
        WebElement element = wd.findElement(locator);
        return element.getText().equals(text);
    }
    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list){
            if (el.getText().equals(phone)){
                return true;
            }
        }
        return false;
    }
}
