package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.RandomMethods;

import java.util.Random;

public class AddNewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User("sveta1234@gmail.com","1234567$Ru"));
        }
    }

    @Test
    public void addNewContactSuccessAll(){
        Contact contact = Contact.builder()
                .name(RandomMethods.randomName())
                .lastName(RandomMethods.randomLastName())
                .phone(RandomMethods.randomPhone(10))
                .email(RandomMethods.randomEmail())
                .address("Haifa, st.Disengof")
                .description("Hai")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isTextInElementPresent_nameContact(contact.getName()));
    }
    @Test
    public void addNewContactSuccess_WODescription(){
        Contact contact = Contact.builder()
                .name(RandomMethods.randomName())
                .lastName(RandomMethods.randomLastName())
                .phone(RandomMethods.randomPhone(10))
                .email(RandomMethods.randomEmail())
                .address("Haifa, st.Disengof")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().clickButtonSave();
        Assert.assertTrue(app.getHelperContact().isTextInElementPresent_nameContact(contact.getName()));

    }
}
