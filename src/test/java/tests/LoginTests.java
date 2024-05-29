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
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data --> : email:'sveta1234@gmail.com' & password: '1234567$Ru'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234@gmail.com", "1234567$Ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data --> : email:'sveta1234@gmail.com' & password: '1234567$Ru'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234@gmail.com", "1234567$Ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data --> : email:'sveta1234gmail.com' & password: '1234567$Ru'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234gmail.com", "1234567$Ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert  present with error text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data --> : email:'sveta1234@gmail.com' & password: '1234567$ru'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234@gmail.com", "1234567$ru"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert  present with error text 'Wrong email or password'");
    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data --> : email:'sveta1234rec@gmail.com' & password: '1234567$Su'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User("sveta1234rec@gmail.com", "1234567$Su"));
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert  present with error text 'Wrong email or password'");
    }

}
