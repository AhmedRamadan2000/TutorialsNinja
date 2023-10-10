package testcases;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_RegisterationPage;
import utility.Utilities;

@Epic("Confirm Order Feature")
@Story("Confirm the order information")
public class TC01_Registration extends TestBase{
    public static Faker faker = new Faker();
    public static String EMAIL = faker.internet().emailAddress();
    public static String FName = faker.name().firstName();
    public static String LastName = faker.name().lastName();
    public static String phone = faker.phoneNumber().cellPhone();
//    public static String password = faker.internet().password();
    private String password = Utilities.getdata(System.getProperty("User.dir")+ "/src/test/resources/data/loginData.json","Password");
    @Test(priority = 1, description = "Register with valid data")
    @Description("Register with valid data")
    @Severity(SeverityLevel.CRITICAL)
    public void RegisterNewUserWithValidData_P() {

        new P01_RegisterationPage(driver).clickOnAccountDropDownList().clickOnRegistrationButton().addFirstName(FName).addLastName(LastName)
              .addEmail(EMAIL).addPhone(phone).addPasswordField(password).addConfirmPassword(password).clickOnAgreeCheckBox().clickOnContinueButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "RegisterWithNewUser");

        //ToDo: Assert the user register successfully
        Assert.assertTrue(new P01_RegisterationPage(driver).congratulationsMessage());
        System.out.println(EMAIL);
        System.out.println(password);
    }
}