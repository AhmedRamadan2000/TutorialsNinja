package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_RegisterationPage {
    WebDriver driver;
    //ToDo: define driver
    public P01_RegisterationPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators
    private final By myAccountDropDownList = By.xpath("//span[@class=\"caret\"]");
    private final By registrationButton = By.xpath("//a[@href=\"https://tutorialsninja.com/demo/index.php?route=account/register\"]");
    private final By firstNameField = By.id("input-firstname");
    private final By lastNameField = By.id("input-lastname");
    private final By emailField = By.id("input-email");
    private final By phoneField = By.id("input-telephone");
    private final By passwordField = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");
    private final By agreeCheckBox = By.name("agree");
    private final By continueButton = By.xpath("//input[@class=\"btn btn-primary\"]");
    private final By congratulationsMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    //define Methods
    public P01_RegisterationPage clickOnAccountDropDownList() {
        driver.findElement(this.myAccountDropDownList).click();
        return this;
    }
    public P01_RegisterationPage clickOnRegistrationButton() {
        driver.findElement(this.registrationButton).click();
        return this;
    }
    public P01_RegisterationPage addFirstName(String FName) {
        driver.findElement(this.firstNameField).sendKeys(FName);
        return this;
    }
    public P01_RegisterationPage addLastName(String LName) {
        driver.findElement(this.lastNameField).sendKeys(LName);
        return this;
    }
    public P01_RegisterationPage addEmail(String email) {
        driver.findElement(this.emailField).sendKeys(email);
        return this;
    }
    public P01_RegisterationPage addPhone(String Phone) {
        driver.findElement(this.phoneField).sendKeys(Phone);
        return this;
    }
    public P01_RegisterationPage addPasswordField(String Password) {
        driver.findElement(this.passwordField).sendKeys(Password);
        return this;
    }
    public P01_RegisterationPage addConfirmPassword(String Password) {
        driver.findElement(this.confirmPassword).sendKeys(Password);
        return this;
    }
    public P01_RegisterationPage clickOnAgreeCheckBox() {
        driver.findElement(this.agreeCheckBox).click();
        return this;
    }
    public P01_RegisterationPage clickOnContinueButton() {
        driver.findElement(this.continueButton).click();
        return this;
    }
    public boolean congratulationsMessage() {
        return driver.findElement(this.congratulationsMessage).getText().equals("Your Account Has Been Created!");
    }
}