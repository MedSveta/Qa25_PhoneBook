package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sveta1234@gmail.com", "1234567$Ru");
        app.getHelperUser().submitLogin();
    }
}
