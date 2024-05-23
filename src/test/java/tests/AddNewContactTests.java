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
                .description("All fields")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isTextInElementPresent_nameContact(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
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
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName(RandomMethods.randomLastName())
                .phone(RandomMethods.randomPhone(10))
                .email(RandomMethods.randomEmail())
                .address("Haifa, st.Disengof")
                .description("Wrong Name")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }
    @Test void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name(RandomMethods.randomName())
                .lastName("")
                .phone(RandomMethods.randomPhone(10))
                .email(RandomMethods.randomEmail())
                .address("Haifa, st.Disengof")
                .description("Wrong LastName")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }
    @Test void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name(RandomMethods.randomName())
                .lastName(RandomMethods.randomLastName())
                .phone(RandomMethods.randomPhone(7))
                .email(RandomMethods.randomEmail())
                .address("Haifa, st.Disengof")
                .description("Wrong phone")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }
    @Test void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name(RandomMethods.randomName())
                .lastName(RandomMethods.randomLastName())
                .phone(RandomMethods.randomPhone(10))
                .email("dertsmail.com")
                .address("Haifa, st.Disengof")
                .description("Wrong email")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid: "));

    }
    @Test void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name(RandomMethods.randomName())
                .lastName(RandomMethods.randomLastName())
                .phone(RandomMethods.randomPhone(10))
                .email(RandomMethods.randomEmail())
                .address("")
                .description("Wrong address")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().clickButtonSave();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

}
