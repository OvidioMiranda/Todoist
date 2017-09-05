package org.fundacionjala.todoist.page.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.todoist.core.CommonActions;
import org.fundacionjala.todoist.core.Env;
import org.fundacionjala.todoist.page.Home;
import org.fundacionjala.todoist.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for the login page.
 */
public class Login extends BasePage {

    private static final String URL = Env.getInstance().getBaseUrl();

    private static final int TIME_WAIT_DURATION = 5;

    private static final Logger LOGGER = LogManager.getLogger();

    //All WebElements are identified by @FindBy annotation.
    @FindBy(xpath = "//ul[@id='top_menu']/descendant::a[contains(@class,'sel_login')]")
    private WebElement loginInButton;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(css = ".submit_btn.amibutton.amibutton_red.sel_login")
    private WebElement loginInFormButton;

    String loginIframe = "GB_frame";


    /**
     * Constructor for Default.
     */
    public Login() {
        loadUrlPage(URL);
    }

    /**
     * This method make click on login button.
     */
    public void clickLoginOptionButton() {
        CommonActions.clickElement(loginInButton);
    }


    /**
     * Set user name in input field.
     *
     * @param username User Name.
     * @return Login pageObject.
     */
    public Login setEmail(String username) {
        CommonActions.setInputField(emailInputField, username);
        return this;
    }

    /**
     * Set password in password input field.
     *
     * @param password Password.
     * @return Login pageObject.
     */
    public Login setPassword(String password) {
        CommonActions.setInputField(passwordInputField, password);
        return this;
    }

    /**
     * This method make click on login button.
     *
     * @return Home pageObject.
     */
    public Home clickLoginForm() {
        CommonActions.clickElement(loginInFormButton);
        return new Home();
    }


    /**
     * This Method make a login.
     *
     * @param email    email.
     * @param password Password.
     * @return Home page after login to application.
     */
    public Home loginAs(String email, String password) {
        clickLoginOptionButton();
        driver.switchTo().frame(loginIframe).switchTo().frame(loginIframe);
        setEmail(email).setPassword(password).clickLoginForm();
        return new Home();
    }

    /**
     * This method verify is the user is logged.
     *
     * @return True if the user is logged.
     */
    public boolean isUserLogged() {
        return getCurrentUrl().contains("https://en.todoist.com/app");
    }
}

