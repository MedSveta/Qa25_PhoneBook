package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public  void openLoginRegistrationForm(){
//        WebElement loginTab = wd.findElement(By.cssSelector("a[]href='/login']"));
       // loginTab.click();
        click(By.cssSelector("a[href='/login']"));

   }

public void  fillLoginRegistrationForm(User user){

    type(By.name("email"), user.getEmail());
    type(By.xpath("//input[last()]"), user.getPassword());

}
public  void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
}
public  void submitRegistration(){
        click(By.xpath("//button[text()='Registration']"));
}

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }
}
