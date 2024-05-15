package tests;

import lombok.ToString;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(invocationCount = 3)
    public void registrationSuccess(){
        int i = new Random().nextInt(1000);
        int z = (int) (System.currentTimeMillis()/1000)%3600;

        User user = new User("Bingo"+z+"@mail.com", "Qwerty123!");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }


}
