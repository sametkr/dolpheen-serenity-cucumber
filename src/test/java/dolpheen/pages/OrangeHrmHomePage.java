package dolpheen.pages;

import net.serenitybdd.screenplay.targets.Target;

public class OrangeHrmHomePage {

    public static Target USER_USERNAME = Target.the("Username").locatedBy("//input[@name='username']");
    public static Target USER_PASSWORD = Target.the("Password").locatedBy("//input[@name='password']");
    public static Target LOG_IN_BUTTON = Target.the("Log in").locatedBy("//button[@type='submit']");
    public static Target ERROR_MESSAGE = Target.the("Invalid Credentials").locatedBy("//div[@class='orangehrm-login-error']/div/div/p");
}


