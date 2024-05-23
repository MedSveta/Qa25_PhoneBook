package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddForm() {
        pause(5000);
        click(By.xpath("//a[@href='/add']"));
    }
    public void fillContactForm(Contact contact){
        type(By.xpath("//input[@placeholder='Name']"),contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"),contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"),contact.getDescription());
    }
    public void clickButtonSave() {
        click(By.xpath("//button/b[text()='Save']"));
    }

    public boolean isTextInElementPresent_nameContact(String name){
        return isTextInElementPresent(By.xpath("//div[@class='contact-page_leftdiv__yhyke']/div/div[last()]/h2"), name);
    }
}
