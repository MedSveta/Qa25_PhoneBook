package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234@gmail.com", "1234567$Ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234@gmail.com", "1234567$Ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234gmail.com", "1234567$Ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234@gmail.com", "1234567$ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234rec@gmail.com", "1234567$Su"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

}
