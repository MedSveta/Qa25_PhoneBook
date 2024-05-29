package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

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

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }
    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of ContactList before remove is-->" + before);
        removeContact();
        int after = countOfContacts();
        logger.info("Number of ContactList after remove is-->" + after);

        return before - after;
    }

    private void removeContact() {
        click(By.className("contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        return wd.findElements(By.className("contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while (countOfContacts() != 0) {
            removeContact();


        }
    }

    public void providerContacts() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                addOneContact();

            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Harry" + i)
                .lastName("Potter")
                .phone("555666777" + i)
                .email("harry" + i + "@gmail.com")
                .address("Hogwards")
                .description("Friend")
                .build();

        openAddForm();
        fillContactForm(contact);
        clickButtonSave();
        pause(500);
    }
}
