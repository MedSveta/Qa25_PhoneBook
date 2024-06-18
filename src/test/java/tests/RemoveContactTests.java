package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("sveta1234@gmail.com").withPassword("1234567$Ru"));
        }
        app.getHelperContact().providerContacts();
    }


    @Test
    public void removeFirstContact(){
        //Assert size of ContactList less by one
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);

    }

    @Test
    public void removeAllContacts(){
        //"No contacts Here
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());


    }
}
